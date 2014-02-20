<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Information System</title>
</head>
<body background="./layout/resources/images/iiitb.jpg">
	<h1 align="middle">STUDENT INFORMATION SYSTEM</h1>
	<div align="center">
	<s:form action="loginAction" autocomplete="off">

		<s:textfield key="username" label="Username" />
		<s:password key="password" label="Password" />

		<s:submit />
	</s:form>
	</div>
</body>
</html>