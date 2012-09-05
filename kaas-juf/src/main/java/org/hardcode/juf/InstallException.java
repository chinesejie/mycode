package org.hardcode.juf;

/**
 * Excepción genérica que indica un fallo en la ejecución de una actualización
 */
public class InstallException extends Exception {
    /**
     *
     */
    public InstallException() {
        super();
    }

    /**
     * DOCUMENT ME!
     *
     * @param message
     */
    public InstallException(String message) {
        super(message);
    }

    /**
     * DOCUMENT ME!
     *
     * @param message
     * @param cause
     */
    public InstallException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * DOCUMENT ME!
     *
     * @param cause
     */
    public InstallException(Throwable cause) {
        super(cause);
    }
}
