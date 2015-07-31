<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE HTML>
<html>
<head></head>
<body>


	<div class="search">
		<form action="/SombraStore/search/">
			<input type="text" name="keyword"> <select name="cathName">
				<option value="ALL">All categories</option>
				<c:forEach items="${cathegories}" var="cathegory">
					<option value="${cathegory.cathName}">${cathegory.cathName}</option>
				</c:forEach>
			</select> <input type="submit" value="Search" class="btn btn-default">
		</form>
	</div>

	<div class="categories">
		<c:forEach items="${cathegories}" var="cathegory">
			<div class="catlinks">
				<a href="/SombraStore/goods/${cathegory.cathName}/">${cathegory.cathName}</a>
			</div>
		</c:forEach>
	</div>

	<h2 style="text-align:center">${good.goodName}</h2>
	<div class="row">
		<div class=".col-md-5">
			<div class="thumbnail">
				<img
					src="resources/img/${good.id}.jpg" class="full-size">
				<div class="caption">
					<b>${good.goodName}</b>
					<p>Price: ${good.price}</p>
					<p>Details: ${good.description}</p>
					<sec:authorize access="hasRole('ROLE_USER')">
						<a href="/SombraStore/toBasket/${good.id}" class="btn btn-primary"
							role="button">Add to Basket</a>
					</sec:authorize>
				</div>
			</div>
		</div>
	</div>

</body>
</html>