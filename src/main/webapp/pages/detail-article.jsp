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

<html>

<head>
<meta charset="utf-8">
<c:url var="urlResources" value="/resources/img" />
<link href="assets/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
[class*="col"] {
	margin-bottom: 20px;
}

img {
	width: 100%;
}

.btn-lg {
	/*   width: 50px; */
	height: 50px;
	border-radius: 25px;
}

.rating {
	unicode-bidi: bidi-override;
	direction: rtl;
}

.rating>span {
	display: inline-block;
	position: relative;
	width: 1.1em;
}

.rating>span:hover:before, .rating>span:hover ~ span:before {
	content: "\2605";
	position: absolute;
}
</style>
</head>

<body>
	<div class="container">
		<div class="col-sm-12 col-lg-12">
			<header class="page-header">
				<h1>${article.titre}</h1>
			</header>
		</div>

		<section class="row">
			<div class="col-lg-12">
				<p>${article.chapeau}</p>
				<p>Voici ce qu'en dit le wikipedia :</p>
				<blockquote>
					${article.contenu}<br> <small class="pull-right">Wikipedia</small><br>
				</blockquote>
			</div>
		</section>


		<section class="row">
			<div class="media col-lg-12 col-md-12">
				
					<iframe height=420 width=320
						src="https://www.youtube.com/embed/cBPqFk1Vfqo" frameborder=0 allowfullscreen> </iframe>

			</div>
		</section>


		<div class="container">
			<div id="content" class="row">
				<div class="col-xs-4 col-sm-3 col-md-2">
					<a href="#" class="thumbnail"> <img
						src="${urlResources}/parapente1.jpg" alt="Parapente"
						class="img-circle">
					</a>
				</div>
				<div class="col-xs-4 col-sm-3 col-md-2">
					<img src="${urlResources}/parapente2.jpg" alt="Parapente"
						class="img-circle">
				</div>
				<div class="col-xs-4 col-sm-3 col-md-2">
					<img src="${urlResources}/parapente3.jpeg" alt="Parapente"
						class="img-circle">
				</div>
				<div class="col-xs-4 col-sm-3 col-md-2">
					<img src="${urlResources}/parapente4.jpg" alt="Parapente"
						class="img-circle">
				</div>
				<div class="col-xs-4 col-sm-3 col-md-2">
					<img src="${urlResources}/parapente5.jpg" alt="Parapente"
						class="img-circle">
				</div>
				<div class="col-xs-4 col-sm-3 col-md-2">
					<img src="${urlResources}/parapente6.jpg" alt="Parapente"
						class="img-circle">
				</div>
				<div class="col-xs-4 col-sm-3 col-md-2">
					<img src="${urlResources}/parapente7.jpg" alt="Parapente"
						class="img-circle">
				</div>
				<div class="col-xs-4 col-sm-3 col-md-2">
					<img src="${urlResources}/parapente8.jpg" alt="Parapente"
						class="img-circle">
				</div>
				<div class="col-xs-4 col-sm-3 col-md-2">
					<img src="${urlResources}/parapente9.jpg" alt="Parapente"
						class="img-circle">
				</div>
				<div class="col-xs-4 col-sm-3 col-md-2">
					<img src="${urlResources}/parapente10.jpg" alt="Parapente"
						class="img-circle">
				</div>
				<div class="col-xs-4 col-sm-3 col-md-2">
					<img src="${urlResources}/parapente11.jpg" alt="Parapente"
						class="img-circle">
				</div>
				<div class="col-xs-4 col-sm-3 col-md-2">
					<img src="${urlResources}/parapente12.jpg" alt="Parapente"
						class="img-circle">
				</div>

			</div>
			<div id="page_navigation"></div>
		</div>
		<script src="assets/js/jquery.js"></script>

		<script>
			var show_per_page = 6;

			var current_page = 0;

			function set_display(first, last) {

				$('#content').children().css('display', 'none');

				$('#content').children().slice(first, last).css('display',
						'block');

			}

			function previous() {

				if ($('.active').prev('.page_link').length)
					go_to_page(current_page - 1);

			}

			function next() {

				if ($('.active').next('.page_link').length)
					go_to_page(current_page + 1);

			}

			function go_to_page(page_num) {

				current_page = page_num;

				start_from = current_page * show_per_page;

				end_on = start_from + show_per_page;

				set_display(start_from, end_on);

				$('.active').removeClass('active');

				$('#id' + page_num).addClass('active');

			}

			$(document)
					.ready(
							function() {

								var number_of_pages = Math.ceil($('#content')
										.children().size()
										/ show_per_page);

								var nav = '<ul class="pagination"><li><a href="javascript:previous();">&laquo;</a>';

								var i = -1;

								while (number_of_pages > ++i) {

									nav += '<li class="page_link'

									if (!i)
										nav += ' active';

									nav += '" id="id' + i + '">';

									nav += '<a href="javascript:go_to_page('
											+ i + ')">' + (i + 1) + '</a>';

								}

								nav += '<li><a href="javascript:next();">&raquo;</a></ul>';

								$('#page_navigation').html(nav);

								set_display(0, show_per_page);

							});
		</script>
		<div class="row">
			<section class="col-sm-4">
				<h5>Pourquoi faire du parapente :</h5>
				<br>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>La raison pour laquelle vous avez kiffé le parapente :</h3>
					</div>
					<div class="panel-body">
						<div class="list-group">
							<a href="#" class="list-group-item">La tranquilité <span
								class="badge">170</span>
							</a> <a href="#" class="list-group-item">La belle vue<span
								class="badge">110</span></a> <a href="#" class="list-group-item">Les
								sensations<span class="badge">130</span>
							</a> <a href="#" class="list-group-item">L'expérience<span
								class="badge">190</span></a> <a href="#" class="list-group-item">L'air
								frais<span class="badge">30</span>
							</a>
						</div>
					</div>
					<div class="panel-footer">
						<h5>Pied de page</h5>
					</div>
				</div>
			</section>
			<section class="col-sm-8">
				<div class="thumbnail">
					<img src="${urlResources}/logo-parapente.jpg" alt="Logo"
						class="img-rounded">
				</div>
			</section>
		</div>
		<div class="row">
			<section class="col-sm-8 table-responsive">
				<div class="panel panel-primary">
					<table class="table table-bordered table-striped table-condensed">
						<div class="panel-heading">
							<h4 class="panel-title">Les Lieux pour les sauter</h4>
						</div>
						<thead>
							<tr>
								<th>Lieu</th>
								<th>Détail</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Martinique</td>
								<td>Vue Magnifique</td>
							</tr>
							<tr>
								<td>Nouvelle Zélande</td>
								<td>Beneficiez du paysage somptueux du seigneur des anneaux</td>
							</tr>
							<tr>
								<td>Australie</td>
								<td>Pâte à papier, l’huile de palme et le caoutchouc</td>
							</tr>
							<tr>
								<td>New-York</td>
								<td>Sauter au dessus de la ville de New York, Expérience
									hors du commun</td>
							</tr>
							<tr>
								<td>Alpes</td>
								<td>Balader vous bla bla bla bla bla</td>
							</tr>
							<tr>
								<td>Thaïlande</td>
								<td>Decouvrez .......................;</td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>
			<section class="col-sm-4">
				<address class="thumbnail">
					<p>Vous pouvez me contacter à cette adresse :</p>
					<strong>${auteur.nom}</strong> <strong>${auteur.prenom}</strong><br>
					${auteur.email}<br> ${auteur.url}<br>
				</address>
			</section>
		</div>
		<div class="row">
			<section class="col-lg-6">
				<form class="well">
					<legend>Laissez nous un commentaire</legend>
					<div class="form-group">
						<label for="text">Titre Commentaire : </label> <input id="text"
							type="text" class="form-control">
					</div>
					<div class="form-group">
						<label for="textarea">Votre Commentaire :</label>
						<textarea id="textarea" type="textarea" class="form-control"
							rows="4"></textarea>
						<p class="help-block">Vous pouvez agrandir la fenêtre</p>
					</div>
					<div class="rating">
						<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
						<!-- 					<div class="form-group"> -->
						<!-- 						<label for="select">Note Article : </label><select id="select" -->
						<!-- 							class="form-control"> -->
						<!-- 							<option></option> -->
						<!-- 							<option>*</option> -->
						<!-- 							<option>**</option> -->
						<!-- 							<option>***</option> -->
						<!-- 							<option>****</option> -->
						<!-- 							<option>*****</option> -->
						</select>
					</div>
					<button class="btn btn-primary btn-lg" type="submit">
						<span class="glyphicon glyphicon-ok-sign" style="color: #4f4;"></span>
						Envoyer
					</button>
				</form>
			</section>
			<section class="col-lg-3">
				<div class="btn-group">
					<h1 data-toggle="dropdown">
						<span class="label label-default">Passez sur moi !</span>
					</h1>
					<ul class="dropdown-menu">
						<li><a href="#">Dompteurs</a></li>
						<li><a href="#">Zoos</a></li>
						<li><a href="#">Chasseurs</a></li>
					</ul>
				</div>
				<script src="assets/js/jquery.js"></script>
				<script src="assets/js/bootstrap.min.js"></script>
				<script>
					$('h1').mouseover(function() {

						$(this).dropdown('toggle');

					});
				</script>
			</section>
			<section class="col-lg-3">
				<button data-toggle="modal" href="#infos" class="btn btn-primary">Informations</button>
				<div class="modal" id="infos">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">X</button>
								<h4 class="modal-title">Plus d'informations</h4>
							</div>
							<div class="modal-body">Le Tigre (Panthera tigris) est un
								mammifère carnivore de la famille des félidés...</div>
						</div>
					</div>
				</div>
			</section>
		</div>
</body>
</html>