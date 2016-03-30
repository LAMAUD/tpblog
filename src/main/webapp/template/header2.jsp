<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@
        taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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


<body class="bg-default">
	<div class="row-fluid" style="min-height: 220px; overflow: hidden;">
		<header class="header navbar shadow" style="min-height: 30px">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div class="brand">
					<!-- toggle offscreen menu -->
					<a class="ti-menu navbar-toggle off-left visible-xs"
						data-toggle="collapse" data-target="#menu-collapse"></a>
					<!-- /toggle offscreen menu -->

					<!-- logo -->
					<a href="<c:url  value="/article/list.do" />" class="navbar-brand">
						<img height="200" src="${urlResources}/img/moi.jpg" alt="">
					</a>
					<!-- /logo -->
				</div>

				<div class="collapse navbar-collapse pull-left" id="menu-collapse">
					<ul class="nav navbar-nav">
						<li><a href="<c:url  value="/auteur/list.do" />"><spring:message
									code="list.auteur" text="default text" /></a></li>
						<li><a href="<c:url  value="/article/list.do" />"><spring:message
									code="list.article" text="default text" /></a></li>
						<sec:authorize ifAllGranted="ROLE_ADMIN">
							<li><a href="<c:url  value="/article/save.do" />"><spring:message
										code="create.article" text="default text" /></a></li>
						</sec:authorize>
					</ul>
					<form class="navbar-form navbar-right inline-form">
						<div class="form-group">
							<input type="search" class="input-sm form-control"
								placeholder="Recherche">
							<button type="submit" class="btn btn-primary btn-sm">
								<span class="glyphicon glyphicon-eye-open"></span> Chercher
							</button>
						</div>
					</form>
				</div>

				<ul class="nav navbar-nav navbar-right">

					<li class="off-right"><a href="#" data-toggle="dropdown">
							<span class="ml10">${principal.username}</span> <i
							class="ti-angle-down ti-caret"></i>
					</a>
						<ul class="dropdown-menu animated fadeInRight">
							<c:url var="urlArticleUpdate"
								value="/article/update.do?id=${userSessionId}" />
							<li><a href="${urlArticleUpdate}"><spring:message
										code="my.account" text="Update Article" /></a></li>
							<li><a href="<c:url value="/logout" />">Déconnexion</a></li>
						</ul></li>
				</ul>
			</div>
		</header>
	</div>

	Language :
	<a href="?lang=en">English</a>|
	<a href="?lang=fr">Francais</a>