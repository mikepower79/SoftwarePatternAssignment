<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout Page</title>
</head>
<body>
<h1>Checkout</h1>
<s:property value="manufacturer" />

		<s:iterator value= "purchasesList">
		<s:property value="manufacturer" />
		<s:property value="title" />
		@ $<s:property value="price " /> each
		Total cost $<s:property value="price *ammount " />
	      </s:iterator>
	      
	      <s:iterator value="userList">
	      <s:property value="name" />
	      </s:iterator>
	      
	      <s:form action= "updatedatabases">
	 	  
	<s:submit value="purchases" align="left" />	
	</s:form>
</body>
</html>