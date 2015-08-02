<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="text-align: center">Hello</h1>
<div class="signup-form">
<p style="color: red">${error}</p>

<form action="/SombraStore/signup/create" method="POST" name="addUser">
	<div class="form-group" id="fform">
		<label for="firstName">First Name </label> <input type="text"
			class="form-control" placeholder="First name" name="firstName"
			required>
	</div>
	<div class="form-group" id="lform">
		<label for="lastName">Last Name</label> <input type="text"
			class="form-control" placeholder="Last name" name="lastName" required>
	</div>
	<div class="form-group" id="eform">
		<label for="email">Email</label> <input type="text"
			class="form-control" placeholder="Email" name="email" required>
	</div>
	<div class="form-group" id="eform">
		<label for="phoneNumber">Phone number</label> <input type="text"
			class="form-control" placeholder="Email" name="phoneNumber" required>
	</div>
	<div class="form-group" id="lform">
		<label for="login">Login</label> <input type="text"
			class="form-control" placeholder="Login" name="login" required>
	</div>

	<div class="form-group" id="pform">
		<label for="password">Password</label> <input type="text"
			class="form-control" placeholder="Password" name="password" required>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-primary">Save</button>

		<p style="color: red">
			<c:if
				test="${param.error=='A user with the following data already exists'}">
					A user with the following data already exists
			</c:if>

		</p>

	</div>


</form>
</div>
