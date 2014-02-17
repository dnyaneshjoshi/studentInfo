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
				</br></br><s:select label="Interests" name="interesttype" headerKey="- - -"
							headerValue="View Interests" list="interests">
							<s:param name="value">
								<s:property value="interests" />
							</s:param>
				</s:select>
				<s:submit value="Edit" href="EditProfile.jsp"/>
					</s:form></td>
			</tr>
		</table>
	</body>