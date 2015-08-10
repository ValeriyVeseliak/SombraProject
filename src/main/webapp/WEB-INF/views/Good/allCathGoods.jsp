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

	<h1>${cathegory.cathName}</h1>

	<%-- <c:forEach items="${goods}" var="good">
		<div class="row">
			<div class=".col-sm-5">
				<div class="thumbnail">
					<div class="img">
						<a href="/SombraStore/good/${good.id}"><img
							src="http://localhost:8080/SombraStore/resources/img/${good.id}.jpg"
							class="previewimage"></a>
					</div>
					<div class="caption">
						<a href="/SombraStore/good/${good.id}"><b>${good.goodName}</b></a>
						<p>Price: ${good.price}</p>
						<p>Details: ${good.description}</p>
					</div>
				</div>
			</div>
		</div>
	</c:forEach> --%>

	
	<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
	<jsp:useBean id="pagedListHolder" scope="request"
		type="org.springframework.beans.support.PagedListHolder" />
	<%-- // create link for pages, "~" will be replaced 
   later on with the proper page number --%>
	<c:url value="/goods/${cathegory.cathName}/" var="pagedLink">
		<c:param name="page" value="~" />
	</c:url>
	<%-- // show only current page worth of data --%>
	<c:forEach items="${pagedListHolder.pageList}" var="good">
		<div class="row">
			<div class=".col-sm-5">
				<div class="thumbnail">
					<div class="img">
						<a href="/SombraStore/good/${good.id}"> <img
							src="resources/img/${good.id}.jpg" class="previewimage"></a>
					</div>
					<div class="caption">
						<a href="/SombraStore/good/${good.id}"><b>${good.goodName}</b></a>
						<p>Price: ${good.price}</p>
						<p>Details: ${good.description}</p>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<div style="width: 100px; margin: 0 auto; align: center;">
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />
	</div>
	
	
	
	
	<%-- <c:if test="${maxPage != 1}">
	<div class="text-center">
		<ul class="pagination ">
			<li><a href="/SombraStore/goods/${cathegory.cathName}/1">&laquo;&laquo;</a></li>
			<c:if test="${page!=1}">
				<li><a href="/SombraStore/goods/${cathegory.cathName}/${page-1}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
				</a></li>
				<li><a href="/SombraStore/goods/${cathegory.cathName}/${page-1}">${page-1}</a></li>
			</c:if>
			<li><a href="/SombraStore/goods/${cathegory.cathName}/${page}"
				style="text-decoration: underline; background-color: rgba(0, 0, 0, 0.2);">${page}</a></li>
			<c:if test="${page != maxPage}">
				<li><a href="/SombraStore/goods/${cathegory.cathName}/${page+1}">${page+1}</a></li>
				<li><a href="/SombraStore/goods/${cathegory.cathName}/${page+1}" aria-label="Next"> <span
						aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>
			<li><a href="/SombraStore/goods/${cathegory.cathName}/${maxPage}">&raquo;&raquo;</a></li>
		</ul>
	</div>
	</c:if> --%>
	
	
	
</body>
</html>