<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>



<%-- <form action="/SombraStore/search/">
<input type="text" name = "keyword" >
<select name="cathName">
	<option value="ALL">All cathegories</option>
	<c:forEach items="${cathegories}" var="cathegory">
		<option value="${cathegory.cathName}">${cathegory.cathName}</option>
	</c:forEach>
</select>
<input type="submit" value="Search" ></a>
</form> --%>

<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="/SombraStore/admin/">Admin</a>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER')">
<c:forEach items="${cathegories}" var = "cathegory">
	<a href="/SombraStore/goods/${cathegory.cathName}/">${cathegory.cathName}</a>
</c:forEach>
</sec:authorize>

<c:forEach items="${goods}" var="good">
	<div class="row">
		<div class=".col-sm-6">
			<div class="thumbnail">
				<a href="/SombraStore/good/${good.id}"><img src="resources/img/${good.id}.jpg" class="previewimage"></a>
				<div class="caption">
					<a href="/SombraStore/good/${good.id}"><b>${good.goodName}</b></a>
					<p>Price: ${good.price}</p>
					<p>Details: ${good.description}</p>
					<sec:authorize access="isAuthenticated()">
						<a href="/SombraStore/toBasket/${good.id}" class="btn btn-primary"
							role="button">Add to Basket</a>
					</sec:authorize>
				</div>
			</div>
		</div>
	</div>
</c:forEach>


<sec:authorize access="isAuthenticated()">
			<a href="<c:url value="/j_spring_security_logout"/>"> Log Out
			</a>
		</sec:authorize>

<%-- <select>
	<option value="5">9</option>
	<option value="10">10</option>
	<option value="25">25</option>
</select>

<label for=price>Price</label>
<input type=range min=0 max="${maxPrice}" value="${maxPrice}" id=price
	oninput="outputUpdate(value)" step=10>
<output for=price id=newPrice>${maxPrice}</output>
 --%>

<script>
	function outputUpdate(vol) {
		document.querySelector('#newPrice').value = vol;
	}
</script>
<script type="text/javascript"
	src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
