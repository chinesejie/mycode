package com.thinkingtop.juf;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.io.FileWriter;
import org.exolab.castor.xml.Marshaller;
import org.hardcode.juf.update.Feature;
import org.hardcode.juf.update.Installer;
import org.hardcode.juf.update.Update;
import org.hardcode.juf.update.Updates;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	public void test() {
		try {
			Updates us = new Updates();
			Update u = new Update();
			/*
			 * feature
			 */
			Feature f = new Feature();
			
			f.setContent("I am content");
			Feature[] f_array = new Feature[1];
			f_array[0] = f;
			u.setFeature(f_array);
			/*
			 * component
			 */
			u.setComponentName("I am component");
			u.setVersion(Long.parseLong("11"));

			Installer i = new Installer();
			i.setClassName("SampleUpdate");
			i.setJarUrl("http://127.0.0.1:8080/juf/sample-update-1.0.jar");
			u.setInstaller(i);
			

			us.addUpdate(u);
			
			//sessions 

			
			/*
			 * 
			 *  CD sessions = new CD("Sessions for Robert J", "Eric Clapton");
      			sessions.addTrack("Little Queen of Spades");
      			sessions.addTrack("Terraplane Blues");

			      FileWriter writer = new FileWriter("cds.xml");
			      Marshaller.marshal(sessions, writer);

			 */
			FileWriter writer = new FileWriter("updates.xml");
			Marshaller.marshal(us, writer);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace(System.err);
		}
	}
}
