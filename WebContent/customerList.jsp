<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Customer List</title>

</head>
<body>
<h1>Customers</h1><br>

<table cellspacing="0" cellpadding="0" border="3" width="100%">
			<tr style="font-weight: bold">
				<td><s:text name="Name" /></td>
				<td><s:text name="Address Line 1" /></td>
				<td><s:text name="Address Line 2" /></td>
				<td><s:text name="Address Line 3" /></td>
				<td><s:text name="Email" /></td>
			</tr>
			
			<s:iterator value="customerList" status="stat">
				<tr>
						<td><s:property value="name" /></td>
						<td><s:property value="address1" /></td>
						<td><s:property value="address2" /></td>
						<td><s:property value="address3" /></td>
						<td><s:property value="email" /></td>
				</tr>
			</s:iterator>
		</table>
</body>
</html>