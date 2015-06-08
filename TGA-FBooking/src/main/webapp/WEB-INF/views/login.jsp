<%@page import="com.tga.fbooking.api.APIWrapper"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TGA fBooking</title>
<script src="resources/jquery/prefixfree.min.js"></script>
<script src="resources/jquery/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
</head>
<body>
	<div class="body"></div>
	<div class="header">
		<div>
			<font color="black">f</font><span>Booking</span>
		</div>
	</div>
	<br>

	<div class="box">
		<form action="login" method="post">
			<input type="text" placeholder="username" name="username" pattern=".{6,}" required title="6 characters minimum"><br>
			<input type="password" placeholder="password" name="password" required><br>
			<div>
				<input id="login" type="submit" value="Login">
			</div>
		</form>
		<div>
			<hr></hr>
		</div>
		<div>
			<a href="<%= APIWrapper.getDialogLink() %>" style="text-decoration: none; outline: 0;">
				<input id="facebook" type="submit" value="Connect with Facebook">
			</a>
		</div>
	</div>
</body>
</html>
