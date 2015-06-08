<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib
	uri="http://www.springframework.org/spring-social/social/tags"
	prefix="social"%>

<social:connected provider="facebook">
	<ul class="menu">
		<li><a href="<c:url value="/facebook"/>">User Profile</a></li>
		<li><a href="<c:url value="/facebook/feed"/>">Feed</a></li>
		<li><a href="<c:url value="/facebook/friends"/>">Friends</a></li>
		<li><a href="<c:url value="/facebook/albums"/>">Albums</a></li>
	</ul>
</social:connected>