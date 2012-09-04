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
public class SampleUpdate implements Installer{

	/**
	 * @throws InstallException
	 * @see org.hardcode.juf.Installer#install(java.util.HashMap, org.hardcode.jupdate.status.UpdateInfo, org.hardcode.jupdate.ProgressListener)
	 */
	public UpdateInfo install(HashMap clientStatus, UpdateInfo status, ProgressListener listener) throws InstallException {
		JUpdateUtilities jup = new JUpdateUtilities();
		Status componentStatus = jup.getComponentStatus(status, "sample-component");
		
		if (componentStatus == null){
			componentStatus = new Status();
			componentStatus.setComponentName("sample-component");
			componentStatus.setVersion(new Long("1"));
			status.addStatus(componentStatus);
		}else{
			componentStatus.setVersion(componentStatus.getVersion() + 1);
		}
		
		try {
			jup.download(new URL("http://localhost:8080/juf/jupdate-1.0.jar"), new File("jubajadaopdate-1.0.jar"));
		} catch (NoServerFileException e) {
			throw new InstallException(e);
		} catch (MalformedURLException e) {
			throw new InstallException(e);
		} catch (IOException e) {
			throw new InstallException(e);
		}
		
		return status;
	}

}
