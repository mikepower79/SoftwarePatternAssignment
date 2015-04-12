<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Macbook Reviews</title>

</head>
<body>
<h1>Macbook Reviews page!!!!!!!!!!!!!</h1><br>

<s:form action="addipadReview" method="post">

Name: <input type="text" name="name" value='<s:property value="#session.user.getName().toString()" />'><br>

Product: <input type="text" value="Macbook Pro" name="product" size = 20 /><br>

Comment: <input type="text" name="comment" size = 100 /><br>

Rating: <input type="number" name="rating" size = 10 /><br>

<s:submit value="Add Review" align="left" />

</s:form><br><br>

<table cellspacing="0" cellpadding="0" border="3" width="100%">
			<tr style="font-weight: bold">
				<td><s:text name="Name" /></td>
				<td><s:text name="Product" /></td>
				<td><s:text name="Comment" /></td>
				<td><s:text name="Rating 1-5" /></td>
				<td><s:text name="Date" /></td>
			</tr>
			
			<s:iterator value="reviewList" status="stat">
				<tr>
						<td><s:property value="name" /></td>
						<td><s:property value="product" /></td>
						<td><s:property value="comment" /></td>
						<td><s:property value="rating" /></td>
						<td><s:property value="date" /></td>
				</tr>
			</s:iterator>
		</table>
</body>
</html>