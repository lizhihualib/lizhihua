package com.chinasoft.goods.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.goods.bean.Goods;
import com.chinasoft.goods.service.IGoodsService;
import com.chinasoft.goods.service.impl.GoodsServiceImpl;
/**
 * 外部用户商品servlet
 * @author Administrator
 *
 */
@WebServlet(name="mainServlet",urlPatterns="/mainServlet")
public class Main extends BaseServlet{
	/**
	 * 查询商品并跳转主页
	 * @param req
	 * @param arg1
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toMain(HttpServletRequest req, HttpServletResponse arg1) throws ServletException, IOException {
		//获取前台参数
		String g_name=req.getParameter("g_name");
		String g_price=req.getParameter("g_price");
		String g_desc=req.getParameter("g_desc");
		String curPage=req.getParameter("curPage");
		Goods goods=new Goods();
		goods.setG_name(g_name);
		if(g_price!=null && !g_price.equals(""))
			goods.setG_price(new BigDecimal(g_price));
		goods.setG_desc(g_desc);
		if(curPage!=null && !curPage.equals(""))
			goods.setCurPage(Integer.valueOf(curPage));	
		
		//根据条件查询
		IGoodsService goodService=new GoodsServiceImpl();
		List<Goods> list=goodService.query(goods);
		//根据条件查询总数
		int count=goodService.queryCount(goods);
		goods.setCount(count);
		
		req.setAttribute("list", list);
		req.setAttribute("goods", goods);
		
		
		req.getRequestDispatcher("view/shopping.jsp").forward(req, arg1);
	}
	/**
	 * 加入购物车
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void join(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取参数
		String id=req.getParameter("id");
		//根据id查询相应的商品信息
		IGoodsService goodService=new GoodsServiceImpl();
		Goods good=goodService.queryByid(Integer.valueOf(id));
		
		//获取购物车
		HttpSession session=req.getSession();
		List<Goods> shopping=(List<Goods>) session.getAttribute("shopping");
		//判断购物车是否为空
		if(shopping==null){
			List<Goods> shops=new ArrayList<Goods>();
			//将商品加入购物车list里面
			shops.add(good);
			//将购物车列表放入session对象里面
			session.setAttribute("shopping", shops);
		}else {
			shopping.add(good);
			session.setAttribute("shopping", shopping);
		}
			
		resp.sendRedirect("/goods/mainServlet?method=toMain");
	}
	/**
	 * 移除购物车
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		
		HttpSession session=req.getSession();
		List<Goods> shopping=(List<Goods>) session.getAttribute("shopping");
		
		//循环判断购物车里面的商品是否和将要删除的商品id一致，如果一致则删除该商品
		for (int i = 0; i < shopping.size(); i++) {
			if(shopping.get(i).getId()==Integer.parseInt(id)){
				shopping.remove(i);
			}
		}
		//将删除后的购物车方法session里面
		session.setAttribute("shopping", shopping);
		
		resp.sendRedirect("/goods/mainServlet?method=toMain");
	}
	
	public void jiesuan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		List<Goods> shopping=(List<Goods>) session.getAttribute("shopping");
		
		session.setAttribute("shopping", null);
		
		
		session.setAttribute("shopping", shopping);
		
		
		resp.sendRedirect("/goods/mainServlet?method=toMain");
	}
}
