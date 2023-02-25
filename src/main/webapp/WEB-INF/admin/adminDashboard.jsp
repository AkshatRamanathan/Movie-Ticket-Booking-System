<%@page import="midterm.model.UserSession"%>
<%@page import="midterm.model.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<style>
.home {
	text-align: center;
	background-color: #f2f2f2;
	padding: 10px;
	border-radius: 5px;
	box-shadow: 0px 0px 10px 0px #ccc;
	margin: 10px auto;
	width: 100%;
}

img {
	-webkit-user-drag: none;
	-moz-user-drag: none;
	-o-user-drag: none;
	user-drag: none;
}

img {
	pointer-events: none;
}

.movie_card {
	padding: 0 !important;
	width: 22rem;
	margin: 14px;
	border-radius: 10px;
	box-shadow: 0 3px 4px 0 rgba(0, 0, 0, 0.2), 0 4px 15px 0
		rgba(0, 0, 0, 0.19);
}

.movie_card img {
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	height: 13rem;
}

.movie_info {
	color: #5e5c5c;
}

.movie_info i {
	font-size: 20px;
}

.card-title {
	width: 80%;
	height: 4rem;
}

.play_button {
	background-color: #ff3d49;
	position: absolute;
	width: 60px;
	height: 60px;
	border-radius: 50%;
	right: 20px;
	bottom: 111px;
	font-size: 27px;
	padding-left: 15px;
	padding-top: 16px;
	color: #FFFFFF;
	cursor: pointer;
}

.credits {
	margin-top: 20px;
	margin-bottom: 20px;
	border-radius: 8px;
	border: 2px solid #8e24aa;
	font-size: 18px;
}

.credits .card-body {
	padding: 0;
}

.credits p {
	padding-top: 15px;
	padding-left: 18px;
}

.credits .card-body i {
	color: #8e24aa;
}
</style>
</head>
<body>

	<ul>
		<li class="logo"><img src="logo.png" alt="Logo"></li>
		<li class="center">BookMyMovie</li>

		<li><a href="controller?action=viewMovie"
			style="text-decoration: none">View Movies</a></li>
		<li><a href="controller?action=addMovie"
			style="text-decoration: none">Add Movie</a></li>
		<li><a href="controller?action=userProfile"
			style="text-decoration: none">Profile</a></li>
		<li><a href="logout" style="text-decoration: none">Logout</a></li>
	</ul>

	<!-- Add your content below -->
	<div style="padding: 20px">
		<%
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		%>
		<div class="home">
			<h1>Welcome Admin ${userSession.getUsername()}</h1>
			<h3>You can edit the available movies below</h3>
		</div>
	</div>

	<div class="row justify-content-center">

		<%
		ArrayList<Movie> movies = (ArrayList<Movie>) request.getAttribute("movies");
		if (movies != null) {
			for (Movie movie : movies) {
		%>
		<div class="card movie_card">
			<div class="card-body">
				<a style="text-decoration: none"
					href="controller?action=editMovie&id=<%=movie.get_id().toString()%>"><i
					class="fas fa-edit play_button" data-toggle="tooltip"
					data-placement="bottom" title="Book"> </i></a>
				<h5 class="card-title"><%=movie.getName()%></h5>
				<span class="movie_info"><%=movie.getRelease_date()%></span> <span
					class="movie_info float-right"><i class="fas fa-wallet"></i>
					<%=movie.getCost()%></span>
			</div>
		</div>
		<br />
		<%
		}
		}
		%>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


</body>
</html>
