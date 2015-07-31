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
		<li role="presentation"><a href="/SombraStore/admin/">Goods</a></li>
		<li role="presentation"><a href="/SombraStore/admin/cathegories">Categories</a></li>
		<li role="presentation" class="active"><a href="/SombraStore/admin/users"
			>Users</a></li>
		<li role="presentation"><a href="/SombraStore/admin/orders">Orders</a></li>

	</ul>
</div>

<table class="table table-bordered">
	<tr>
		<th style="width: 40px">Id</th>
		<th>First Last name</th>
		<th>Email</th>
		<th>Login</th>
		<th>Password</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.firstName} ${user.lastName}</td>
			<td>${user.email}</td>
			<td>${user.login}</td>
			<td>${user.password}</td>
			<td>
				<button type="button" class="btn btn-primary btn-sm"
					data-toggle="modal" data-target="#${user.id}">Update</button> 
					<!-- Modal -->
				<div class="modal fade" id="${user.id}" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Update user</h4>
							</div>
							<div class="modal-body">



								<form action="/SombraStore/admin/users/${user.id}/update">
									<div class="form-group">
										<label for="firstName">Name</label> <input type="text"
											name="firstName" value="${user.firstName}">
									</div>
									<div class="form-group">
										<label for="lastName">Name</label> <input type="text"
											name="lastName" value="${user.lastName}">
									</div>
									<div class="form-group">
										<label for="email">Email</label> <input type="text"
											name="email" value="${user.email}">
									</div>
									<div class="form-group">
										<label for="login">Login</label> <input type="text"
											name="login" value="${user.login}">
									</div>
									<div class="form-group">
										<label for="password">Password</label> <input type="text"
											value="${user.password}" name="password">
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
										<button type="submit" class="btn btn-primary">Save
											changes</button>
									</div>
								</form>


							</div>

						</div>
					</div>
				</div>
			</td>
			<td><a href="/SombraStore/admin/users/${user.id}/delete"><input
					type="button" value="Delete" class="btn btn-primary btn-sm"></a></td>
		</tr>

	</c:forEach>
</table>