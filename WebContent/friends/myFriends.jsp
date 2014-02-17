<%@page import="sun.text.normalizer.CharTrie.FriendAgent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyFriends Page</title>
</head>
<body>
	<h2 style="color:#412066;">My Friends</h2>

	<s:url id="friend" action="friendProfile" var="myProfileurl">
		<s:param name="friendNo">
			<s:property value="%{myProfile.rollNo}" />
		</s:param>

	</s:url>
	<table cellpadding="10">
		<tr>
			<th align="center">My Photo</th>
			<th align="center">Friends List</th>
		</tr>

		<tr>
			<td><a href='<s:property value="#myProfileurl"/>'><img
					width="100" height="100"
					src="layout/resources/images/<s:property value="%{myProfile.photo}" />" />
					<br>
					<h3>
						<s:property value="%{myProfile.name}" /></a>
			</h3></td>
			<td><table cellpadding="25">


					<tr>
						<s:iterator value="students" var="student">
							<s:url id="friend" action="friendProfile" var="myurl">
								<s:param name="friendNo">
									<s:property value="#student.rollNo" />
								</s:param>

							</s:url>
							<td>
								<table>
									<tr>
										<td><a href='<s:property value="#myurl"/>'><img
												height="50" width="50"
												src="layout/resources/images/<s:property value="#student.photo"/>" /></a></td>
									</tr>


									<tr>
										<td><a href='<s:property value="#myurl"/>'><h3
													align="middle">
													<s:property value="#student.name" />
												</h3> </a></td>
									</tr>
								</table>

							</td>

						</s:iterator>
					</tr>
				</table></td>
		</tr>

		<%-- <tr>
			<s:form action="friendProfile">
				<s:textfield tooltip="search Profile by rollNumber to add as Friend"
					label="search Profile" key="friendNo"></s:textfield>
				<s:hidden key="rollNo" value="%{myProfile.rollNo}"></s:hidden>
				<s:submit label="search" value="search" />
			</s:form>
		</tr> --%>
	</table>
</body>
</html>
