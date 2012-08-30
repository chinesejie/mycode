package com.liang.validation;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class ValidateXML {

	/**
	 * @param args
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		ValidateXML sv = new ValidateXML();
		sv.validate();
	}

	public boolean validate() {
		try {
			String strLang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory factory = SchemaFactory.newInstance(strLang);

			InputStream isSchema = getClass().getResourceAsStream(
					"/mid.xsd");
			StreamSource ss = new StreamSource(isSchema);
			Schema schema = factory.newSchema(ss);

			Validator validator = schema.newValidator();

			InputStream isXML = getClass().getResourceAsStream("/mid.xml");

			StreamSource source = new StreamSource(isXML);
			validator.validate(source);
			
			System.out.println("Result : Valid!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Result : Invalid!");
			return false;
		}

	}

}
