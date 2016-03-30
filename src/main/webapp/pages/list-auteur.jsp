<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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

<jsp:include page="/template/header.jsp">
	<jsp:param value="active" name="menuAdministrateurActive" />
	<jsp:param value="Solices - Détails Administrateur" name="titreOnglet" />
</jsp:include>

<div class="container">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-xs-12" style="padding-top: 15px;">
			<h1 class="text-center">Liste des auteurs ayant publié sur ce site</h1>
		</div>
	</div>

	<div class="row" style="padding-top: 15px;">
		<div class="col-lg-2 col-md-2 col-xs-2">
			<img height="150" src="${urlResources}/img/auteur.jpg" alt="">
		</div>
		<div class="col-lg-10 col-md-10 col-xs-10 table-responsive">
			<div class="app bg-default horizontal-layout">

				<table
					class="table table-bordered table-striped table-condensed list no-m">
					<tbody>
						<tr>
							<th>Id</th>
							<th><spring:message code="label.name" text="default text" /></th>
							<th><spring:message code="label.firstname"
									text="default text" /></th>
							<th>Email</th>
							<th>Role</th>
							<th>List-Article</th>
							<th>Actions</th>
						</tr>
						<c:forEach items="${auteurs}" var="auteur">
							<c:url var="urlAuteurDelete"
								value="/auteur/delete.do?id=${auteur.id}" />
							<c:url var="urlAuteurUpdate"
								value="/auteur/update.do?id=${auteur.id}" />
							<c:url var="urlArticleList"
								value="/article/articleList.do?id=${auteur.id}" />
							<c:url var="urlAuteurArticleId"
								value="/article/save.do?id=${auteur.id}" />
							<tr>

								<!-- 								Lien pour la modif -->
								<td class="text-primary"><sec:authorize
										ifAllGranted="ROLE_ADMIN">
										<a href="${urlAuteurUpdate}">${auteur.id }</a>
									</sec:authorize></td>
								<td>${auteur.nom }</td>
								<td>${auteur.prenom }</td>
								<td>${auteur.email}</td>
								<td>${auteur.role.name}</td>
								<td><a href="${urlArticleList}">list-Articles</a></td>

								<sec:authorize ifAllGranted="ROLE_ADMIN">
									<td><a href="${urlAuteurDelete}">delete</a></td>
								</sec:authorize>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>