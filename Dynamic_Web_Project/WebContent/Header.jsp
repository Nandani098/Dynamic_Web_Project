<%@page import="in.co.rays.Bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- <h3> Hii Guest..!!</h3> -->
	
	

	<%
		/* UserBean user = (UserBean) request.getAttribute("user"); */
		
		UserBean user = (UserBean) session.getAttribute("user");
		
	%>

	<%
		if (user != null) {
	%>

	<h3>
			HI,
			
			<%=user.getFirstName() %>
			
	
	</h3>
	
	<a href= "UserCtl.do">Add User</a> |
	<a href = "UserListCtl.do">User List</a>
  <a href= "LoginCtl?operation=logout">Logout</a> 
	 
	<!--  ye session destroy k liye tha
	 -->

	<%
		}else{
		
	%>
	
	<h3> Hi,Guest</h3>
	
	<% 
		}
	%>
	
	<hr>
	
</body>
</html>