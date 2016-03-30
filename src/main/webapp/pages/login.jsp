<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url var="urlResources" value="/resources" />
<!-- core styles -->

<script src="${urlResources}/plugins/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="${urlResources}/bootstrap/css/bootstrap.min.css">
<script src="${urlResources}/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="${urlResources}/css/animate.min.css">
<sec:authentication var="principal" property="principal" />
<c:url var="urlGetPrincipalId" value="/auteur/principal/id" />

<title>Lister Auteurs</title>
</head>

<body>
	<div class="jumbotron">
		<div class="container">
			<form action="j_spring_security_check" method="POST">
				<div class="row">
					<div class="col-lg-8 col-md-8 col-xs-8">
						<h1 id="banner">Bienvenue sur mon Blog</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4 col-md-4 col-xs-4">

						<div>
							<label>Pseudo</label> <input type="text" placeholder="pseudo"
								class="form-control" name="j_username">
						</div>
						<br>
						<div>
							<label>Mot de passe</label> <input type="password"
								id="inputPassword" placeholder="Password" name="j_password"
								class="form-control">
						</div>

					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-8 col-md-8 col-xs-8">
						<button type="submit" class="btn btn-info">Connexion</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>