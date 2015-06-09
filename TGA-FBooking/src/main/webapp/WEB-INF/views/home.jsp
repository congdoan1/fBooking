<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
    <title>TGA fBooking</title>
	<link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/stylehome.css" />" />
    <script src="<c:url value="/resources/jquery/modernizr.custom.63321.js" />"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
</head>
<body>
	<div class="container">
        <!-- Codrops top bar -->
        <div class="codrops-top clearfix">
            <a href="#">
                <strong>Home</strong>
            </a>
            <a href="bookingnew.html">
                <strong>New Booking</strong>
            </a>
            <a href="booking.html">
                <strong>Calendar</strong>
            </a>
            <a href="#">
                <strong>Booking History</strong>
            </a>
            <span class="right">
					<a href="#"><strong>Welcome ${sessionScope.user}</strong></a>
					<a href="<c:url value="/logout"/>"><strong>Logout</strong></a>
				</span>
        </div>
       </div>
</body>
</html>