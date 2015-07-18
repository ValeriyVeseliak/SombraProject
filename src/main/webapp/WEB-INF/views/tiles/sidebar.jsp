<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<%-- <tiles:importAttribute  name="cathegories"/>
<c:forEach var="cathegory" items="${cathegories}">
  ${cathegory.cathName}
</c:forEach> --%>


<%-- <tiles:insertAttribute name="cathegories">
	<c:forEach var="cathegory" items="${cathegories}">
 	 <h1>${cathegory.cathName}</h1>
</c:forEach>
</tiles:insertAttribute>  --%>
query.

<script>
var query = new EntityQuery({
	  from: "Cathegory"});
</script>