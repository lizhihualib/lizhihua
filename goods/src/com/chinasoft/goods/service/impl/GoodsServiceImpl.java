package com.chinasoft.goods.service.impl;

import java.util.List;

import com.chinasoft.goods.bean.Goods;
import com.chinasoft.goods.dao.IGoodsDao;
import com.chinasoft.goods.dao.impl.GoodsDaoImpl;
import com.chinasoft.goods.service.IGoodsService;
/**
 * 商品service实现
 * @author Administrator
 *
 */
public class GoodsServiceImpl implements IGoodsService{

	@Override
	public boolean insert(Goods goods) {
		IGoodsDao goodDao=new GoodsDaoImpl();
		
		return goodDao.insert(goods);
	}

	@Override
	public boolean update(Goods goods) {
		IGoodsDao goodDao=new GoodsDaoImpl();
		int flag=goodDao.update(goods);
		if(flag>0)
			return true;
		return false;
	}

	@Override
	public boolean delete(int g_id) {
		IGoodsDao goodDao=new GoodsDaoImpl();
		int flag=goodDao.delete(g_id);
		if(flag>0)
			return true;
		return false;
	}

	@Override
	public List<Goods> query(Goods goods) {
		IGoodsDao goodDao=new GoodsDaoImpl();
		return goodDao.query(goods);
	}

	@Override
	public Goods queryByid(int id) {
		IGoodsDao goodDao=new GoodsDaoImpl();
		return goodDao.queryByid(id);
	}

	@Override
	public int queryCount(Goods goods) {
		IGoodsDao goodDao=new GoodsDaoImpl();
		return goodDao.queryCount(goods);
	}

}
