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
		<div class="good-wrapper">
			<div class="img">
				<a href="/SombraStore/good/${good.id}"> <img
					src="http://localhost:8080/SombraStore/resources/img/${good.id}.jpg" class="previewimage"></a>
			</div>
			<div class="caption">
				<div class="good-name">
					<a href="/SombraStore/good/${good.id}"><b>${good.goodName}</b></a>
				</div>
				<div class="price">Price: ${good.price}$</div>
			</div>
		</div>
	</c:forEach>

	<div style="width: 100px; margin: 0 auto; align: center;">
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />
	</div>

</body>
</html>