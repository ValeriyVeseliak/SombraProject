<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<div class="menu-list">

	<sec:authorize access="isAnonymous()">
		<div class="menu">
			<a href="/SombraStore/login">Login</a>
		</div>
		<div class="menu">
			<a href="/SombraStore/signup">Sign up</a>
		</div>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<div class="menu">
			<a href="/SombraStore/j_spring_security_logout">Log out</a>
		</div>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_USER')">
		<div class="menu">
			<a href="/SombraStore/basket">Basket</a>
		</div>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div class="menu">
			<a href="/SombraStore/admin">Admin profile</a>
		</div>
	</sec:authorize>

	<div class="menu">
		<a href="/SombraStore/">Main</a>
	</div>

</div>