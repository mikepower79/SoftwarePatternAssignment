<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Computing Page</title>

</head>

<body>
	
 You are viewing the <s:property value="category" /> page 

		<table cellspacing="0" cellpadding="0" border="3" width="100%">
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
		<td><s:form action="ipadSelect">
		<s:submit type="image" src="ipad.png"></s:submit>
		</s:form></td>
						
				</tr>
			</s:iterator>
		</table>
		
	<s:form action="addtobasket">
		<s:textfield name="title" label="Product" value=""/>
		<s:textfield name="ammount" label="Quantity" value="" />	
		<s:submit value="Select Item" align="left"/>
	</s:form>
	
	<s:form action= "moreproducts">
		<s:submit value="Select item from other category" align="left" />	
	</s:form>	

</body>
</html>