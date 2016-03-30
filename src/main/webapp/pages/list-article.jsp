<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="/template/header2.jsp">
	<jsp:param value="active" name="menuAdministrateurActive" />
	<jsp:param value="Solices - Détails Administrateur" name="titreOnglet" />
</jsp:include>

<div class="container">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="app bg-default horizontal-layout">

				<table class="table table-striped list no-m">
					<tbody>
						<tr>
							<th>Id</th>
							<th>Titre</th>
							<th>Chapeau</th>
							<th>Contenu</th>
							<th>Date de création</th>
							<th>Auteur</th>
							<th>Categorie</th>
							<th>Commentaires</th>
							<th>Actions</th>
						</tr>
						<c:forEach items="${article}" var="article">
							<c:url var="urlArticleDelete"
								value="/article/delete.do?id=${article.id}" />
							<c:url var="urlArticleUpdate"
								value="/article/update.do?id=${article.id}" />
							<c:url var="urlCommentaireList"
								value="/commentaire/ListCommentaire.do?id=${article.id}" />
							<c:url var="urlDetailArticle"
								value="/article/DetailArticle.do?id=${article.id}" />
							<tr>

								<!-- 								Lien pour la modif -->
								<td class="text-primary"><sec:authorize
										ifAllGranted="ROLE_ADMIN">
										<a href="${urlArticleUpdate}">${article.id }</a>
									</sec:authorize></td>
								<td><a href="${urlDetailArticle}">${article.titre}</a></td>
								<td>${article.chapeau }</td>
								<td>${article.contenu}</td>
								<td>${article.creationDate}</td>
								<td>${article.auteur.nom}</td>
								<td>${article.categorie.name}</td>
								<td><a href="${urlCommentaireList}">commentaires</a></td>
								<sec:authorize ifAllGranted="ROLE_ADMIN">
									<td><a href="${urlArticleDelete}">delete</a></td>
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