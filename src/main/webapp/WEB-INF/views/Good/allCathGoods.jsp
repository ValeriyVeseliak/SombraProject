<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


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


<script type="text/javascript"
	src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
