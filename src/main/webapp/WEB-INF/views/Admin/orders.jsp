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


<h1 style="text-align:center">Admin profile</h1>

<div>
	<ul class="nav nav-tabs">
		<li role="presentation" > <a
			href="/SombraStore/admin/">Goods</a></li>
		<li role="presentation"><a href="/SombraStore/admin/cathegories">Categories</a></li>
		<li role="presentation"><a href="/SombraStore/admin/users">Users</a></li>
		<li role="presentation" class="active"><a href="/SombraStore/admin/orders" >Orders</a></li>
		
	</ul>
</div>


<table class="table table-bordered">
	<tr>
		<th style="width: 40px">Id</th>
		<th>User</th>
		<th>Goods</th>
		<th>Date</th>
		<th>Price</th>
	</tr>
	<c:forEach items="${orders}" var="order">
		<tr>
			<td>${order.id}</td>
			<td style="width: 200px">${order.user.firstName} ${order.user.lastName}  </br> <b>Phone:</b>   ${order.user.phoneNumber}</td>

			<td>
				<c:forEach items="${order.goods}" var="good">
					<p><a href="/SombraStore/good/${good.id}">${good.goodName}</a></p>
				</c:forEach>
			</td>
			<td><fmt:formatDate pattern="HH:mm   dd-MM-yyyy"
					value="${order.date}" /></td>
			<td>${order.priceOfOrder}</td>
		</tr>
	</c:forEach>
</table>