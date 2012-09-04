/*
 * Created on 14-nov-2004
 */
package org.hardcode.juf;

/**
 * DOCUMENT ME!
 *
 * @author Fernando González Cortés
 */
public class BadConfigurationException extends Exception {
    /**
    	 *
    	 */
    public BadConfigurationException() {
        super();
    }

    /**
     * DOCUMENT ME!
     *
     * @param arg0
     */
    public BadConfigurationException(String arg0) {
        super(arg0);
    }

    /**
     * DOCUMENT ME!
     *
     * @param arg0
     * @param arg1
     */
    public BadConfigurationException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * DOCUMENT ME!
     *
     * @param arg0
     */
    public BadConfigurationException(Throwable arg0) {
        super(arg0);
    }
}
