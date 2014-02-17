<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href='view'>
		<object width="180px" data='layout/resources/images/<s:property value="#session.user.photo" />'>
			<img width="180px" src='layout/resources/images/default_photo.png' />
		</object>
	</a>
	<br>
	Last logged on: <s:property value="lastLoggedOn" />
</body>
</html>
