package com.chinasoft.goods.dao;

import java.util.List;

import com.chinasoft.goods.bean.Goods;
/**
 * 商品dao接口
 * @author Administrator
 *
 */
public interface IGoodsDao {
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
	int update(Goods goods);
	/**
	 * 删除商品
	 * @param g_id
	 * @return
	 */
	int delete(int g_id);
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
