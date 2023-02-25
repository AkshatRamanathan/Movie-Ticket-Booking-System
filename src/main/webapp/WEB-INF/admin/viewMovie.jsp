<%@page import="midterm.model.Movie"%>
<%@page import="com.mongodb.MongoClient"%>
<%@page import="midterm.dao.MovieDAO"%>
<%@page import="midterm.model.Order"%>
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
<style type="text/css">

/* Add your table styling below */
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<ul>
		<li class="logo"><img src="logo.png" alt="Logo"></li>
		<li class="center">BookMyMovie</li>

		<li><a href="controller?action=userDashboard"
			style="text-decoration: none">Dashboard</a></li>
		<li><a href="controller?action=addMovie"
			style="text-decoration: none">Add Movie</a></li>
		<li><a href="controller?action=userProfile"
			style="text-decoration: none">Profile</a></li>
		<li><a href="logout" style="text-decoration: none">Logout</a></li>
	</ul>



	<!-- Add your table of data below -->
	<div style="padding: 50px">
		<h1>Available Movies List</h1>
		<hr>
		<table>
			<tr>
				<th>Movie Name</th>
				<th>Genre</th>
				<th>Cost</th>
				<th>Release Date</th>
				<th>Seats Left</th>
				<th>Delete</th>
			</tr>
			<%
			ArrayList<Movie> movies = (ArrayList<Movie>) request.getAttribute("movies");
			MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
			MovieDAO movieDAO = new MovieDAO(mongoClient);

			if (movies != null) {
				for (Movie movie : movies) {
			%>
			<!-- Add more rows of data as needed -->
			<tr>
				<td><%=movie.getName()%></td>
				<td><%=movie.getGenre()%></td>
				<td><%=movie.getCost()%></td>
				<td><%=movie.getRelease_date()%></td>
				<td><%=movie.getSeats_left()%></td>

				<td><a data-toggle="tooltip" data-placement="bottom"
					title="Cancel" href="viewMovie?id=<%=movie.get_id().toString()%>">
						<i class="far fa-window-close"></i>
				</a></td>


			</tr>

			<%
			}
			}
			%>
		</table>
	</div>

	<script type="text/javascript">
		function viewRow(button) {
			var row = button.parentNode.parentNode;
			var cells = row.getElementsByTagName("td");
			console.log(cells[0].innerHTML);
		}
	</script>

</body>
</html>