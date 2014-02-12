<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body style="background-color:#efefff;">
   <tiles:insertAttribute name="banner" />
   <hr style="color:#3f3fbf;" />
   <tiles:insertAttribute name="menu" />
   <hr style="color:#3f3fbf;" />
   <table width="100%">
   		<colgroup>
			<col style="width:200px" />
			<col />
		</colgroup>
		<tbody>
			<tr>
				<td><tiles:insertAttribute name="pic" /></td>
				<td><tiles:insertAttribute name="body" /></td>
			</tr>
		</tbody>
   </table>
   <hr style="color:#3f3fbf;" />
   <br />
   <table width="100%">
		<colgroup>
			<col style="width:50%" />
			<col style="width:50%" />
		</colgroup>
   		<thead>
   			<tr>
   				<td align="center"><b>ANNOUNCEMENTS</b></td>
   				<td align="center"><b>NEWS</b></td>
   			</tr>
   		</thead>
   		<tbody>
			<tr>
				<td align="center"><div align="left" style="height:300px; width:99%; word-wrap:break-word; border:2px solid; border-color:#3f3fbf;"><tiles:insertAttribute name="footerAnnouncements" /></div></td>
				<td align="center"><div align="left" style="height:300px; width:99%; word-wrap:break-word; border:2px solid; border-color:#3f3fbf;"><tiles:insertAttribute name="footerNews" /></div></td>
			</tr>
   		</tbody>
	</table>
</body>
</html>
