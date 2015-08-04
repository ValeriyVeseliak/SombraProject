<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="/wp-content/themes/clear-theme/styles/bootstrap.css"
	rel="stylesheet">

<link
	href="/wp-content/themes/clear-theme/styles/bootstrap-responsive.css"
	rel="stylesheet">
</head>

<body>
	<sec:authorize access="isAnonymous()">
		<div class="container">
			<div class="col-lg-12"align="center">
				<form class="form-horizontal" action="j_spring_security_check"
					method="post" name="email_pass" >
					<h2 class="form-signin-heading">Please sign in</h2>
					<div class="form-group" id="vform">
						<div class="col-sm-2"></div>
						<label for="inputEmail3" class="col-sm-2 control-label">Login</label>
						<div class="col-sm-4">
							<input type="text" name="j_username" class="form-control"
								id="inputEmail3" placeholder="Login" maxlength="35" autofocus="autofocus">
						</div>
						<div class="col-sm-3" id="div_error"></div>
					</div>
					<div class="form-group">
					<div class="col-sm-2"></div>
						<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-4">
							<input type="password" name="j_password" class="form-control"
								id="inputPassword3" placeholder="Password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2"></div>
						<div class="col-sm">
							<div class="checkbox">
								<label> <input type="checkbox"> Remember me
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3"></div>
						<div class="col-sm-6">
							<button type="submit" class="btn btn-default">Sign in</button>
							<p style="color: red">
								<c:if test="${param.error=='invalidLoginPassword'}">
					Invalid login or password. Please try again.
					</c:if>
					<c:if test="${ param.error=='duplicateLogin'}">
					This login is already used. Try get another.
					</c:if>
					</p>
						</div>
					</div>

				</form>
			</div>
		</div>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<a href="<c:url value="/j_spring_security_logout"/>">Log Out</a>
	</sec:authorize>

</body>
</html>