<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title><s:text name="Student Information System" /></title>
<link rel="stylesheet" href="mystyle.css" type="text/css" />
</head>
<body align="center">
	<center><b>MyProfile</b></center><br>
		<br>
		<table bgcolor="#f0edd9" align="center" bordercolor="#0000FF">
			<tr>
				<td><s:actionerror /> <s:form action="edit">
						<s:textfield name="rollno" label="Roll No" readonly="true">
							<s:param name="value">
								<s:property value="rollno" />
							</s:param>
						</s:textfield>
						<s:textfield name="name" label="Name" size="15" readonly="true">
							<s:param name="value">
								<s:property value="name" />
							</s:param>
						</s:textfield>

						<s:textfield name="password" label="Password" readonly="true">
							<s:param name="value">
								<s:property value="password" />
							</s:param>
						</s:textfield>
						<s:select label="Interests" name="interesttype" headerKey="- - -"
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