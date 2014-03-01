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
		<h2 style="color: #412066;">Enrollment of Subjects</h2>
		<div style="width: 60%; float: left;">
			<b>Register yourself to new courses</b>
			<form action="Index">
				<s:select name="semester" list="semester" label="Semester"></s:select>
				<input type="submit" value="Register" />
			</form>

		</div>
		<div style="width: 20%; float: left;"></div>
	</div>
</body>

<script type="text/javascript">
	function submitForm() {
		document.getElementById("subjectsForm").submit();
	}
</script>
</html>