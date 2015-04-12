<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Purchase History</title>

</head>
<body>
<h1>Purchase History</h1><br>

<table cellspacing="0" cellpadding="0" border="3" width="100%">
			<tr style="font-weight: bold">
				<td><s:text name="Purchases Id" /></td>
				<td><s:text name="Title" /></td>
				<td><s:text name="Manafacturer" /></td>
				<td><s:text name="Price" /></td>
				<td><s:text name="Quantity" /></td>
			</tr>
			
			<s:iterator value="purchasesList" status="stat">
				<tr>
						<td><s:property value="purchase_id" /></td>
						<td><s:property value="title" /></td>
						<td><s:property value="manufacturer" /></td>
						<td><s:property value="price" /></td>
						<td><s:property value="quantity" /></td>
				</tr>
			</s:iterator>
		</table>
</body>
</html>