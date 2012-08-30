package com.liang.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liang.model.Goods;
import com.liang.reader.SatInfoReader;
import com.liang.service.TransformerService;
import com.liang.validation.ValidateXML;

import junit.framework.TestCase;

public class AppTest extends TestCase{
	@Test
	public void test() {
		ValidateXML v = new ValidateXML();
		//validate the xml with xsd first...
		if(!v.validate()) {
			System.out.println("xml invalid");
			return;
		}
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		TransformerService transformerService = (TransformerService) 
		  ac.getBean("transformerService");
		
		
		getGoodsList(transformerService);
		
		//  transformerService.getMidware();
		  
		  //String orderIdName = reader.getOrderIdName();
	       // System.out.println(orderIdName);
	        
	       // List<Integer> idList =(List<Integer>) transformerService.getOrderListByFieldName(orderIdName);
	      /*  
	        Iterator<Integer> ite = idList.iterator();
	        while(ite.hasNext()) {
	        	System.out.println("start-------------");
	        	int ii = (int)ite.next();
	        	
	        	List<Goods> goodsList = (List<Goods>)transformerService.getGoodsGroup(ii);
	        	Iterator<Goods> ite2 = goodsList.iterator();
	        	System.out.println("your result:");
	        	while(ite2.hasNext()) {
	        		System.out.print(ite2.next().getGoods_name()+"\t");
	        	}
	        	System.out.print("\n");
	        	System.out.println("end-------------");
	        	
	        }*/
	}
	public List<Integer> getGoodsList(TransformerService transformerService) {
		SatInfoReader reader = new SatInfoReader();
		System.out.println(reader.getMappings());
		Map<String, String> map = (Map<String, String>)reader.getMappings();
		/** many to many(relation0)
		 {mapping_table_name=ecs_order_goods, 
		 relation_name=many-to-many, 
		goods_id=goods_id,
		 order_id=order_id
		 mapping_table_id=rec_id}
		 */
		String relation_name = map.get("relation_name");
		
		if(relation_name.equals("many-to-many")) {
			//p("00000000000000000000000000000000000000000000000");
			String goods_id =  map.get("goods_id");
			String order_id = map.get("order_id"); 
			String mapping_table_name = map.get("mapping_table_name");
			List<Integer> list = transformerService.getOrderListByFieldName(mapping_table_name, order_id);
			p("order::"+list);
			//transformerService.getOrderListByFieldName(name)
			for(int i=0;i<list.size();i++) {
				p("order_"+list.get(i)+"'s goods list::");
				System.out.println(transformerService.getGoodsIdGroup(list.get(i), mapping_table_name, goods_id, order_id));
			}
		}
		else {
			String singleOrMulti_name = map.get("singleOrMulti_name");
			if(singleOrMulti_name.equals("singleColumn")) {
				//p("111111111111111111111111111111111111111111111111111111");
				/**
				 one to many(relation1 singleColumn)
				{mapping_table_name=ecs_order, 
				relation_name=one-to-many, 
				goods_list=goods_list, 
				singleOrMulti_name=singleColumn, 
				mapping_table_id=order_id,
				separator=#}
				 */
				String mapping_table_name = map.get("mapping_table_name");
				String goods_list = map.get("goods_list");
				String mapping_table_id = map.get("mapping_table_id");
				String separator = map.get("separator");
				//String mapping_table_id = map.get("mapping_table_id");
				//transformerService.getOrderListByFieldName(table_name, orderid_name)
				List<Integer> list = transformerService.getOrderListByFieldName(mapping_table_name, mapping_table_id);
				p("order::"+list);
				for(int i=0;i<list.size();i++) {
					p("order_"+list.get(i)+"'s goods list::");
					transformerService.getGoodsIdGroup1(list.get(i), mapping_table_name, goods_list, mapping_table_id, separator);
				}
			}
			else {
				//p("22222222222222222222222222222222222222222222222222222222");
				/**
				 one to many(relation1 mutilColumns)
				 {startid=1,
				  mapping_table_name=ecs_order, 
				  columnCount=5, 
				  relation_name=one-to-many, 
				  prefix=goods_id, 
				  singleOrMulti_name=mutilColumns, 
				  mapping_table_id=order_id}
				 */
				String mapping_table_name = map.get("mapping_table_name");
				String mapping_table_id = map.get("mapping_table_id");
				String prefix = map.get("prefix");
				String columnCount = map.get("columnCount");
				String startid = map.get("startid");
				
				List<Integer> list = transformerService.getOrderListByFieldName(mapping_table_name, mapping_table_id);
				p("order::"+list);
				p("result:::::::::::::::::::::::::");
				for(int i=0;i<list.size();i++) {
					p("order_"+list.get(i)+"'s goods list::");
					transformerService.getGoodsIdGroup2(list.get(i), mapping_table_name, mapping_table_id, prefix, startid, columnCount);
				}
				
			}
		}
		
		return null;
	}
	
	public static void p(Object o) {
		System.out.println(o.toString());
	}
}
