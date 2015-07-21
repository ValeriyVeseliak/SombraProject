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
		<li role="presentation"><a href="/SombraStore/admin/cathegories" class="active">Cathegories</a></li>
		<li role="presentation"><a href="/SombraStore/admin/users">Users</a></li>
		<li role="presentation"><a href="/SombraStore/admin/orders" >Orders</a></li>
		
	</ul>
</div>



<table class="table table-bordered">
	<tr>
		<th style="width: 40px">Id</th>
		<th>Cathegory</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${cathegories}" var="cathegory">

		<tr>
			<td>${cathegory.id}</td>
			<td style="width: 200px">${cathegory.cathName}</td>
			<td><a href="/SombraStore/admin/cathegories/${cathegory.id}/delete"><input type="button" value="Delete" class="btn btn-primary btn-sm"></a></td>
		</tr>
		
	</c:forEach>
</table>


<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal2">Create Cathegory</button>

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
				<h4 class="modal-title" id="myModalLabel">Create Cathegory</h4>
			</div>
			<div class="modal-body">
				<form action="/SombraStore/admin/cathegories/create">
					<div class="form-group">
						<label for="cathName"> Name of cathegory</label> <input type="text"
							name="cathName">
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