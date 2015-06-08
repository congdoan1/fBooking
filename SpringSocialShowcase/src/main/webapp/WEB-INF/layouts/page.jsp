<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
	<head>
<!-- 		<title>TGA Login by Facebook</title> -->
<%-- 		<link rel="stylesheet" href="<c:url value="/resources/page.css" />" type="text/css" media="screen" /> --%>
<%-- 		<link rel="stylesheet" href="<c:url value="/resources/form.css" />" type="text/css" media="screen" /> --%>
	<meta charset="UTF-8">
    <title>Login Form</title>
    <script src="<c:url value="/resources/jquery/prefixfree.min.js" />"></script>
    <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
    <link rel="stylesheet" href="<c:url value="/resources/form.css" />" type="text/css" media="screen" />
    <link rel="stylesheet" href="<c:url value="/resources/style.css" />" type="text/css" media="screen" />
	<link rel="stylesheet" href="<c:url value="/resources/messages/messages.css" />" type="text/css" media="screen" />
	</head>
	<body>
<!-- 		<div id="header"> -->
<%-- 			<h1><a href="<c:url value="/"/>">TGA Login by Facebook</a></h1> --%>
<!-- 		</div> -->
		<div class="body"></div>
	    <div class="header">
	        <div>f<span>Booking</span>
	        </div>
	    </div>
	    <br>	
		<div class="box">
			<tiles:insertAttribute name="content" />
		</div>
	</body>
</html>
