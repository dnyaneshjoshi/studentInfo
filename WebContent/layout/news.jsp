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
	<marquee direction="up" height="100%" onmouseover="this.stop();" onmouseout="this.start();">
		<ol>
		<s:iterator value="allNews" status="NewsItem">
			<li><b><s:property value="name"/></b><br /><small><s:property value="details"/></small><hr /></li>
		</s:iterator>
		</ol>
	</marquee>
</body>
</html>
