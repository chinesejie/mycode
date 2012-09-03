package com.thinkingtop.kaas.model;

import java.util.Date;

public class Order {
	private Date create_date;
	private float goods_amount;
	private int order_id;
	private String order_sn;

	private int order_statue;

	private int user_id;

	public Date getCreate_date() {
		return create_date;
	}

	public float getGoods_amount() {
		return goods_amount;
	}

	public int getOrder_id() {
		return order_id;
	}

	public String getOrder_sn() {
		return order_sn;
	}

	public int getOrder_statue() {
		return order_statue;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public void setGoods_amount(float goods_amount) {
		this.goods_amount = goods_amount;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}

	public void setOrder_statue(int order_statue) {
		this.order_statue = order_statue;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
