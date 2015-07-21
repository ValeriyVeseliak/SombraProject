<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">


<div>
	<ul class="nav nav-tabs">
		<li role="presentation" > <a
			href="/SombraStore/admin/">Goods</a></li>
		<li role="presentation"><a href="/SombraStore/admin/cathegories">Cathegories</a></li>
		<li role="presentation"><a href="/SombraStore/admin/users">Users</a></li>
		<li role="presentation"><a href="/SombraStore/admin/orders" class="active">Orders</a></li>
		
	</ul>
</div>


<table class="table table-bordered">
	<tr>
		<th style="width: 40px">Id</th>
		<th>User</th>
		<th>Goods</th>
		<th>Date</th>
	</tr>
	<c:forEach items="${orders}" var="order">

		<tr>
			<td>${order.id}</td>
			<td style="width: 200px">${order.user.firstName} ${order.user.lastName}</td>

			<td>
				<c:forEach items="${order.goods}" var="good">
					<p>${good.goodName}</p>
				</c:forEach>
			</td>

			<td>${order.date}</td>
			
		</tr>
	</c:forEach>
</table>