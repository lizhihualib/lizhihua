package com.chinasoft.goods.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.goods.bean.Goods;
import com.chinasoft.goods.service.IGoodsService;
import com.chinasoft.goods.service.impl.GoodsServiceImpl;

import net.sf.json.JSONObject;
/**
 * 后台商品servlet
 * @author Administrator
 *
 */
@WebServlet(name="goodsServlet",urlPatterns="/goodsServlet")
public class GoodsServlet extends BaseServlet{

	@Override
	public void excute(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("默认执行");
	}
	/**
	 * 增加商品
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//获取商品信息
		String g_name=req.getParameter("g_name");
		String g_price=req.getParameter("g_price");
		String g_nums=req.getParameter("g_nums");
		String g_type=req.getParameter("g_type");
		String g_desc=req.getParameter("g_desc");
		
		Goods goods=new Goods();
		goods.setG_name(g_name);
		goods.setG_price(new BigDecimal(g_price));
		goods.setG_nums(Integer.valueOf(g_nums));
		goods.setG_type(Integer.valueOf(g_type));
		goods.setG_desc(g_desc);
		
		//调用service方法
		IGoodsService goodService=new GoodsServiceImpl();
		boolean flag=goodService.insert(goods);

		
		if(flag){
			resp.sendRedirect("goodsServlet?method=query");
		}
		
	}
	/**
	 * 查询
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		//获取查询条件参数
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
		
		//根据条件查询商品，并做分页
		IGoodsService goodService=new GoodsServiceImpl();
		List<Goods> list=goodService.query(goods);
		//查询通过这些条件筛选后的商品总数
		int count=goodService.queryCount(goods);
		goods.setCount(count);
		
		//返回
		req.setAttribute("list", list);
		req.setAttribute("goods", goods);
		req.getRequestDispatcher("view/goods.jsp").forward(req, resp);
	}
	/**
	 * 根据id删除商品
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String id=req.getParameter("id");
		
		IGoodsService goodService=new GoodsServiceImpl();
		boolean flag=goodService.delete(Integer.valueOf(id));
		
		if(flag){
			resp.sendRedirect("goodsServlet?method=query");
		}
	}	
	
	/**
	 * 跳转到修改商品页面
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String id=req.getParameter("id");
		//查询商品
		IGoodsService goodService=new GoodsServiceImpl();
		Goods good=goodService.queryByid(Integer.valueOf(id));
		//跳转
		req.setAttribute("good", good);
		req.getRequestDispatcher("view/updateGoods.jsp").forward(req, resp);
	}
	/**
	 * 执行修改
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		//获取参数
		String id=req.getParameter("id");
		String g_name=req.getParameter("g_name");
		String g_price=req.getParameter("g_price");
		String g_nums=req.getParameter("g_nums");
		String g_type=req.getParameter("g_type");
		String g_desc=req.getParameter("g_desc");
		
		Goods goods=new Goods();
		goods.setId(Integer.valueOf(id));
		goods.setG_name(g_name);
		goods.setG_price(new BigDecimal(g_price));
		goods.setG_nums(Integer.valueOf(g_nums));
		goods.setG_type(Integer.valueOf(g_type));
		goods.setG_desc(g_desc);
		
		//执行service修改
		IGoodsService goodService=new GoodsServiceImpl();
		boolean flag=goodService.update(goods);
		
		//返回
		if(flag){
			resp.sendRedirect("goodsServlet?method=query");
		}
		

	}
}
