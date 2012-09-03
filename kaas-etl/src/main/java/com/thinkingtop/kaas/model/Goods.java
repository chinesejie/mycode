package com.thinkingtop.kaas.model;

public class Goods {
	private int goods_id;
	private String goods_name;
	private int goods_number;
	private float market_price;
	private float shop_price;

	public int getGoods_id() {
		return goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public int getGoods_number() {
		return goods_number;
	}

	public float getMarket_price() {
		return market_price;
	}

	public float getShop_price() {
		return shop_price;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}

	public void setMarket_price(float market_price) {
		this.market_price = market_price;
	}

	public void setShop_price(float shop_price) {
		this.shop_price = shop_price;
	}

}
