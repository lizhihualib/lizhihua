package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.Part;

/**
 * 文件工具类
 * @author Administrator
 *
 */
public class FileUtil {
	/**
	 * 根据输入流 和文件路径保存
	 * @param in
	 * @param path
	 * @throws IOException
	 */
	public static void write2disk(InputStream in,String path) throws IOException{
		OutputStream os=new FileOutputStream(path);
		byte[] bytes=new byte[1024];
		int temp=0;
		while((temp=in.read(bytes))!=-1){
			os.write(bytes, 0, temp);
		}
		in.close();
		os.close();
	}
	/**
	 *  根据输入流和文件目录及文件名字保存
	 * @param in
	 * @param path
	 * @param fileName
	 * @throws IOException
	 */
	public static void write2disk(InputStream in,String path,String fileName) throws IOException{
		OutputStream os=new FileOutputStream(path+fileName);
		byte[] bytes=new byte[1024];
		int temp=0;
		while((temp=in.read(bytes))!=-1){
			os.write(bytes, 0, temp);
		}
		in.close();
		os.close();
	}
	/**
	 * 根据文件流和file对象保存
	 * @param in
	 * @param file
	 * @throws IOException
	 */
	public static void write2disk(InputStream in,File file) throws IOException{
		OutputStream os=new FileOutputStream(file);
		byte[] bytes=new byte[1024];
		int temp=0;
		while((temp=in.read(bytes))!=-1){
			os.write(bytes, 0, temp);
		}
		in.close();
		os.close();
	}
	public static void write2disk(Part part,String parentPath) throws IOException{
		String fileName=getFileName(part);
		InputStream in=part.getInputStream();
		File file=new File(parentPath+fileName);
		file.createNewFile();		
		FileOutputStream fos=new FileOutputStream(file);
		int temp=0;
		while((temp=in.read()) != -1){
			fos.write(temp);
		}
		in.close();
		fos.close();
	}
	public static void write2disk(List<Part> list,String parentPath) throws IOException{
		for (Part part : list) {	
			String fileName=getFileName(part);
			InputStream is=part.getInputStream();
			OutputStream os=new FileOutputStream(parentPath+fileName);
			byte[] bytes=new byte[1024];
			int temp=0;
			while((temp=is.read(bytes))!=-1){
				os.write(bytes, 0, temp);
			}
			is.close();
			os.close();
		}
	}
	
	public static String getFileName(Part part){
		 String header = part.getHeader("Content-Disposition");
      String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
      return fileName;
		
	}
}
