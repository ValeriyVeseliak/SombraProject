<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
<c:forEach items="cathegories" var="cathgory">
	<li><a href="/${cathegory.cathName}">${cathegory.cathName}</a></li>
</c:forEach>