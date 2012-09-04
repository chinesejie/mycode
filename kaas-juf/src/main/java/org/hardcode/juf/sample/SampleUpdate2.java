package org.hardcode.juf.sample;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.hardcode.juf.InstallException;
import org.hardcode.juf.Installer;
import org.hardcode.juf.JUpdateUtilities;
import org.hardcode.juf.NoServerFileException;
import org.hardcode.juf.ProgressListener;
import org.hardcode.juf.status.Status;
import org.hardcode.juf.status.UpdateInfo;

/**
 * 
 */
public class SampleUpdate2 implements Installer{

	/**
	 * @throws InstallException
	 * @see org.hardcode.juf.Installer#install(java.util.HashMap, org.hardcode.jupdate.status.UpdateInfo, org.hardcode.jupdate.ProgressListener)
	 */
	public UpdateInfo install(HashMap clientStatus, UpdateInfo status, ProgressListener listener) throws InstallException {
		System.out.println("I am server2");
		
		return status;
	}

}
