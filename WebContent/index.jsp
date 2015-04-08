<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DT354 Electronics Store</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<style> 
body {
    background: background.jpg;
    background-size: 100%;
    background-repeat: no-repeat;
    padding-top: 40px;
}
</style>

</head>
<body>
<body background="background.jpg">

	<div class="container">
	
			<div class="span4" id="sidebar">
	
				<div class="well">
				
				<s:form action="loginaction">
					
					<h3>DT354 Electronics Store</h3>
						<legend>Login</legend>
						<s:textfield theme="simple" name="userName" class="input-block-level" placeholder="username"></s:textfield>
						<s:password theme="simple" name="password" class="input-block-level" placeholder="password"></s:password>
						<s:submit theme="simple" class="btn btn-primary" value="Login"></s:submit><br><br>		
						
						New Customer?  <a href="register.jsp" class="btn btn-info">Register</a>
				</s:form>
	</div>
	
	</div>
	</div>
	
</body>
</html>