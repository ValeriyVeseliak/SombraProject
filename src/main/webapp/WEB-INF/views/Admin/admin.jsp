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
		<li role="presentation" class="active"><a
			href="/SombraStore/admin">Goods</a></li>
		<li role="presentation"><a href="/SombraStore/admin/cathegories">Categories</a></li>
		<li role="presentation"><a href="/SombraStore/admin/users">Users</a></li>
		<li role="presentation"><a href="/SombraStore/admin/orders">Orders</a></li>

	</ul>
</div>


<table class="table table-bordered">
	<tr>
		<th style="width: 40px">Id</th>
		<th>Good name</th>
		<th>Price</th>
		<th>Description</th>
		<th>Category</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${goods}" var="good">

		<tr>
			<td>${good.id}</td>
			<td style="width: 200px">${good.goodName}</td>

			<td>${good.price}</td>

			<td>${good.description}</td>

			<td style="width: 200px">${good.cathegory.cathName}</td>

			<td style="width: 100px">
			
			
			<button type="button"
					class="btn btn-primary btn-sm" data-toggle="modal"
					data-target="#${good.id}">Update</button> 
					<!-- Modal -->
				
				<div class="modal fade" id="${good.id}" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Update good</h4>
							</div>
							<div class="modal-body">



								<form action="/SombraStore/admin/goods/${good.id}/update">
									<div class="form-group">
										<label for="goodName"> Name of good</label> <input type="text"
											name="goodName" value="${good.goodName}">
									</div>
									<div class="form-group">
										<label for="decription"> Description</label> <input
											type="text" name="description" value="${good.description}">
									</div>
									<div class="form-group">
										<label for="price">Price</label> <input type="number" min="0"
											name="price" value="${good.price}">
									</div>
									<div class="form-group">
										<label for="cathName">Category</label> <select name="cathName">
											<c:forEach items="${cathegories}" var="cathegory">
												<c:if test="${good.cathegory.cathName==cathegory.cathName}">
													<option value="${cathegory.cathName}" selected="selected">${cathegory.cathName}</option>
												</c:if>
												<c:if test="${good.cathegory.cathName!=cathegory.cathName}">
													<option value="${cathegory.cathName}">${cathegory.cathName}</option>
												</c:if>
											</c:forEach>
										</select>
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

			<td style="width: 200px"><a
				href="/SombraStore/admin/goods/${good.id}/delete"><input
					type="button" class="btn btn-primary btn-sm" value="Delete"></a></td>
		</tr>
	</c:forEach>

</table>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal2">Create Lot</button>

<!-- Modal -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Create lot</h4>
			</div>
			<div class="modal-body">
				<form action="/SombraStore/admin/goods/create">
					<div class="form-group">
						<label for="goodName"> Name of good</label> <input type="text"
							name="goodName">
					</div>
					<div class="form-group">
						<label for="decription"> Description</label>
						<textarea name="description"></textarea>
					</div>
					<div class="form-group">
						<label for="price">Price</label> <input type="number" name="price" min="0">
					</div>
					<div class="form-group">
						<label for="cathName">Category</label> <select name="cathegories">
							<c:forEach items="${cathegories}" var="cathegory">
								<option value="${cathegory.cathName}">${cathegory.cathName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</form>
			</div>

		</div>
	</div>
</div>