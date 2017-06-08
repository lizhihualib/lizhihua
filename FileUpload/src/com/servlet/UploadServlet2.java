package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig
@WebServlet(name="uploadServlet2",urlPatterns="/uploadServlet2")
public class UploadServlet2 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8630888200229505747L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		List<Part> list=(List<Part>) req.getParts();
		FileUtil.write2disk(list, req.getServletContext().getRealPath("/")+"upload");
	}
	

}
