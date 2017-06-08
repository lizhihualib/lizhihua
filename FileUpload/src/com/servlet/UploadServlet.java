package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.servlet.Music.Singer;

@MultipartConfig
@WebServlet(name = "uploadServlet", urlPatterns = "/uploadServlet")
public class UploadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8630888200229505747L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part = req.getPart("fileName");
		String fileName = getFileName(part);
		InputStream is = part.getInputStream();

		List<Music> list = new ArrayList<Music>();
		// 创建一个xml解析器
		SAXReader reader = new SAXReader();
		try {
			// 通过解析器读取一个xml文件
			Document document = reader.read(is);

			// 得到xml的根元素
			Element root = document.getRootElement();
			// 通过属性的名字获得一个Attribute属性对象
			Attribute attr = root.attribute("name");
			System.out.println(
					root.getName() + "  " + attr.getName() + "  " + attr.getText() + "  " + attr.getStringValue());

			// 得到标签的所有子标签的迭代器
			Iterator<Element> musics = root.elementIterator();
			// 迭代
			while (musics.hasNext()) {
				// 指针移动到下一个
				Element element = musics.next();
				// 得到element的名称
				System.out.println(element.getName() + "  ");
				// System.out.println("属性"+element.attribute("name")+"
				// "+element.attribute("id"));
				// 创建一个music对象
				Music mus = new Music();
				
				// 得到该元素的所有属性的迭代器
				Iterator<Attribute> it = element.attributeIterator();
				element.
				// 迭代
				while (it.hasNext()) {
					Attribute att = it.next();
					System.out.println("属性：" + att.getName() + "  值：" + att.getStringValue());
					if (att.getName().equals("id"))
						mus.setId(Integer.valueOf(att.getData().toString()));
					else if (att.getName().equals("name")) {
						mus.setName(att.getData().toString());
					}
					Iterator<Element> music = element.elementIterator();
					
					while (music.hasNext()) {
						Element mElment = music.next();
						System.out.println(mElment.getName() + "  ");
						Singer singers = mus.new Singer();
						
						// 得到所有的属性的集合
						List<Attribute> eAttr = mElment.attributes();
						for (Attribute att1 : eAttr) {
							System.out.println("属性：" + att1.getName() + "  值：" + att1.getStringValue());
							if (att1.getName().equals("id"))
								singers.setId(Integer.valueOf(att1.getStringValue()));
							else if (att1.getName().equals("sex")) {
								singers.setSex(att1.getStringValue());
							}
						}

						//根据元素的名称得到一个元素
						Element el=mElment.element("singer");
						
						// 得到该元素的所有子元素的集合
						List<Element> singer = mElment.elements();
						if (!singer.isEmpty()) {
							for (Element last : singer) {
								System.out.println(last.getName() + " " + last.getText());
								if (last.getName().equals("name"))
									singers.setName(last.getText());
								else if (last.getName().equals("city"))
									singers.setCity(last.getText());
							}
							mus.setSinger(singers);

						} else {

							System.out.println(mElment.getText());// mElment.getData().toString()
							if (mElment.getName().equals("zuoqu"))
								mus.setZuoqu(mElment.getText());
							else if (mElment.getName().equals("geci"))
								mus.setGeci(mElment.getText());
						}

					}

				}
				System.out.println();
				list.add(mus);
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.toString());
		File file = new File(req.getServletContext().getRealPath("/") + "upload/" + fileName);
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		int temp = 0;
		while ((temp = is.read()) != -1) {
			fos.write(temp);
		}
		// is.close();
		fos.close();
	}

	public String getFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
		return fileName;

	}
}
