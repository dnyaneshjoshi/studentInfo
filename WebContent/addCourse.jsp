<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Course</title>
<a href="adminhome.jsp">Back</a>
<script type="text/javascript">
function validateForm(form) {
	var doc = form.elements;
	  if(doc['code'].value == '') {
	    alert('Course Code cannot be empty');
	    doc['code'].focus();
	    return false;
	  }
	  if(doc['name'].value == '') {
		    alert('Course Name cannot be empty');
		    doc['name'].focus();
		    return false;
	  }
	  if(doc['credit'].value == '') {
		    alert('Credits cannot be empty');
		    doc['credi'].focus();
		    return false;
	  }
	  if(doc['lastDate'].value == '') {
		    alert('Last Date cannot be empty');
		    doc['lastDate'].focus();
		    return false;
	  }
	  return true;
    }
</script>
</head>
<body>
		<h1>Add Course</h1>
		<div style="text-align:left">
		<form action="addSubjectsAction" method="post" onsubmit="return validateForm(this)">
			<table width="50%">
			<tr>
				<td>
					<s:textfield key="code" label="Course Code "></s:textfield>
				</td>
				<td>
					<s:textfield key="name" label="Course Name "></s:textfield>
				</td>
			</tr>
			<tr>
				<td>
					<s:select name="semester" list="semesterList" label="Semester " cssStyle="width:230px;"></s:select>
				</td>
				<td>
					<s:textfield key="credit" label="Credits "></s:textfield>
				</td>
			</tr>
			<tr>
				<td>
					<s:select name="faculty" list="facultyList" label="Faculty " cssStyle="width:230px;"></s:select>
				</td>
				<td>
					<s:textfield key="lastDate" label="Last Date for Enrollnment (DD/MM/YYYY) "></s:textfield>
				</td>
			</tr>
			<tr>
				<td>
				<s:submit align="left" value="Submit"/>
				</td>
			</tr>
			</table>
		
		</form>
		</div>
</body>
</html>