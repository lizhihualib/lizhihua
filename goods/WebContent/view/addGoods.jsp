<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/goods.js"></script>
</head>
<body>
	<form action="../goodsServlet?method=insert" method="post" onsubmit="return check();">
		商品名称：<input name="g_name" id="g_name"><br>
		商品价格：<input name="g_price" id="g_price"><br>
		商品库存：<input name="g_nums" id="g_nums"><br>
		商品类型：<select name="g_type">
					<option value="1">饮料</option>
					<option value="2">零食</option>
				</select><br>
		商品详情：<input name="g_desc" id="g_desc"><br>
		
		<input type="submit" value="提交"><br>
	</form>
	
	
</body>
</html>