<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title><s:text name="Student Information System" /></title>
<link rel="stylesheet" href="mystyle.css" type="text/css" />
</head>
<body align="center">
	<center><center><b>MyProfile</b></center></center><br>
		<br>
		<table bgcolor="#f0edd9" align="center" bordercolor="#0000FF">
			<tr>
				<td><s:actionerror /> <s:form action="edit">
				</br>Roll No : <s:property value="rollno"/></h4>
				</br></br>Name : <s:property value="name"/></h4>
				</br></br>
				Interests :
				<ol>
				<s:iterator value="defaultInterests">
  				<li><s:property /></li>
				</s:iterator>
				</ol>
				<s:submit value="Edit"/>
				</s:form></td>
			</tr>
		</table>
	</body>