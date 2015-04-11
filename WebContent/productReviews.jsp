<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Reviews</title>
</head>
<body>
<h1>Product Reviews</h1>
		
		<s:form action="ipadReview">
		<s:submit type="image" src="ipad.png"></s:submit>
		</s:form>
		
		<s:form action="macbookReview">
		<s:submit type="image" src="macbook.png"></s:submit>
		</s:form>
		
		<s:form action="tvReview">
		<s:submit type="image" src="tv.png"></s:submit>
		</s:form>
		
		<s:form action="cameraReview">
		<s:submit type="image" src="nikon.png"></s:submit>
		</s:form>
	
</body>
</html>