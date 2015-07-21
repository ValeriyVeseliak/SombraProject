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
		<li role="presentation"><a href="/SombraStore/admin/users" class="active">Users</a></li>
		<li role="presentation"><a href="/SombraStore/admin/orders" >Orders</a></li>
		
	</ul>
</div>

<table class="table table-bordered">
	<tr>
		<th style="width: 40px">Id</th>
		<th>First Last name</th>
		<th>Email</th>
		<th>Login</th>
		<th>Password</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.firstName} ${user.lastName}</td>
			<td>${user.email}</td>
			<td>${user.login}</td>
			<td>${user.password}</td>
			<td><a href="/SombraStore/admin/users/${user.id}/delete"><input type="button" value="Delete" class="btn btn-primary btn-sm"></a></td>
		</tr>
		
	</c:forEach>
</table>