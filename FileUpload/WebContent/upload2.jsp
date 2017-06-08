<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<form action="uploadServlet2" method="post" enctype="multipart/form-data">
		<input type="file" name="fileName1">
		<input type="file" name="fileName2">
		<input type="file" name="fileName3">
		<input type="submit" value="上传"> 
	</form>
</body>
</html>