package org.hardcode.juf.sample;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;

import org.hardcode.juf.BadConfigurationException;
import org.hardcode.juf.ClientStatusException;
import org.hardcode.juf.DownloadException;
import org.hardcode.juf.InstallException;
import org.hardcode.juf.JUpdate;
import org.hardcode.juf.status.UpdateInfo;
import org.hardcode.juf.ui.UpdatePanel;
import org.hardcode.juf.update.Update;

/**
 * 
 */
public class JUpdateClientSample {

	public static void main(String[] args) {
		JUpdateClientSample jus = new JUpdateClientSample();
		jus.run();
	}
	
	public void run(){
		JUpdate update = new JUpdate();
		UpdateInfo clientUpdateInfo = null;
		try {
			clientUpdateInfo = update.getClientUpdateInformation("sample");
			if (clientUpdateInfo == null) {
			    clientUpdateInfo = new UpdateInfo();
			    clientUpdateInfo.setUrlPrefix("http://127.0.0.1:8080/juf/update.xml");
			}
		} catch (IOException e) {
			System.err.println("No se pudo obtener la informaci�n de la actualizaci�n");
			System.exit(-1);
		}
		
		Update[] actualizaciones = null;
		try {
			actualizaciones = update.checkUpdates("sample", clientUpdateInfo, null);
			UpdatePanel up = new UpdatePanel();
			up.setModel(actualizaciones);
			JDialog jf = new JDialog();
			//jf.setModal(true);
			
			jf.setModalityType(ModalityType.APPLICATION_MODAL);
			jf.getContentPane().add(up);
			jf.setSize(new Dimension(400, 400));
			//jf.show();//过时了、、
			jf.setVisible(true);
			//System.out.println("==================================");
			actualizaciones = up.getSelectedUpdates();
		
		} catch (DownloadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClientStatusException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			for (int i = 0; i < actualizaciones.length; i++) {
				
				update.doUpdate(null, clientUpdateInfo, "sample", actualizaciones[i], null);
			}
		} catch (BadConfigurationException e2) {
			e2.printStackTrace();
		} catch (ClientStatusException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (InstallException e) {
			e.printStackTrace();
		}
		JFrame js = new JFrame();
		js.setVisible(true);
		//System.exit(0);
	}
}
