<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grades</title>
</head>
<body>
	
	<form action="grades">
	<s:select list="semesterDisplayList" name="semesterDisplayChoice"></s:select>
	</form>
	
	<form name=semesterDDL>
		<s:select label="Semester" headerKey="-1"
			onchange="onSemesterChange()" headerValue="Select semester"
			list="termList" />
	</form>
	<script type="text/javascript">
		function onSemesterChange() {
			document.semesterDDL.action = 'grades1.action';
			document.semesterDDL.submit();
		}
	</script>
	
	<form name=subjectDDL>
		<s:select label="Subject" headerKey="-1"
			onchange="onSemesterChange()" headerValue="Select subject"
			list="courseList"/>
	</form>

</body>
</html>