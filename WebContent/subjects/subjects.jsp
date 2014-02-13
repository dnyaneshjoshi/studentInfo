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
		<div style="width: 20%; float: left;">Pic will come here</div>
		<div style="width: 60%; float: left;">
			<form action="subjectsAction" method="post" id="subjectsForm">
				<div style="text-align: center">
					<s:select list="subjectDisplayList" name="subjectDisplayChoice"
						onchange="javascript:submitForm()"></s:select>
				</div>
				<div>
					<table border="1" style="margin: 0px auto">
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
									<td>
									<s:url
											action="syllabusAction" var="syllabusURL">
											<s:param name="subjectCode" value="subjectCode" />
									</s:url>
									<s:a href="%{syllabusURL}"><s:property value="subjectCode" /></s:a> 
										</td>
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