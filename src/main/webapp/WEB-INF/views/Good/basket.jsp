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


	<h1>Basket</h1>
	<c:forEach items="${goods}" var="good">
		<div class="row">
			<div class=".col-sm-6">
				<div class="thumbnail">
					<img src="http://localhost:8080/SombraStore/resources/img/${good.id}.jpg" class="previewimage">
					<div class="caption">
						<h3>${good.goodName}</h3>
						<p>Price: ${good.price}</p>
						<p>Details: ${good.description}</p>
						<a href="/SombraStore/basket/${good.id}/delete">Delete</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<c:if test="${!isEmpty}">
		<p>Price of all goods is ${sumPrice}</p>
		<a href="/SombraStore/basket/makeOrder" class="btn btn-primary"
			role="button">Make an Order</a>
	</c:if>

</body>
</html>

