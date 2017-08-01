<%@ page contentType="text/html;charset=windows-1252" language="java" %>

<%@ page import="com.google.appengine.api.users.*" %>

<% UserService userService = UserServiceFactory.getUserService(); %>


<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>FixMyRabat - Aidez nous à localiser vos problèmes d'infrastrucure ! </title>
<!-- Core JavaScript Files -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/less2.js"></script>
<!-- Bootstrap Core CSS -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<!-- Fonts -->
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<!-- Custom CSS -->
<link href="css/bootstrapy.css" rel="stylesheet">
<link href="css/less2.css" rel="stylesheet">
<link href="css/2-col-portfolio.css" rel="stylesheet">

<style>
html{overflow:scroll;}
</style>

<link rel="stylesheet" type="text/css" href="css/jquery-gmaps-latlon-picker.css"/>
<script src="js/jquery-gmaps-latlon-picker.js"></script>
<!--a-->
<script src="http://maps.googleapis.com/maps/api/js?sensor=false&key=AIzaSyB2Xx739-t3CqaL-g0kxAquBMGWzQrhSHk"></script>

</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-custom">
<nav class="navbar navbar-custom navbar-fixed-top top-nav-collapse" role="navigation">
<div class="container">
	<div class="navbar-header page-scroll">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
		<i class="fa fa-bars"></i>
		</button>
		<a class="navbar-brand" href="index.jsp">
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
			<a href="/list">Mes Alertes</a>
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


        <footer>
            <div class="row">
                <div class="col-lg-12">
				
                </div>
            </div>
        </footer>

    </div>
		
</body>
</html>