<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add users</title>
<script type="text/javascript">
function student()
{
	var x=document.getElementById("mySelect");
	  
if((x.options[x.selectedIndex].text)!='S')
	{
	//document.getElementById("student_id").disabled=true;
	//document.getElementById("roll_no").disabled=true;
	//document.getElementById("hostel_addr").disabled=true;
	//document.getElementById('roll_no').style.visibility = 'visible';        
    
	}
}
</script>

</head>
<body>

	<h3 align="middle">STUDENT INFORMATION SYSTEM</h3>
	<br>
	<h3 align="middle">Add the user details</h3>
	<br>
	<s:form action="adduser" method="post" enctype="multipart/form-data"
		autocomplete="off">

		<s:textfield key="username" label="Username" />
		<s:textfield key="name" label="Name" />


		<s:textfield key="emailId" label="Email Id" />
		<s:password key="password" label="Password" />

		<s:textfield id="roll_no" key="roll_no" label="Roll No" />
		<s:textfield id="hostel_addr" key="hostel_addr" label="Hostel Addr" />
		<s:textfield id="dob" key="dob" label="Date of Birth (dd/mm/yyyy)" />
		<s:file name="fileUpload" label="Select a File to change photo" />
		<s:submit label="Add" />
	</s:form>
	<br>
	<a href="adminhome.jsp"> BACK </a>


</body>
</html>