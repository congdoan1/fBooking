<%@page import="com.tga.fbooking.api.APIWrapper"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>TGA fBooking</title>
	<script src="./resources/jquery/prefixfree.min.js"></script>
	<script src="./resources/jquery/jquery.js"></script>
	<link rel="stylesheet" type="text/css" href="./resources/css/style.css" />
</head>
<body>
	<div class="body"></div>
	<div class="header">
		<div>
			f<span>Booking</span>
		</div>
	</div>
	<br>
	
	<div class="box1">
		<form action="login" method="post" lang="en">
			<input type="text" placeholder="username" name="username" pattern=".{6,}" required title="6 characters minimum"><br>
			<input type="password" placeholder="password" name="password" required><br>
			<div>
				<input id="login" type="submit" value="Login">
			</div>
		</form>
		<div>
			<hr>
		</div>
		<div>
			<a href="<%= APIWrapper.getDialogLink() %>" style="text-decoration: none; outline: 0;">
				<input id="facebook" type="submit" value="Sign in with Facebook">
			</a>
		</div>
	</div>
</body>
</html>
