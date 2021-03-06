package com.liang.dao;

import java.util.List;

import com.liang.model.Goods;


public interface TransformerDAO {

	public void getMidware();
	public List<Goods> getGoodsGroup(Integer order_id);
	public List<Integer> getOrderListByFieldName(String name);
	public List<Integer> getOrderListByFieldName(String table_name, String orderid_name);
	public List<Integer> getGoodsIdGroup(Integer order_id,String table_name, String goodsid_name, String orderid_name);
	public List<Integer> getGoodsIdGroup1(Integer order_id,String table_name, String goods_list, String orderid_name,String separator);
	public List<Integer> getGoodsIdGroup2(Integer order_id,String table_name, String orderid_name, String prefix,String startid, String colunmCount);
}
