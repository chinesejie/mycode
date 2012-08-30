package com.liang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.liang.dao.TransformerDAO;
import com.liang.model.Goods; 

public class TransformerMysqlImpl implements TransformerDAO {
 
	/*JdbcTemplate*/
	private JdbcTemplate jdbcTemplate;

	/* set to inject the proxy class of jdbcTemplate*/
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	private class Int4u {
		private Integer ii;

		public Integer getIi() {
			return ii;
		}

		public void setIi(Integer ii) {
			this.ii = ii;
		}
		
	}
	@SuppressWarnings("unchecked")
	public void getMidware() {
		
		// 定义返回结果
		//List<> entities = new ArrayList<Emp>();
		Integer i;
		//i = jdbcTemplate.queryForInt("SELECT order_id FROM order");
		Int4u entity = (Int4u) jdbcTemplate.queryForObject(
				"select order_id from ecs_order",
				 new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Int4u int4u= new Int4u();
						int4u.setIi(rs.getInt("order_id"));
						return int4u;
					}
				});
		
		System.out.println(entity.getIi()+" -----------------------------------------");
	}
	static int temp=1;
	@SuppressWarnings("unchecked")
	public List<Goods> getGoodsGroup(Integer order_id) {
		List<Integer> goodsIdList = new ArrayList<Integer>(); 
		System.out.println("要查询的订单号是"+order_id);
		goodsIdList = (List<Integer>)jdbcTemplate.query("select goods_id from ecs_order_goods where order_id = "+order_id,  new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Integer i_temp = new Integer(rs.getInt("goods_id"));
						
				return i_temp;
			}
		});
		List<Goods> goodsList = new ArrayList<Goods>();
		
		Iterator<Integer> ite = goodsIdList.iterator();
		System.out.println("订单号 货物件数是"+goodsIdList.size());
		while(ite.hasNext()) {
			
			temp = (int)ite.next();
			Goods temp_goods = (Goods)jdbcTemplate.queryForObject("select goods_name from ecs_goods where goods_id = "+temp,  new RowMapper() {
				public Object mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Goods g = new Goods();
					g.setGoods_id(temp);
					g.setGoods_name(rs.getString("goods_name"));
					return g;
				}
			});
			goodsList.add(temp_goods);
		}
		System.out.println("货物件数"+goodsList.size());
		return goodsList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Integer> getOrderListByFieldName(String name) {
		List<Integer> idList = new ArrayList<Integer>();
		idList = (List<Integer>)jdbcTemplate.query("select DISTINCT "+name+" from ecs_order_goods", new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Integer i_temp = new Integer(rs.getInt("order_id"));
				return i_temp;
			}
		});
		return idList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getOrderListByFieldName(String table_name, final String orderid_name) {
		List<Integer> idList = new ArrayList<Integer>();
		idList = (List<Integer>)jdbcTemplate.query("select DISTINCT "+orderid_name+" from "+table_name, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Integer i_temp = new Integer(rs.getInt(orderid_name));
				return i_temp;
			}
		});
		return idList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Integer> getGoodsIdGroup(Integer order_id,String table_name, final String goodsid_name, final String orderid_name) {
		List<Integer> goodsIdList = new ArrayList<Integer>();
		//System.out.println("要查询的订单号是"+order_id);
		
		System.out.println("select "+goodsid_name+" from "+table_name+" where "+orderid_name+" = "+order_id);
		goodsIdList = (List<Integer>)jdbcTemplate.query("select "+goodsid_name+" from "+table_name+" where "+orderid_name+" = "+order_id,  new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Integer i_temp = new Integer(rs.getInt(goodsid_name));
					
				return i_temp;
			}
		});
		return goodsIdList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getGoodsIdGroup1(Integer order_id,String table_name,final String goods_list, final String orderid_name,String separator) {
		List<Integer> goodsIdList = new ArrayList<Integer>();
		String goodsId_str = (String)jdbcTemplate.queryForObject("select "+goods_list+" from "+table_name+" where "+orderid_name+" = "+order_id,  new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				String str = rs.getString(goods_list);
					
				return str;
			}
		});
		
		String str_array[] = goodsId_str.split(separator);
		for(int i=0;i<str_array.length;i++) {
			goodsIdList.add(Integer.parseInt(str_array[i]));
		}
		System.out.println(goodsIdList+"");
		return goodsIdList;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getGoodsIdGroup2(Integer order_id,String table_name, final String orderid_name,final String prefix,String startid, String colunmCount) {
		List<Integer> goodsIdList = new ArrayList<Integer>();
		final int origin = Integer.parseInt(startid);
		int start = new Integer(origin);
		StringBuilder sb = new StringBuilder();
		final int length = Integer.parseInt(colunmCount);
		sb.append(prefix+startid);
		for(int i=0;i<length-1;i++) {
			start++;
			sb.append(","+prefix+start);
		}
		System.out.println("select "+sb.toString()+" from "+table_name+" where "+orderid_name+" = "+order_id);
		goodsIdList = (List<Integer>)jdbcTemplate.queryForObject("select "+sb.toString()+" from "+table_name+" where "+orderid_name+" = "+order_id,  new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				List<Integer> list = new ArrayList<Integer>();
				int start = origin;
				for(int i=0;i<length;i++) {
					
					Integer temp = new Integer(rs.getInt(prefix+start));
					start++;
					
				
					list.add(temp);
					}
			System.out.println("-------------------------------------------------------------------------");
					
				return list;
			}
		});
		
		System.out.println(goodsIdList+"");
		return goodsIdList;
		
	}
	
	
}