<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Page</title>
</head>
<body>
PAYMENT PAGE
<br>Postal address
Name: <input type="text" name="name" value='<s:property value="#session.user.getName().toString()" />'><br>
Address Line 1: <input type="text" name="name" value='<s:property value="#session.user.getAddress1().toString()" />'><br>
Address Line 2: <input type="text" name="name" value='<s:property value="#session.user.getAddress2().toString()" />'><br>
Address Line 3: <input type="text" name="name" value='<s:property value="#session.user.getAddress3().toString()" />'><br>



	<br><s:property value="#session.user.getName()" />
	<br><s:property value="#session.user.getAddress1()" />
	<br><s:property value="#session.user.getAddress2()" />
	<br><s:property value="#session.user.getAddress3()" />
	
	<div>
		<br>Your Purchases
		
		<s:iterator value="purchasesList">
			<br>
			1
			<s:property value="quantity" />
			<s:property value="manufacturer" />
			<s:property value="title" />
		@ $<s:property value="price " /> 
		Total cost $<s:property value="price * ammount " />
		</s:iterator>

	</div>
	
	<br><s:form action="makepayment" theme="simple">
	<div>
	Credit Card Type:<s:select  name="payment" list="{'visa','Master card'}"/><br>
	<br> Credit Card Number:<s:textfield name="creditcardnumber"/><br>
	</div>
	<br>Exp Date Month:<s:select name ="expdate" theme="simple"  list="{'01','02','03','04','05','06','07','08','09','10','11','12'}"/>
	Exp Date Year:<s:select name ="expdate" list="{'2015','2016','2017'}"/> <br>
	<br> Security Code:<s:textfield name="creditcardnumber" size="2"/><br>
	
	   <s:submit value="Make Payment"/>
	</s:form>
	</div>
	

</body>
</html>