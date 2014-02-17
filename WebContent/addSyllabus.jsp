<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Syllabus</title>
<a href="adminhome.jsp">Back</a>
</head>
<body>
		<h1>Add Syllabus</h1>
		<div style="text-align:left">
		<form action="addSyllabusAction" method="post" >
			<table width="50%">
			<tr>
				<td>
					<s:select name="subjectName" list="subjectCodeList" label="Course Name "></s:select>
				</td>
			</tr>
			<tr>
				<td>
					<s:textarea key="topic" label="Syllabus " cols="100" rows="10"></s:textarea>
				</td>
			</tr>
			<tr>
				<td>
				<s:submit align="left" value="Submit"/>
				</td>
				<td>			
				</td>
			</tr>
			</table>
		
		</form>
		</div>
</body>
</html>