<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ICICIBankApp</title>
</head>
<body>
	
	<%
		String email = request.getParameter("user");
		int balance = 10000;
		
		Integer bal = (Integer) session.getAttribute("balance");
		if(bal != null) {
			balance = bal.intValue();
		}
	%>	
	<h1>Your current balance is : <%= balance %></h1>
	
</body>
</html>