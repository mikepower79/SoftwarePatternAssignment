<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="utf-8">
	<title>DT354 Online Electronics Store</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
</head>

<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
}

li {
    float: left;
}

a {
    display: block;
    width: 100px;
    background-color: #dddddd;
}
</style>

<body>
	<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js.bootstrap.min.js"></script><br>
	
	<div class="container">
	<h1><p align = "center">DT354 Electronics Store</h1></p>
	
	<s:form action="logout">
	<s:submit theme="simple" class="btn btn-primary" value="Logout" style="float: right;"></s:submit><br>
	</s:form>
	
	Welcome <s:property value="#session.user.getName().toString()" /><br>
	You have successfully logged in<br>
	
	<div class="navbar">
		<div class="navbar-inner">
		<div class="container">
		<ul class="nav nav-pills">
		<li><s:form action="computers">
		<s:submit value="Computing"></s:submit>
		</s:form></li>
		
		<li><s:form action="tv">
		<s:submit value="TV & Entertainment"></s:submit>
		</s:form></li>
		
		<li><s:form action="kitchenAppliances">
		<s:submit value="Kitchen Appliances"></s:submit>
		</s:form></li>
		
		<li><s:form action="cameras">
		<s:submit value="Cameras"></s:submit>
		</s:form></li>
		
		</ul>
		</div>
		</div>
		
		<img src="electronics.jpg"  style="width: 100%" style="height: 100%"> 
		</div>
		</div>
</body>
</html>