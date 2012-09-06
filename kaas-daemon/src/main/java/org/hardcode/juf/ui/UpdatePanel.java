package org.hardcode.juf.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import org.hardcode.juf.update.Feature;
import org.hardcode.juf.update.Update;
/**
 * 
 */
public class UpdatePanel extends JPanel {

	
	private JSplitPane jSplitPane = null;
	private JList lstUpdates = null;
	private JTextArea txtUpdate = null;
	
	
	private Update[] updates;
	
	/**
	 * This is the default constructor
	 */
	public UpdatePanel() {
		super();
		initialize();
	}
	
	public void setModel(Update[] jupdate){
		this.updates = jupdate;
		this.update();
	}
	
	private void update(){
		DefaultListModel model = new DefaultListModel();		
		for (int i = 0; i < updates.length; i++) {
			model.add(i, updates[i].getComponentName());
		}
		
		lstUpdates.setModel(model);
	}
	
	public Update[] getSelectedUpdates(){
		int[] indexes = lstUpdates.getSelectedIndices();
		Update[] updates = new Update[indexes.length];
		for (int i = 0; i < updates.length; i++) {
			updates[i] = this.updates[indexes[i]];					
		}
		
		return updates;
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		this.setLayout(new BorderLayout());
		this.setSize(300,200);
//		this.add(getJSplitPane(), java.awt.BorderLayout.NORTH);
		this.add(getJSplitPane(), java.awt.BorderLayout.CENTER);
		
		//this.add(j_exit,java.awt.BorderLayout.SOUTH);
	}
	/**
	 * This method initializes jSplitPane	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */    
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
			jSplitPane.setDividerLocation(70);
			jSplitPane.setTopComponent(getLstUpdates());
			jSplitPane.setBottomComponent(getTxtUpdate());
		}
		return jSplitPane;
	}
	/**
	 * This method initializes lstUpdates	
	 * 	
	 * @return javax.swing.JList	
	 */    
	private JList getLstUpdates() {
		if (lstUpdates == null) {
			lstUpdates = new JList();
			lstUpdates.addListSelectionListener(new javax.swing.event.ListSelectionListener() { 
				public void valueChanged(javax.swing.event.ListSelectionEvent e) {    
					int updateIndex = lstUpdates.getSelectedIndex();
					
					Feature[] caracs = updates[updateIndex].getFeature();
					StringBuffer str = new StringBuffer();
					for (int i = 0; i < caracs.length; i++) {
						str.append(caracs[i].getContent() + "\n");
						//System.out.println(caracs[i].getContent()+"2222222222");
					}
					
					txtUpdate.setText(str.toString());
				}
			});
		}
		return lstUpdates;
	}
	/**
	 * This method initializes txtUpdate	
	 * 	
	 * @return javax.swing.JTextArea	
	 */    
	private JTextArea getTxtUpdate() {
		if (txtUpdate == null) {
			txtUpdate = new JTextArea();
		}
		return txtUpdate;
	}
   }
