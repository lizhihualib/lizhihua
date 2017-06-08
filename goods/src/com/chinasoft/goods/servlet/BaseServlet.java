package com.chinasoft.goods.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 所有的servlet类都应该继承该类
 * @author Administrator
 *
 */
public class BaseServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
		arg1.setContentType("text/html;charset=utf-8");
		
		String method=arg0.getParameter("method");
		if(method==null){
			method="excute";
		}
		try {
			Method methodObj=this.getClass().getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			methodObj.invoke(this, arg0,arg1);
		
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void excute(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("默认执行excute方法");
	}
}
