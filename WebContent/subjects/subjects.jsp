<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subjects Page</title>
</head>
<body>
	<div>
		<span>Show Enrolled Courses</span>
		<table border="1">
			<thead>
				<tr>
					<td>Subject Code</td>
					<td>Subject</td>
					<td>Faculty Name</td>
					<td>Semester</td>
					<td>Enrolled</td>
					<td>Grade</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="subjectInfoList" status="subject">
					<tr>
						<td><s:property value="subjectCode" /></td>
						<td><s:property value="subjectName" /></td>
						<td><s:property value="facultyName" /></td>
						<td><s:property value="semester" /></td>
						<td><s:property value="enrolled" /></td>
						<td><s:property value="grade" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<div>
		<span>Show All Courses</span>
		<table border="1">
			<thead>
				<tr>
					<td>Subject Code</td>
					<td>Subject</td>
					<td>Faculty Name</td>
					<td>Semester</td>
					<td>Enrolled</td>
					<td>Grade</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="selectedSubjectInfoList" status="subject">
					<tr>
						<td><s:property value="subjectCode" /></td>
						<td><s:property value="subjectName" /></td>
						<td><s:property value="facultyName" /></td>
						<td><s:property value="semester" /></td>
						<td><s:property value="enrolled" /></td>
						<td><s:property value="grade" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>