package com.liang.service.impl;

import java.util.List;

import com.liang.dao.TransformerDAO;
import com.liang.model.Goods;
import com.liang.service.TransformerService;

/**
 * Hello world!
 *
 */
public class TransformerServiceImpl implements TransformerService {

	public TransformerDAO transformerDAO;

	public TransformerDAO getTransformerDAO() {
		return transformerDAO;
	}

	public void setTransformerDAO(TransformerDAO transformerDAO) {
		this.transformerDAO = transformerDAO;
	}

	public void getMidware() {
		transformerDAO.getMidware();
	}

	public List<Goods> getGoodsGroup(Integer order_id) {
		// TODO Auto-generated method stub
		return transformerDAO.getGoodsGroup(order_id);
	}

	public List<Integer> getOrderListByFieldName(String name) {
		// TODO Auto-generated method stub
		return transformerDAO.getOrderListByFieldName(name);
	}

	public List<Integer> getOrderListByFieldName(String table_name,
			String orderid_name) {
		
		return transformerDAO.getOrderListByFieldName(table_name,orderid_name);
	}

	public List<Integer> getGoodsIdGroup(Integer order_id, String table_name,
			String goodsid_name, String orderid_name) {
		
		return transformerDAO.getGoodsIdGroup(order_id, table_name, goodsid_name, orderid_name);
	}

	public List<Integer> getGoodsIdGroup1(Integer order_id, String table_name,
			String goods_list, String orderid_name, String separator) {
		// TODO Auto-generated method stub
		return transformerDAO.getGoodsIdGroup1(order_id, table_name, goods_list, orderid_name, separator);
	}

	public List<Integer> getGoodsIdGroup2(Integer order_id, String table_name,
			String orderid_name, String prefix, String startid,
			String colunmCount) {
		
		return transformerDAO.getGoodsIdGroup2(order_id, table_name, orderid_name, prefix, startid, colunmCount);
	}
	
}
