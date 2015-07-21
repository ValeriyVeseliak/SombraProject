<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<c:forEach items="${goods}" var="good">
	<div class="row">
		<div class=".col-sm-6">
			<div class="thumbnail">
				<img src="resources/img/${good.id}.jpg" class="previewimage">
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

	<c:if test="${countOfGoods!=true}">
	<a href="/SombraStore/basket/makeOrder" class="btn btn-primary"
		role="button">Make an Order</a>
	</c:if>
	
	
	<p>Price of all goods is ${sumPrice}</p>