/*
 * Created on 14-nov-2004
 */
package org.hardcode.juf;

/**
 * @author Fernando González Cortés
 */
public class DownloadException extends Exception {

	/**
	 * 
	 */
	public DownloadException() {
		super();
	}
	/**
	 * @param arg0
	 */
	public DownloadException(String arg0) {
		super(arg0);
	}
	/**
	 * @param arg0
	 * @param arg1
	 */
	public DownloadException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	/**
	 * @param arg0
	 */
	public DownloadException(Throwable arg0) {
		super(arg0);
	}
}
