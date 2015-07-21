<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
<a href="/SombraStore/">Main</a>	
	
<sec:authorize access="hasRole('ROLE_USER')">	
<a href="/SombraStore/basket">Basket</a>	
</sec:authorize>
	
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="/SombraStore/admin">Admin profile</a>
</sec:authorize>

<sec:authorize access="isAnonymous()">
<a href="/SombraStore/login">Login</a>
<a href="/SombraStore/signup">Sign up</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<a href="/SombraStore/j_spring_security_logout">Log out</a>
</sec:authorize>

