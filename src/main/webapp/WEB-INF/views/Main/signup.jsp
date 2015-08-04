<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="text-align: center">Hello</h1>
<div class="signup-form">
	<p style="color: red">${error}</p>

	<form action="/SombraStore/signup/create" method="POST" name="addUser"
		id="sign_up">
		<div class="form-group" id="fform">
			<label for="firstName">First Name</label> <input type="text"
				class="form-control" placeholder="First name" name="firstName"
				pattern=".{3,}" title="3 characters minimum" required>
		</div>
		<div class="form-group" id="lform">
			<label for="lastName">Last Name</label> <input type="text"
				class="form-control" placeholder="Last name" name="lastName"
				pattern=".{3,}" title="3 characters minimum" required>
		</div>
		<div class="form-group" id="eform">
			<label for="email">Email</label> <input type="email"
				class="form-control" placeholder="Email" name="email"
				title="Input valid email" required>
		</div>
		<div class="form-group" id="eform">
			<label for="phoneNumber">Phone number</label> <input type="tel"
				class="form-control" placeholder="+__(___)__-__-___"
				name="phoneNumber"
				pattern="[\+]\d{2}[\(]?\d{3}[\)]?\d{2}[\-]?\d{2}[\-]?\d{3}"
				title="Input valid phone" required>
		</div>
		<div class="form-group" id="lform">
			<label for="login">Login</label> <input type="text"
				class="form-control" placeholder="Login" name="login"
				pattern=".{3,}" title="3 characters minimum" required>
		</div>

		<div class="form-group" id="pform">
			<label for="password">Password</label> <input type="text"
				class="form-control" placeholder="Password" name="password"
				title="8 characters minimum" pattern=".{8,}" required>
		</div>

		<div class="modal-footer">
			<p style="color: red; text-align: center">
				<c:if
					test="${param.error=='A user with the following data already exists'}">
					A user with the following data already exists
			</c:if>
			</p>
			<button type="submit" class="btn btn-primary">Save</button>
		</div>
	</form>
</div>