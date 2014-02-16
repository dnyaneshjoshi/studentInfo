<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title><s:text name="Student Information System"/></title>
<link rel="stylesheet" href="mystyle.css" type="text/css" />
</head>
<body align="center">
<center>
<b>Edit Profile</b></center><br><br>
<table bgcolor="#f0edd9" align="center" bordercolor="#0000FF">
<tr>
<td>
<s:actionerror/>
<s:form action="submit" method="post" enctype="multipart/form-data">
	<s:textfield name="rollno" label="Roll No" readonly="true">
		<s:param name="value"><s:property value="rollno"/></s:param>		
	</s:textfield>
	<s:textfield name="name" label="Name" size="15">
		<s:param name="value"><s:property value="name"/></s:param>			
	</s:textfield>
	
	<s:textfield name="password" label="Password">
		<s:param name="value"><s:property value="password"/></s:param>		
	</s:textfield>
	<s:checkboxlist list="{'cricket','football','badminton','hockey'}" name="interests" label="Interests"></s:checkboxlist>
	 <s:file name="fileUpload" label="Select a File to change photo"/>
 	<s:submit value="Submit"/>
</s:form>
</td>
</tr>
</table>
</body>