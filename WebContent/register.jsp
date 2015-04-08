<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<s:form action="register">  
<s:textfield name="name" label="Name"></s:textfield>
<s:textfield name="address1" label="Address line 1"></s:textfield>
<s:textfield name="address2" label="Address line 2"></s:textfield>
<s:textfield name="address3" label="Address line 3"></s:textfield> 
<s:textfield name="email" label="Email"></s:textfield>  
<s:textfield name="userName" label="UserName"></s:textfield>
<s:password name="password" label="Password"></s:password>
<s:submit value="Register"></s:submit>
</s:form>
</body>
</html>