<%@ page contentType="text/html;charset=windows-1252" language="java" %>

<%@ page import="com.google.appengine.api.users.*" %>
<%@ page import="com.google.appengine.api.blobstore.*" %>

<% UserService userService = UserServiceFactory.getUserService(); %>
<% BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService(); %>

<!DOCTYPE html>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FixMyRabat - Aidez nous à localiser vos problèmes d'infrastrucure ! </title>


<!-- Core JavaScript Files -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<!-- Custom Theme JavaScript -->

<script src="js/less1.js"></script>


<!-- Bootstrap Core CSS -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<!-- Fonts -->
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Alegreya:400,700' rel='stylesheet' type='text/css'>
<!-- Custom CSS -->
<link href="css/bootstrapy.css" rel="stylesheet">
<link href="css/less1.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/jquery-gmaps-latlon-picker.css"/>
<link href="css/sbox.css" rel="stylesheet">
<script src="js/jquery-gmaps-latlon-picker.js"></script>
<!--a-->
<script src="http://maps.googleapis.com/maps/api/js?sensor=false&key=AIzaSyB2Xx739-t3CqaL-g0kxAquBMGWzQrhSHk"></script>



</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-custom">


<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
<div class="container">
	<div class="navbar-header page-scroll">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
		<i class="fa fa-bars"></i>
		</button>
		<a class="navbar-brand" href="#page-top">
		<i class="fa fa-angle-double-up animated"></i> Accueil </a>
	</div>
<div class="collapse navbar-collapse navbar-right navbar-main-collapse">
		<ul class="nav navbar-nav">
			<li class="hidden">
			<a href="#page-top"></a>
			</li>
			<li>
			<% if (userService.getCurrentUser() != null) { %>
			<a>Bienvenue ! <%= userService.getCurrentUser().getNickname() %></a>
			<% } %>
			</li>
			
			<% if (userService.getCurrentUser() == null) { %>
			<%="<!--"%>
			<% } %>
			
			<li>
			<a href="/list">Liste des Alertes</a>
			</li>
			<li>
			<a href="/myAlerts">Mes Alertes</a>
			</li>
			
			<% if (userService.getCurrentUser() == null) { %>
			<%="-->"%>
			<% } %>
			
			<li class="page-scroll">		
			<% if (userService.getCurrentUser() == null) { %>
			<a href="<%= userService.createLoginURL("index.jsp") %>">Connexion</a>
			<% }
			else { %>
			<a href="<%= userService.createLogoutURL("index.jsp") %>">Déconnexion</a>
			<% } %>
			</li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</div>
<!-- /.container -->
</nav>
		
<section class="intro">
<div class="intro-body">
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<br>
				<h1 class="brand-heading">FixMyRabat</h1>
				<p class="intro-text">
					Une Solution d'urbanisme participatif pour localiser et réparer Les infrastructures déféctueuses dans votre rue .
				</p>
					<% if (userService.getCurrentUser() == null) { %>
			<%="<!--"%>
			<% } %>
				<div class="page-scroll">
					<a href="#report" class="btn btn-y">
					<i class="fa fa-angle-double-down animated">
					<h3>Signaler un problème : </h3>
					</i>
					</a>
				</div>
				
					<% if (userService.getCurrentUser() == null) { %>
			<%="-->"%>
			<% } %>
			
			</div>
		</div>
	</div>
</div>
</section>

	<% if (userService.getCurrentUser() == null) { %>
			<%="<!--"%>
			<% } %>

<section id="report" class="content-section">

<div class="row">

	<div class="col-lg-4 col-mg-offset-1">
			<br><h5>Veuillez remplir le formulaire suivant </h5>
		<form method="POST" action="<%=blobstoreService.createUploadUrl("/new") %>" enctype="multipart/form-data">
			<div class="form-group">
				<input type="text" class="form-control" name="inputSuj" placeholder="Sujet">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="inputRue" placeholder="Rue">
			</div>
			<div class="form-group">
				<textarea rows="7" class="form-control" name="inputDes" placeholder="Description"></textarea>
			</div>
			<div class="form-group">
				<select type="text" class="form-control" name="SelectP">

					<option value="-- None --">-- Choisissez le type du problème --</option>
					<option value="Affiches Abimés">Affiches Abimés</option>
					<option value="Animaux">Animaux</option>
					<option value="Arbres">Arbres</option>
					<option value="Bus stops">Bus stops</option>
					<option value="Chaussée/dalles Abimés">Chaussée/dalles Abimés</option>
					<option value="Graffiti">Graffiti</option>
					<option value="Vehicules abondonnées">Vehicules abondonnées</option>
					<option value="Lumiere">Lumiere</option>
					<option value="Parking">parking</option>
					<option value="Nettoyage">Nettoyage</option>
					<option value="Toilettes publics">Toilettes publics</option>
					<option value="Autres">Autres...</option>
				</select>
			</div>
			<div class="form-group">
				 Photo du problème en question : <input type="file" name="photo" id="form_photo">
			</div>
			 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <button type="submit" class="btn btn-primary">Envoyez</button>
	</div>
	<div>

			<fieldset class="gllpLatlonPicker">
				<div class="col-lg-12">
					<div class="input-group">
						<span class="input-group-btn">
						<button class="btn btn-default gllpSearchButton" type="button">Go!</button>
						</span>
						<input type="text" class="gllpSearchField form-control" placeholder="Chercher une ville/rue ...">
					</div>
				</div>
				<br/><br/>
				<div class="gllpMap">
					Google Maps
				</div>
				<br/>
				<input name="inputLat" type="hidden" class="gllpLatitude" value="34.0020" >
				<input name="inputLong" type="hidden" class="gllpLongitude" value="-6.8561">
				<input type="hidden" class="gllpZoom" value="14"/>
				<br/>
			</fieldset>
		</form>
	</div>
</div>
</section>
	<% if (userService.getCurrentUser() == null) { %>
			<%="-->"%>
			<% } %>
			
			

</body>
</html>