<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Course</title>
<a href="adminhome.jsp">Back</a>
</head>
<body>
		<h1>Add Course</h1>
		<div style="text-align:left">
		<form action="">
			<table width="50%">
			<tr>
				<td>
					<s:textfield key="code" label="Course Code "></s:textfield>
				</td>
				<td>
					<s:textfield key="name" label="Course Name "></s:textfield>
				</td>
			</tr>
			<tr>
				<td>
					<s:textfield key="term" label="Semester "></s:textfield>
				</td>
				<td>
					<s:textfield key="year" label="Year "></s:textfield>
				</td>
			</tr>
			<tr>
				<td>
					<s:textfield key="faculty" label="Faculty "></s:textfield>
				</td>
				<td>
					<s:textfield key="lastDate" label="Last Date for Enrollnment "></s:textfield>
				</td>
			</tr>
			<tr>
				<td>
				<s:submit align="left" value="Submit"/>
				</td>
			</tr>
			</table>
		
		</form>
		</div>
</body>
</html>