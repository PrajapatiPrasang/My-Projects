<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
if(session.getAttribute("user_name")==null)
{
	response.sendRedirect("../user/index.jsp");	
}
%>

<%
		
		if(session.getAttribute("type")==null){
	%>
			<%@include file="../user/adminheader.jsp" %>
	<%}%>




 <center>
<a href="<%= request.getContextPath()%>/payrollController?flag=generatepaycheck"><button style="background-color:blue; color:white">Generate Paycheck</button></a><br><br><br><br>

 </center>


</body>
</html>