<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
<script type="text/javascript" src="/goods/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/goods/js/goods.js"></script>
</head>
<body>
	<form action="/goods/goodsServlet?method=query" method="post">
		商品名称：<input name="g_name" id="g_name" value="${goods.g_name }">
		商品价格：<input name="g_price" id="g_price" value="${goods.g_price }">
		商品详情：<input name="g_desc" id="g_desc"  value="${goods.g_desc }">
		<input type="submit" value="查询" id="g_desc">
	</form>
	<input type="button" value="添加商品" id="add">
	<table>
		<tr>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品库存</th>
			<th>商品类型</th>
			<th>商品详情</th>
			<th>操作</th>
		</tr>
		<c:forEach 	var="good" items="${list}">
			<tr>
				<td>${good.g_name }</td>
				<td>${good.g_price }</td>
				<td>${good.g_nums }</td>
				<td>${good.g_type }</td>
				<td>${good.g_desc}</td>
				<td><a href="/goods/goodsServlet?method=toUpdate&id=${good.id}">修改</a> | <a href="/goods/goodsServlet?method=delete&id=${good.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="javascript:void(0);" id="pre">上一页</a>
	&nbsp;&nbsp;当前<span id="curPage">${goods.curPage }</span>页
	&nbsp;&nbsp;<a  href="javascript:void(0);" id="next">下一页</a>
	&nbsp;&nbsp;共<span id="total">${goods.total }</span>页
</body>
</html>