<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
	<div class="row">
		<div class=".col-sm-6">
			<div class="thumbnail">
				<a href="/SombraStore/${good.id}"><img src="resources/img/${good.id}.jpg" class="previewimage"></a>
				<div class="caption">
					<a href="/SombraStore/${good.id}"><b>${good.goodName}</b></a>
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