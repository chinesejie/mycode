/*
 * Created on 13-nov-2004
 */
package org.hardcode.juf;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Fernando González Cortés
 */
class ListenerSupportImpl implements ListenerSupport{

	private transient ArrayList listeners = new ArrayList();

	/**
	 * DOCUMENT ME!
	 *
	 * @param listener DOCUMENT ME!
	 */
	public void addProgressListener(ProgressListener listener) {
	    listeners.add(listener);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param progress DOCUMENT ME!
	 */
	public void notifyProgress(int progress) {
	    for (Iterator iter = listeners.iterator(); iter.hasNext();) {
	        ProgressListener listener = (ProgressListener) iter.next();
	        listener.progress(progress);
	    }
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param progress DOCUMENT ME!
	 */
	public void notifyFileProgress(int progress) {
	    for (Iterator iter = listeners.iterator(); iter.hasNext();) {
	        UpdateListener listener = (UpdateListener) iter.next();
	        listener.fileProgress(progress);
	    }
	}
	
	
	

}
