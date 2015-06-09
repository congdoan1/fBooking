<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
    <title>TGA fBooking</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
    <script src="../resources/jquery/prefixfree.min.js"></script>
	<script src="../resources/jquery/jquery.js"></script>
</head>
<body>
	<div class="body"></div>
    <div class="header">
        <div>
        	f<span>Booking</span>
        </div>
    </div>
    <br>
	<div class="box">
		<c:set var="user" value="${sessionScope.user}"/>
		<form action="register" method="post">
			<label class="label">
				Username
				<input type="text" placeholder="username" name="username" pattern=".{6,}" required title="6 characters minimum">
				<input type="hidden" name="facebookId" value="${user.facebookId}">
			</label>
			<label class="label">
				Password
				<input type="password" placeholder="password" name="password" pattern=".{8,}" required title="8 characters minimum">
			</label>
			<label class="label">
				First Name
				<input type="text" name="firstname" value="${user.firstName}">
			</label>
			<label class="label">
				Last Name
				<input type="text" name="lastname" value="${user.lastName}" required>
			</label>
			<label class="label">
				Facebook URL
				<input type="text" name="facebookUrl" value="${user.facebookUrl}" readonly>
			</label>
			<div>
				<input id="register" type="submit" value="Register">
			</div>
		</form>
	</div>
</body>
</html>
