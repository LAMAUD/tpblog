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

<jsp:include page="/template/header2.jsp">
	<jsp:param value="active" name="menuAdministrateurActive" />
	<jsp:param value="Solices - Détails Administrateur" name="titreOnglet" />
</jsp:include>


<c:if test="${empty article.id}">
	<c:set var="sentenceCreateUpdate" value="créer" />
	<c:set var="labelCreateUpdate" value="Créer" />
	<c:set var="textCreateUpdate" value="Création" />
</c:if>
<c:if test="${not empty article.id}">
	<c:set var="sentenceCreateUpdate" value="mettre à jour" />
	<c:set var="labelCreateUpdate" value="Mettre à jour" />
	<c:set var="textCreateUpdate" value="Mise à jour" />
</c:if>

<!-- content wrapper -->
<div class="content-wrap clearfix pt15">
	<div class="col-lg-12 col-md-12 col-xs-12">
		<div class="panel">
			<header class="panel-heading no-b col-lg-offset-2">
				<h1 class="h3 text-primary mt0">
					<spring:message code="create.article" text="default text" />
				</h1>

				<div class="panel-body">
					<c:url var="createArticle" value="/article/save.do" />
					<form:form action="${createArticle}" commandName="article"
						method="GET">
						<%-- 						<form:errors path="*" cssClass="errorblock" element="div"></form:errors> --%>
						<form:hidden path="id" />
						<div class="form-group">
							<label for="titre"> <spring:message code="label.title"
									text="default text" />
							</label>
							<form:input type="text" class="form-control" id="titre"
								path="titre" placeholder="titre" />
						</div>

						<div class="form-group">
							<label for="chapeau"><spring:message code="label.chapeau"
									text="default text" /></label>
							<form:input type="text" class="form-control" id="chapeau"
								path="chapeau" placeholder="J'écris ici même mon chapeau" />
						</div>

						<div class="form-group">
							<label for="contenu"><spring:message code="label.contenu"
									text="default text" /></label>
							<form:input type="text" class="form-control" id="contenu"
								path="contenu" placeholder="contenu de mon article" />
						</div>

<!-- 						<div class="form-group"> -->
<%-- 							<label for="creationDate"><spring:message --%>
<%-- 									code="label.date" text="default text" /></label> --%>
<%-- 							<form:input type="text" class="form-control" id="creationDate" --%>
<%-- 								path="creationDate" placeholder="dd/MM/yyyy" /> --%>

<!-- 						</div> -->

						<div class="form-group">
							<label for="categorie"><spring:message
									code="choose.categorie" text="default text" /></label>
							<form:select id="categorie" name="categorie" path="categorie.id">
								<form:option value="" label="--- Choisir une Catégorie ---" />
								<form:options items="${categories}" itemValue="id" itemLabel="name" />
							</form:select>
						</div>

						<div class="pull-right">
							<a href="<c:url  value="/auteur/list.do" />"
								class="btn btn-default btn-outline">Retour</a>
							<button type="submit" class="btn btn-outline btn-primary">${labelCreateUpdate}</button>
						</div>
					</form:form>
				</div>
			</header>
		</div>
	</div>
</div>
</div>
</body>
</html>