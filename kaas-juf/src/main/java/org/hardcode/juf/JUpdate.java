/*
 * Created on 14-nov-2004
 */
package org.hardcode.juf;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

import org.hardcode.juf.status.Status;
import org.hardcode.juf.status.UpdateInfo;
import org.hardcode.juf.update.Update;
import org.hardcode.juf.update.Updates;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Clase base de la librer�a
 *
 * @author Fernando Gonz�lez Cort�s
 */
public class JUpdate {
    /**
     * Crea un update con los datos del fichero que se pasa como par�metro
     *
     * @param name Nombre de la actualizaci�n
     * @param file Fichero con la informaci�n de la actualizaci�n inicial
     *
     * @return Devuelve la informaci�n que el cliente tiene sobre la
     *         actualizaci�n cuyo nombre se pasa como par�metro. Si hay
     *         informaci�n en el cliente se lee la misma, si no la hay se
     *         obtiene la informaci�n del fichero que se pasa como  par�metro
     *
     * @throws IOException Si se produce un error leyendo los datos del fichero
     *         que se pasa como par�metro
     * @throws RuntimeException DOCUMENT ME!
     */
    public UpdateInfo getClientUpdateInformation(String name)
        throws IOException {
        //Trata de leer la informaci�n
        try {
            return getUpdateStatus(name);
        } catch (ClientStatusException e) {
            return null;
        }
    }

    /**
     * Realiza la actualizaci�n
     *
     * @param clientStatus HashMap que se pasa a las actualizaciones cuando se
     *        ejecutan
     * @param name Nombre de la aplicaci�n a la que pertenece la actualizaci�n
     *        u
     * @param u Actualizacion que se quiere instalar
     * @param listener Listener de eventos
     *
     * @throws BadConfigurationException Si la informaci�n descriptiva de la
     *         actualizaci�n en el servidor no es correcta
     * @throws ClientStatusException Si no se puede actualizar el estado de la
     *         actualizaci�n en el cliente tras haberla ejecutado por
     *         problemas de formato
     * @throws InstallException Si se produce un error en la ejecuci�n
     *         instalaci�n
     * @throws IOException Si falla al actualizar el estado de la actualizaci�n
     *         en el cliente
     */
    public void doUpdate(HashMap clientStatus, UpdateInfo clientUpdateInfo, String name, Update u,
        ProgressListener listener)
        throws BadConfigurationException, ClientStatusException, 
            InstallException, IOException {
    	//System.out.println("ssssssssssssssssssssssssssssssssssssssssssss");
        URL jarURL;
        Installer installer = null;

        try {
            jarURL = new URL(u.getInstaller().getJarUrl());

            URLClassLoader loader = new URLClassLoader(new URL[] { jarURL });
            
            Class c = loader.loadClass(u.getInstaller().getClassName());
            //System.out.println(c.getName()+"------------------------");
            //File f = new File("F://1ttt");
           // f.mkdirs();
            installer = (Installer) c.newInstance();
        } catch (MalformedURLException e) {
            throw new BadConfigurationException(e);
        } catch (ClassNotFoundException e) {
            throw new BadConfigurationException(e);
        } catch (InstantiationException e) {
            throw new BadConfigurationException(e);
        } catch (IllegalAccessException e) {
            throw new BadConfigurationException(e);
        }

        
        //installer.install(clientStatus, clientUpdateInfo, listener);
        setUpdateStatus(name,installer.install(clientStatus, clientUpdateInfo, listener));
        //1st,5th parameter are null.
        //HashMap clientStatus, ProgressListener listener
        
        
    }

    /**
     * Obtiene el estado correspondiente al componente con nombre componentName
     * que se encuentra en el objeto UpdateInfo que se pasa como par�metro
     *
     * @param ui Informaci�n de la actualizaci�n
     * @param packageName Nombre del componente del cual se quiere obtener su
     *        estado
     *
     * @return Estado del componente o null si no se encuentra un componente
     *         con ese nombre en el UpdateInfo
     */
    private Status getStatus(UpdateInfo ui, String packageName) {
        Status[] status = ui.getStatus();

        for (int i = 0; i < status.length; i++) {
            if (status[i].getComponentName().equals(packageName)) {
                return status[i];
            }
        }

        return null;
    }

