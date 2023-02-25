<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css" >
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

		<li><a href="controller?action=viewMovies"
			style="text-decoration: none">View Movies</a></li>
		<li><a href="controller?action=adminDashboard"
			style="text-decoration: none">Dashboard</a></li>
		<li><a href="controller?action=userProfile"
			style="text-decoration: none">Profile</a></li>
		<li><a href="logout" style="text-decoration: none">Logout</a></li>
	</ul>
	
	<!-- Add your registration form below -->
    <div class="registration-form">
      <h2>Add Movie</h2>
      <form action="editMovie" method="post">
        <label for="name">Movie Name</label>
			<input type="text" id="name" name="name" class="form-control" value="${movie.getName()}">
			
			<label for="genre">Genre</label>
			<input type="text" id="genre" name="genre" class="form-control" value="${movie.getGenre()}">
			
			<label for="cost">Cost</label>
			<input type="text" id="cost" name="cost" class="form-control" value="${movie.getCost()}">
			
			<label for="release_date">Release Date</label>
			<input type="text" id="release_date" name="release_date" class="form-control" value="${movie.getRelease_date()}">
			
			<label for="seats_left">Seats Left</label>
			<input type="text" id="seats_left" name="seats_left" class="form-control" value="${movie.getSeats_left()}">
			
        <input type="submit" style="width:100%;" value="Submit">
      </form>
    </div>

</body>
</html>
