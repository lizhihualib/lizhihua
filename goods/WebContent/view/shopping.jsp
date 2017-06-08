<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
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
		
		$("#pre").click(function(){
			var prePage=$("#curPage").html()-1;
			if(prePage<1){
				alert("已经是第一页")
			}else{
				location.href="/goods/mainServlet?method=toMain" +
						"&curPage="+prePage+
						"&g_name="+$("#g_name").val()+
						"&g_price="+$("#g_price").val()+
						"&g_desc="+$("#g_desc").val();
			}
			
		});
		$("#next").click(function(){
			var nextPage=parseInt($("#curPage").html())+1;
			var total=parseInt($("#total").html());
			if(nextPage>total){
				alert("已经是最后一页了");
				return;
			}
			location.href="/goods/mainServlet?method=toMain" +
					"&curPage="+nextPage+
					"&g_name="+$("#g_name").val()+
					"&g_price="+$("#g_price").val()+
					"&g_desc="+$("#g_desc").val();
			
		});
	})
	function joinshoping(gid){
		location.href="/goods/mainServlet?method=join&id="+gid;
	}
</script>
</head>
<body  style="margin:0px 50px">
	<div style="background-color:#eeeeee;width: 100%;height: 100px ">
		仿商城
	</div>
	<div style="text-align: center;">
		<form action="/goods/mainServlet?method=toMain" method="post">
			商品名称：<input name="g_name" id="g_name" value="${goods.g_name }">
			商品价格：<input name="g_price" id="g_price" value="${goods.g_price }">
			商品详情：<input name="g_desc" id="g_desc"  value="${goods.g_desc }">
			<input type="submit" value="查询" id="g_desc">
		</form>
		<div style="display: inline-block;margin-left: 100px">
			<c:forEach var="good" items="${list}">
				<div style="border: red solid 1px;float: left;margin-left: 10px;margin-top: 10px">
					
						<div>
							<img alt="图片" src="/goods/img/yifu.jpg">
						</div>
						<div>
							<span>商品名称：</span><em style="color:#000000">${good.g_name } </em>
							
						</div>
						<div>
							<span>原价：</span><em style="text-decoration: line-through;color:#000000">998 </em>
						</div>
						<div>
							<span>现价：</span><em style="color:red">${good.g_price }</em>
						</div>
						<div>
							<span>详情：</span><p>${good.g_desc }</p>
						</div>
						<input type="button" style="color: red;margin-bottom: 10px" 
							value="加入购物车" onclick="joinshoping(${good.id});">
				</div>
			</c:forEach>
		</div>
		<div>
			<a href="javascript:void(0);" id="pre">上一页</a>
		&nbsp;&nbsp;当前<span id="curPage">${goods.curPage }</span>页
		&nbsp;&nbsp;<a  href="javascript:void(0);" id="next">下一页</a>
		&nbsp;&nbsp;共<span id="total">${goods.total }</span>页
		</div>
	</div>
	
	<c:if test="${fn:length(shopping)!=0 }">
		<div style="position: fixed; right: 5px; top: 50%;width: 150px;
			height: 300px;background-color: #dddddd;overflow: auto;">
			
			<c:forEach var="shop" items="${shopping }">
					<div style="border: red solid 1px;">
						<div>
							商品：<span>${shop.g_name }</span>
						</div>
						<div>
							价格：<span>${shop.g_price }</span>
						</div>
						<div>
							数量：<span>${shop.g_nums }</span>
						</div>
						<div>
							<a href="/goods/mainServlet?method=remove&id=${shop.id }">	<span>移除购物车</span></a>
						</div>
					</div>
			</c:forEach>
			
		</div>
	</c:if>
</body>
</html>