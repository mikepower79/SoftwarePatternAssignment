<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Reviews</title>
</head>
<body>
<h1>Product Reviews</h1>

<table cellspacing="0" cellpadding="0" border="3" width="500">
			<tr style="font-weight: bold">

				<td><s:text name="Manufacturer" /></td>
				<td><s:text name=" Title" /></td>
				<td><s:text name="Image" /></td>
				<td><s:text name=" Comment" /></td>
				
			</tr>
			<s:iterator value="reviewList" status="stat">
				<tr>
						<td><s:property value="manufacturer" /></td>
						<td><s:property value="title" /></td>
						<td><img alt="" src='<s:property value="image" />'
							height="100" width="200" /></td>
						<td><s:property value="comment" /></td>
						
				</tr>
			</s:iterator>
		</table>
</body>
</html>