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

	<c:forEach items="${goods}" var="good">
		<div class="row">
			<div class=".col-sm-5">
				<div class="thumbnail">
					<div class="img">
						<a href="/SombraStore/good/${good.id}">
						<img src="resources/img/${good.id}.jpg" class="previewimage"></a>
					</div>
					<div class="caption">
						<a href="/SombraStore/good/${good.id}"><b>${good.goodName}</b></a>
						<p>Price: ${good.price}</p>
						<p>Details: ${good.description}</p>						
						<%-- <sec:authorize access="hasRole('ROLE_USER')">
							<a href="/SombraStore/toBasket/${good.id}"
								class="btn btn-primary" role="button">Add to Basket</a>
						</sec:authorize> --%>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<%-- <select>
	<option value="5">9</option>
	<option value="10">10</option>
	<option value="25">25</option>
</select>
 --%>

	<%-- 
<div class="row">
	<div class="col-md-4">
		<label for=price>Price</label> <input type=range min=0
			max="${maxPrice}" value="${maxPrice}" id=price
			oninput="outputUpdate(value)" step=10>
		<output for=price id=newPrice>${maxPrice}</output>
	</div>
</div>
 --%>
	<script>
		function outputUpdate(vol) {
			document.querySelector('#newPrice').value = vol;
		}
	</script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
</body>
</html>
