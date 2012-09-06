package org.hardcode.juf;

import org.hardcode.juf.status.UpdateInfo;

import java.util.HashMap;


/**
 * Interfaz a implementar por las actualizaciones
 *
 * @author Fernando González Cortés
 */
public interface Installer {
    /**
     * Método invocado cuando se ha descargado el jar de actualización
     *
     * @param clientStatus Estado asignado por el cliente para la ejecución de la actualización
     * @param status actualización residente en el cliente
     * @param listener escuchador del progreso de la actualización. Puede ser
     *        null
     *
     * @return DOCUMENT ME!
     */
    public UpdateInfo install(HashMap clientStatus, UpdateInfo status,
        ProgressListener listener) throws InstallException;
}
