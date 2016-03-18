<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="/template/Header3.jsp">
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
							<th>Texte</th>
							<th>Email Commentateur</th>
							<th>Date</th>
							<th>Actions</th>
						</tr>
						<c:forEach items="${commentaire}" var="commentaire">
							<c:url var="urlCommentaireDelete"
								value="/commentaire/delete.do?id=${commentaire.id}" />
							<c:url var="urlCommentaireUpdate"
								value="/commentaire/update.do?id=${commentaire.id}" />
							<tr>

								<!-- 								Lien pour la modif -->
								<td class="text-primary"><sec:authorize
										ifAllGranted="ROLE_ADMIN">
										<a href="${urlCommentaireUpdate}">${commentaire.id }</a>
									</sec:authorize></td>
								<td>${commentaire.texte}</td>
								<td>${commentaire.email}</td>
								<td>${commentaire.creationDate}</td>
								<sec:authorize ifAllGranted="ROLE_ADMIN">
									<td><a href="${urlCommentaireDelete}">delete</a></td>
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