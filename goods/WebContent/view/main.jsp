<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/goods/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#goods").click(function(){
			$(".child").slideToggle(100);
		});
		$("#goods2").click(function(){
			$(".child2").slideToggle(100);
		});
	})

</script>
</head>
<body>
	<div style="background-color:#eeeeee;width: 100%;height: 100px ">
		商品管理系统
	</div>
	<div style="margin-top: 10px">
		<div style="float: left;background-color:#eeeeee;width: 150px;height: 690px">
			<a href="javascript:void(0);" id="goods"><span>商品管理</span></a><br>
			<div class="child">
				&nbsp;&nbsp;&nbsp;<a href="/goods/goodsServlet?method=query" target="frame" id="child1"><span>商品管理1</span></a><br>
				&nbsp;&nbsp;&nbsp;<a href="/goods/goodsServlet?method=query" target="frame" id="child2"><span>商品管理1</span></a>
			</div>
			
			<a href="javascript:void(0);" id="goods2"><span>商品管理2</span></a><br>
			<div class="child2">
				&nbsp;&nbsp;&nbsp;<a href="/goods/goodsServlet?method=query" target="frame" id="child1"><span>商品管理1</span></a><br>
				&nbsp;&nbsp;&nbsp;<a href="/goods/view/updateGoods.jsp" target="frame" id="child2"><span>商品管理1</span></a>
			</div>
		</div>
		<div style="margin-left: 20px">
			<iframe name="frame" style="width: 80%;height: 690px;">
			
			</iframe>
		</div>
	</div>
</body>
</html>