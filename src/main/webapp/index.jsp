<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<body>
<form action="<%=basePath %>user/addUser" method="post" >
用户名：<input type="text" id="userName" name="userName"/>&nbsp;&nbsp;
密码：<input type="text" id="password" name="password"/>&nbsp;&nbsp;
<input type="submit"  id="addBtn" value="添加"/>
</form>
</body>
</html>