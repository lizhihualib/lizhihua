package com.chinasoft.goods.bean;

import java.math.BigDecimal;
/**
 * 商品对象
 * @author Administrator
 *
 */
public class Goods extends Page{
	/**
	 * 商品id
	 */
	private int id;//商品id
	/**
	 * 商品名称
	 */
	private String g_name;
	/**
	 * 商品价格
	 */
	private BigDecimal g_price;
	/**
	 * 商品库存
	 */
	private int g_nums;
	/**
	 * 商品类型
	 */
	private int g_type;
	/**
	 * 商品详情
	 */
	private String g_desc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public BigDecimal getG_price() {
		return g_price;
	}
	public void setG_price(BigDecimal g_price) {
		this.g_price = g_price;
	}
	public int getG_nums() {
		return g_nums;
	}
	public void setG_nums(int g_nums) {
		this.g_nums = g_nums;
	}
	public int getG_type() {
		return g_type;
	}
	public void setG_type(int g_type) {
		this.g_type = g_type;
	}
	public String getG_desc() {
		return g_desc;
	}
	public void setG_desc(String g_desc) {
		this.g_desc = g_desc;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", g_name=" + g_name + ", g_price=" + g_price + ", g_nums=" + g_nums + ", g_type="
				+ g_type + ", g_desc=" + g_desc + "]";
	}
	
	
}
