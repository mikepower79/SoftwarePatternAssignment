<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<h1>Admin Page</h1>

Welcome
	<s:property value="#session.user.getName()" />
	<h2>View Stock</h2>
	
	
	
	<div class="navbar">
		<div class="navbar-inner">
		<div class="container">
		<ul class="nav nav-pills">
		
		<li><s:form action="computersAdmin">
		<s:submit value="Computing"></s:submit>
		</s:form></li>
		
		<li><s:form action="tvAdmin">
		<s:submit value="TV & Entertainment"></s:submit>
		</s:form></li>
		
		<li><s:form action="kitchenAppliancesAdmin">
		<s:submit value="Kitchen Appliances"></s:submit>
		</s:form></li>
		
		<li><s:form action="camerasAdmin">
		<s:submit value="Cameras"></s:submit>
		</s:form></li>
		
		<li><s:form action="updateStock">
		<s:submit value="Update Stock"></s:submit>
		</s:form></li>
		
		<li><s:form action="viewCustomers">
		<s:submit value="Customer List"></s:submit>
		</s:form></li>
		
		<li><s:form action="logout">
		<s:submit value="Logout" style="float: right;"></s:submit>
		</s:form></li>
		
	</ul>
		</div>
		</div>
		</div>
	
</body>
</html>