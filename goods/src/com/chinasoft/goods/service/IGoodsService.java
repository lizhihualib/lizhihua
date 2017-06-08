package com.chinasoft.goods.service;

import java.util.List;

import com.chinasoft.goods.bean.Goods;
/**
 * 商品service接口
 * @author Administrator
 *
 */
public interface IGoodsService {
	/**
	 * 增加商品
	 * @param goods
	 * @return
	 */
	boolean insert(Goods goods);
	/**
	 * 修改商品
	 * @param goods
	 * @return
	 */
	boolean update(Goods goods);
	/**
	 * 删除商品
	 * @param g_id
	 * @return
	 */
	boolean delete(int g_id);
	/**
	 * 查询商品
	 * @param goods
	 * @return
	 */
	List<Goods> query(Goods goods);
	/**
	 * 查询商品数量
	 * @param goods
	 * @return
	 */
	int queryCount(Goods goods);
	
	Goods queryByid(int id);
}