    /**
     * Obtiene la informaci�n del servidor sobre las actualizaciones
     * disponibles posteriores a la versi�n actual
     *
     * @param name Nombre de la actualizaci�n
     * @param listener Listener del progreso
     *
     * @return Updates disponibles
     *
     * @throws DownloadException Si la actualizaci�n existe pero no se puede
     *         descargar
     * @throws ClientStatusException Si la actualizaci�n se descarg� pero no se
     *         comprende el contenido
     * @throws IOException Si falla el proceso de forma gen�rica
     */
    public Update[] checkUpdates(String name, UpdateInfo clientUpdateInfo, ProgressListener listener)
        throws DownloadException, ClientStatusException, IOException {

        Updates serverStatus = getUpdate(clientUpdateInfo, listener);
        Update[] todas = serverStatus.getUpdate();
        ArrayList updates = new ArrayList();

        for (int i = 0; i < todas.length; i++) {
            Status estado = getStatus(clientUpdateInfo, todas[i].getComponentName());

            if (estado == null) {
                updates.add(todas[i]);
            } else {
                if (estado.getVersion() < todas[i].getVersion()) {
                    updates.add(todas[i]);
                }
            }
        }

        return (Update[]) updates.toArray(new Update[0]);
    }

    /**
     * Obtiene la informaci�n de la actualizaci�n
     *
     * @param st Informaci�n de la actualizaci�n que se quiere descargar
     * @param listener Listener del proceso
     *
     * @return Jupdate
     *
     * @throws DownloadException Si no se pudo descargar la informaci�n de la
     *         update pero �sta existe
     * @throws ClientStatusException No se entiende el descriptor de
     *         actualizacion
     * @throws IOException Si falla el proceso de forma gen�rica
     * @throws RuntimeException DOCUMENT ME!
     */
    private Updates getUpdate(UpdateInfo st, ProgressListener listener)
        throws DownloadException, ClientStatusException, IOException {
        URL url;

        try {
            url = new URL(st.getUrlPrefix());
        } catch (MalformedURLException e2) {
            throw new RuntimeException("URL no v�lida");
        }

        /*
           File temp;
           temp = File.createTempFile("Jupdate", ".xml");
           temp.deleteOnExit();
           JUpdateUtilities juu = new JUpdateUtilities();
           if (listener != null) {
               juu.addProgressListener(listener);
           }
           try {
               juu.download(url, temp);
           } catch (IOException e4) {
               throw new DownloadException(e4);
           }
         */
        try {
        /*	InputStreamReader isr = new InputStreamReader(url.openStream());
			int b;
			while ((b = isr.read()) != -1)
			{
				System.out.print((char) b);
			}
			isr.close();*/

        	
            Updates update = (Updates) Updates.unmarshal(new InputStreamReader(
                        url.openStream()));

            return update;
        } catch (MarshalException e) {
            throw new ClientStatusException(e);
        } catch (ValidationException e) {
            throw new ClientStatusException(e);
        }
    }

    /**
     * Obtiene el estado de la actualizaci�n de nombre name
     *
     * @param name Nombre de la actualizaci�n
     *
     * @return La informaci�n de la actualizaci�n o null si no hay
     * ninguna actualizaci�n instalada
     *
     * @throws ClientStatusException
     */
    private UpdateInfo getUpdateStatus(String name)
        throws ClientStatusException {
        try {
            File f = getFile(name);
            UpdateInfo info = (UpdateInfo) UpdateInfo.unmarshal(new FileReader(
                        f));

            return info;
        } catch (MarshalException e) {
            throw new ClientStatusException(e);
        } catch (ValidationException e) {
            throw new ClientStatusException(e);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param name DOCUMENT ME!
     * @param info
     *
     * @throws ClientStatusException
     * @throws IOException
     */
    private void setUpdateStatus(String name, UpdateInfo info)
        throws ClientStatusException, IOException {
        try {
            File f = getFile(name);
            info.marshal(new FileWriter(f));
        } catch (MarshalException e) {
            throw new ClientStatusException(e);
        } catch (ValidationException e) {
            throw new ClientStatusException(e);
        }
    }

    /**
     * Obtiene el fichero asociado a una actualizaci�n
     *
     * @param updateName Nombre de la actualizaci�n
     *
     * @return Fichero de la actualizaci�n. Puede no existir
     */
    private File getFile(String updateName) {
        File ret = new File(System.getProperty("user.home") + File.separator +
                "juf/org.hardcode.juf.JUpdate." + updateName + ".xml");

        return ret;
    }
}
