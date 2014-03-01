<%@page import="sun.text.normalizer.CharTrie.FriendAgent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyFriends Page</title>

<script src="js/jquery.js">
	
</script>

<script src="js/main.js"></script>

<script src="js/jquery.bxslider.min.js"></script>
<!-- bxSlider CSS file -->
<link href="css/jquery.bxslider.css" rel="stylesheet" />
</head>
<body>
	<h2 style="color: #412066;">My Friends</h2>



	<ul class="bxslider">
		<s:iterator value="students" var="student">
			<s:url id="friend" action="friendProfile" var="myurl">
				<s:param name="friendNo">
					<s:property value="#student.rollNo" />
				</s:param>

			</s:url>
			
			<li><a href='<s:property value="#myurl"/>'><img width="120px"
					src="imageAction?rollNo=<s:property value="#student.rollNo"/>"
					title='<s:property
						value="#student.name" />' /></a></li>




		</s:iterator>

	</ul>


</body>
</html>
