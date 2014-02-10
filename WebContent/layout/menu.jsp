<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%">
		<tr>
			<td>
				<form method="post" action="searchFriendsAction">
					<input type="text" name="searchValue" />
					<input type="submit" value="Search" />
				</form>
			</td>
			<td><a href="homeAction">Home</a></td>
			<td><a href="gradesAction">Grades</a></td>
			<td><a href="subjectsAction">Subjects</a></td>
			<td><a href="friendsPage">My Friends</a></td>
		</tr>
	</table>
	
	
	
</body>
</html>