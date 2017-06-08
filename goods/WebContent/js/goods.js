$(function(){
	$("#add").click(function(){
		location.href="/goods/view/addGoods.jsp";
	});
	$("#pre").click(function(){
		var prePage=$("#curPage").html()-1;
		if(prePage<1){
			alert("已经是第一页")
		}else{
			location.href="/goods/goodsServlet?method=query" +
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
		location.href="/goods/goodsServlet?method=query" +
				"&curPage="+nextPage+
				"&g_name="+$("#g_name").val()+
				"&g_price="+$("#g_price").val()+
				"&g_desc="+$("#g_desc").val();
		
	});
});

function check(){
	
	return true;
}