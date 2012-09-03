package com.thinkingtop.kaas.reader;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import java.util.*;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.xpath.XPath;

/**
 * 
 * @author Xiaojie Liang at 2012.01.20
 *  
 */
public class SatInfoReader {

	final String fileName = "mid.xml";// the name of the target file
	Element root;

	public SatInfoReader() { // use the instructor to initialize the target file
		SAXBuilder sb = new SAXBuilder();
		try {
			Document doc = sb.build(Thread.currentThread()
					.getContextClassLoader().getResourceAsStream(fileName));
			// the class of Document is inside the packet org.jdom;
			this.root = doc.getRootElement();
			System.out.println(root.getName() + "..............");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//this method get the table name of "order" and its primary key field name..
	@SuppressWarnings("unchecked")
	public Map<String, String> getTable_Order() {
		Map<String, String> map = new HashMap<String, String>();
		try {
			List<Element> satNameElet = XPath.selectNodes(root, "//order");
			System.out.println(root.getName());
			for (Iterator<Element> ite = satNameElet.iterator(); ite.hasNext();) {
				Element ele = ite.next();
				System.out.println(ele.getName());
				if (ele.getName().toString().equals("order")) {
					String table_order_name = ele.getAttributeValue("ref");
					map.put("table_order_name", table_order_name);
					//String primaryKey = ele.getChild("id").getAttribute("name").getValue().toString();
					String primaryKey = ele.getChild("id").getChild("column").getAttributeValue("name");
					map.put("primaryKey", primaryKey);
					return map;
				}
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getMappings() {
		Map<String, String> map = new HashMap<String, String>();
		try {
			List<Element> satNameElet = XPath.selectNodes(root, "//mapping");
			System.out.println(root.getName());
			for (Iterator<Element> ite = satNameElet.iterator(); ite.hasNext();) {
				Element ele = ite.next();
				System.out.println(ele.getName());
				if (ele.getName().toString().equals("mapping")) {
					String mapping_table_name = ele.getAttributeValue("table");
					map.put("mapping_table_name", mapping_table_name);
					//String primaryKey = ele.getChild("id").getAttribute("name").getValue().toString();
					Element relation = (Element)ele.getChildren().get(0);//get the first element: manytomany or onetomany
					String relation_name = relation.getName();
					map.put("relation_name",relation_name); 
					
					String mapping_table_id = relation.getAttributeValue("column");
					map.put("mapping_table_id",mapping_table_id);
					//if many to many, get all the children and return...
					if(relation_name.equals("many-to-many")) {
						List<Element> list  = (List<Element>) relation.getChildren();
						Iterator<Element> ite_temp = list.iterator();
						while(ite_temp.hasNext()) {
							Element temp = ite_temp.next();
							String str_name = temp.getName();
							String str_value = temp.getAttributeValue("name");
							map.put(str_name, str_value);
						}
						return map;
					}
					//if not ....check it is singleColumn or multiColumns
					Element singleOrMulti = (Element)relation.getChildren().get(0);
					String singleOrMulti_name = singleOrMulti.getName();
					map.put("singleOrMulti_name", singleOrMulti_name);
					
					List<Element> list  = (List<Element>) singleOrMulti.getChildren();
					Iterator<Element> ite2 = list.iterator();
					while(ite2.hasNext()) {
						Element temp = ite2.next();
						String str_name = temp.getName();
						String str_value = temp.getAttributeValue("value");
						map.put(str_name, str_value);
					}
					return map;
				}
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	// /this method is provided for the datasource//
	public Map<String, String> getDatasourceParameters() {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Element database = (Element) XPath.selectSingleNode(root,
					"//database");
			map.put("driverClass", database.getAttribute("driverClass")
					.getValue().toString());
			map.put("jdbcUrl", database.getAttribute("jdbcUrl").getValue()
					.toString());
			map.put("user", database.getAttribute("user").getValue().toString());
			map.put("password", database.getAttribute("password").getValue()
					.toString());
			System.out.println(database.getAttribute("jdbcUrl").getValue()
					.toString()
					+ "||||||||||||");
		} catch (JDOMException e) {
			e.printStackTrace();
		}

		return map;
	}

	public static void main(String args[]) {
		SatInfoReader reader = new SatInfoReader();
		// System.out.println(reader.getOrderIdName("order_id"));
		//System.out.println(reader.getDatasourceParameters().get("driverClass"));
		System.out.println(reader.getMappings());
		
	}
}
