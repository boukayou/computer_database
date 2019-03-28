<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="/cdb/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="/cdb/css/font-awesome.css" rel="stylesheet" media="screen">
<link href="/cdb/css/main.css" rel="stylesheet" media="screen">
</head>

<body>

	<header class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<a class="navbar-brand" href="dashboard.html"> Application -
				Computer Database </a>
		</div>
	</header>

	<section id="main">
		<div class="container">
			<div class="row">
				<div class="col-xs-8 col-xs-offset-2 box">
					<h1>Login Computer DataBase</h1>
					<form action="Login" method="POST">
						<fieldset>
							<div class="form-group">
								<label for="Login">Login</label> <input type="text"
									pattern=".{4,30}" id="username" name="username"
									placeholder="4 caractères minimum." size=30 required>
							</div>
							<div class="form-group">
								<label for="Password">Password</label> <input type="password"
									pattern=".{8,40}" id="password" name="password"
									placeholder="8 caractères minimum." size=30 required>
							</div>
						</fieldset>
						<div class="actions pull-right">
							<input type="submit" value="Login" class="btn btn-primary">
							or <a href="dashboard.html" class="btn btn-default">Cancel</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<footer>
		<script src="/cdb/js/jquery.min.js"></script>
		<script src="/cdb/js/frontValidator.js"></script>
	</footer>
</body>
</html>