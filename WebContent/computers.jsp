<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Computing Page</title>
<style>
table, td, th, tr {
    border: 1px solid black;
}

table {
    width: 100%;
}

th {
    text-align: center;
}

tr {
    text-align: center;
}
</style>
</head>

<body>
	
 You are viewing the <s:property value="category" /> page 

		<table cellspacing="0" cellpadding="0" border="3" width="500">
			<tr style="font-weight: bold">

				<td><s:text name="Item ID"/></td>
				<td><s:text name="Title" /></td>
				<td><s:text name="Manufacturer" /></td>
				<td><s:text name=" Price" /></td>
				<td><s:text name="Category" /></td>
				<td><s:text name=" Stock" /></td>
				<td><s:text name="Image" /></td>
				
			</tr>
			<s:iterator value="itemList" status="stat">
				<tr>

					<td><s:property value="item_id"/></td>
						<td><s:property value="title" /></td>
						<td><s:property value="manufacturer" /></td>
						<td><s:property value="price" /></td>
						<td><s:property value="category" /></td>
						<td><s:property value="quantity" /></td>
						<td><img alt="" src='<s:property value="image" />'
							height="100" width="200" /></td>
						
				</tr>
			</s:iterator>
		</table>

	<s:form action="addtobasket">
		<s:textfield name="id" label="Item id" value=""/>
		<s:textfield name="ammount" label="Amount" value="" />	
		<s:submit value="Add to basdket" align="left"/>
	</s:form>
	
	<s:form action= "proceedtocheckout">
		<s:submit value="More products" align="left" />	
	</s:form>	

</body>
</html>