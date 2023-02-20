<%@page import="midterm.model.UserSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css" >
</head>
<body>

	<ul>
		<li class="logo"><img src="logo.png" alt="Logo"></li>
		<li class="center">BookMyMovie</li>
		
		<li><a href="userProfile">Profile</a></li>
		<li><a href="logout">Logout</a></li>
	</ul>

	<!-- Add your content below -->
	<div style="padding:50px">
	<%
		UserSession userSession = (UserSession)session.getAttribute("userSession");	
	%>
      <h1>Welcome User..... <% out.append(userSession.getUsername()); %> </h1>
            
      <p>Welcome to my MVC home</p>
    </div>

</body>
</html>
