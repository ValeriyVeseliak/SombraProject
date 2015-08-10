<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE HTML>
<html>
<head>
	<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
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

	<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
	<jsp:useBean id="pagedListHolder" scope="request"
		type="org.springframework.beans.support.PagedListHolder" />
	<%-- // create link for pages, "~" will be replaced 
   later on with the proper page number --%>
	<c:url value="/" var="pagedLink">
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

	<div style="width: 200px; margin: 0 auto; align: center;">
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />
	</div>


</body>
</html>
