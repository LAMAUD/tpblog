<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="/template/header.jsp">
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
							<th>Name</th>
							<th>Actions</th>
						</tr>
						<c:forEach items="${categorie}" var="categorie">
							<c:url var="urlCategorieDelete"
								value="/categorie/delete.do?id=${categorie.id}" />
							<c:url var="urlCategorieUpdate"
								value="/categorie/update.do?id=${categorie.id}" />
							<tr>

								<!-- 								Lien pour la modif -->
								<td class="text-primary"><sec:authorize
										ifAllGranted="ROLE_ADMIN">
										<a href="${urlCategorieUpdate}">${categorie.id }</a>
									</sec:authorize></td>
								<td>${categorie.name }</td>
								<sec:authorize ifAllGranted="ROLE_ADMIN">
									<td><a href="${urlCategorieDelete}">delete</a></td>
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