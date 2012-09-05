/*
 * Created on 14-nov-2004
 */
package org.hardcode.juf;

import org.hardcode.juf.status.Status;
import org.hardcode.juf.status.UpdateInfo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


/**
 * DOCUMENT ME!
 *
 * @author Fernando González Cortés
 */
public class JUpdateUtilities extends ListenerSupportImpl {
    /**
     * DOCUMENT ME!
     *
     * @param url
     * @param temp
     *
     * @throws IOException
     * @throws NoServerFileException
     */
    public void download(URL url, File temp)
        throws IOException, NoServerFileException {
        URLConnection conn = null;
        InputStream is = null;

        try {
            conn = url.openConnection();
            is = url.openStream();
        } catch (IOException e) {
            throw new NoServerFileException(e.getMessage());
        }

        DataInputStream dis = new DataInputStream(is);
        int size = conn.getContentLength();

        DataOutputStream dos;
        dos = new DataOutputStream(new FileOutputStream(temp));

        if (size != 0) {
            byte[] buffer = new byte[10240];
            int n;
            int completed = 0;

            while ((n = dis.read(buffer)) == 10240) {
                completed += n;
                dos.write(buffer);

                notifyProgress((100 * completed) / size);
            }

            dos.write(buffer, 0, n);
        } else {
            byte[] buffer = new byte[10240];
            int n;

            while ((n = dis.read(buffer)) == 10240) {
                dos.write(buffer);
            }

            dos.write(buffer, 0, n);
        }

        dis.close();
        dos.close();
    }

    /**
     * DOCUMENT ME!
     *
     * @param source DOCUMENT ME!
     * @param dest DOCUMENT ME!
     *
     * @throws IOException DOCUMENT ME!
     */
    public void copy(File source, File dest) throws IOException {
        FileChannel in = null;
        FileChannel out = null;

        try {
            in = new FileInputStream(source).getChannel();
            out = new FileOutputStream(dest).getChannel();

            long size = in.size();
            MappedByteBuffer buf = in.map(FileChannel.MapMode.READ_ONLY, 0, size);

            out.write(buf);
        } finally {
            if (in != null) {
                in.close();
            }

            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * Obtiene el estado de la actualización del componente cuyo nombre se pasa
     * como parámetro buscando en la información que se pasa como primer parámetro
     *
     * @param status Información de las actualizaciones de toda la aplicación
     * @param componentName Nombre del componente cuya información se quiere obtener
     *
     * @return La información buscada o null si no información sobre un componente
     * de nombre 'componentName' en el objeto UpdateInfo
     */
    public Status getComponentStatus(UpdateInfo status, String componentName) {
        Status[] componentStatus = status.getStatus();
        for (int i = 0; i < componentStatus.length; i++) {
			if (componentStatus[i].getComponentName().equals(componentName)){
				return componentStatus[i];
			}
		}
        
        return null;
    }
}
