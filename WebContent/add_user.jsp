<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add users</title>
</head>
<body>

<h3 align="middle">STUDENT INFORMATION SYSTEM</h3>
	<br>
<h3 align="middle">Add the user details</h3>	
	<br>
	<s:form action="adduser" method="post">

		<s:textfield key="username" label="username" />
		<s:textfield key="name" label="name" />
		<s:textfield key="userType" label="userType(only A,S,F)" />
		<s:textfield key="emailId" label="emailId" />
		<s:textfield key="password" label="password" />
		
		
		<s:submit label="Add"/>
	</s:form>
	<br>
<a href="adminhome.jsp"> BACK </a>
	

</body>
</html>