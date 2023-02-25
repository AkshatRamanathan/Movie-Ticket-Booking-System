<!DOCTYPE html>
<%@page import="midterm.model.UserSession"%>
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
/* Add your registration form styling here */
.registration-form {
	background-color: #f2f2f2;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0px 0px 10px 0px #ccc;
	margin: 50px auto;
	width: 500px;
}

.form-control {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>

	<ul>
		<li class="logo"><img src="logo.png" alt="Logo"></li>
		<li class="center">BookMyMovie</li>

		<li><a href="controller?action=viewBooking" style="text-decoration: none">My Bookings</a></li>
		<li><a href="controller?action=userDashboard" style="text-decoration: none">Dashboard</a></li>
		<li><a href="logout" style="text-decoration: none" >Logout</a></li>
	</ul>

	<%
	UserSession userSession = (UserSession) session.getAttribute("userSession");
	%>
	<!-- Add your registration form below -->
	<div class="registration-form">
		<h2>User Profile</h2>
		<form action="userProfile?update=details" method="post">
			<label for="username">Username</label> <input type="text"
				id="username" name="username" class="form-control"
				value="${userSession.getUsername()}" required> <label
				for="email">Email</label> <input type="email" id="email"
				name="email" class="form-control" value="${userSession.getEmail()}"
				required> <input type="hidden" name="page"
				value="editProfile" /> <input type="submit" value="Submit">
		</form>
	</div>

	<div class="registration-form">
		<h2>Update Password</h2>
		<form action="userProfile?update=pass" method="post">
			<label for="password">Current Password</label> <input type="password"
				id="password" name="password" class="form-control" value="" required>

			<label for="new_password">New Password</label> <input type="password"
				id="new_password" name="new_password" class="form-control" value=""
				required> <label for="confirm_password">Confirm New
				Password</label> <input type="password" id="confirm_password"
				name="confirm_password" class="form-control" value=""
				onchange="validate()" required> <input type="hidden"
				name="page" value="editProfilePassword" /> <span class="validate"
				style="display: none; color: red;">ele</span> <input type="submit"
				value="Submit">
		</form>
	</div>
</body>
<script>
	function validate() {
		if (document.getElementById("new_password").value !== document
				.getElementById("confirm_password").value) {
			var element = document.getElementById("validate");
			element.innerHTML = "Please make sure passwords match";
			element.style.display = "block";
		} else {
			element.innerHTML = "";
			element.style.display = "none";
		}
	}
</script>
</html>
