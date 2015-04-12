<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ipad</title>
</head>
<body>
You have selected 1

<s:iterator value="selectedList" status="stat">
				<tr>
						<td><s:property value="manufacturer" /></td>
						<td><s:property value="title" /></td> @
						<td><s:property value="price" /></td> euros
						
				</tr>
			</s:iterator>
			
			<s:form action= "proceedToCheckout">
		<s:submit value="Proceed To Checkout" align="left" />	
	</s:form>	
</body>
</html>