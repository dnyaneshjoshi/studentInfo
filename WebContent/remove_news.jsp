<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove news</title>
</head>
<body>
	<h1 align="middle">STUDENT INFORMATION SYSTEM</h1>
	<h2>remove news</h2>
	<s:form action="removenews">
		<s:textfield key="name" label="name" />
		<s:submit />
	</s:form>

<a href="adminhome.jsp"> BACK </a>
</body>
</html>