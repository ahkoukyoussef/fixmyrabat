package fixMyRabatMain;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.appengine.api.users.*;

import fixMyRabatbeans.Alerte;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.*;



@SuppressWarnings("serial")
public class Details extends HttpServlet {


	    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    	
	    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    	
	    	Long prmKey = Long.parseLong(req.getParameter( "key" ));
	    	Key grpKey = KeyFactory.createKey("Alerte", prmKey);
	    	Entity trv = null;
			try {
				trv = datastore.get(grpKey);
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	PrintWriter out = resp.getWriter();
	    	int i=1;
		 	

		 	
   		 //Static
   		 
   		

   		 UserService userService = UserServiceFactory.getUserService();
   		 resp.setContentType("text/html; charset=UTF-8");
   		 resp.setCharacterEncoding("charset=iso-8859-1");
   		 out.print("<!DOCTYPE html>");
   		 out.print("<html lang=\"en\">");
   		 out.print("<head>");
   		 out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>");
   		 out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
   		 out.print("<title>FixMyRabat - Aidez nous à localiser vos problèmes d'infrastrucure ! </title>");
   		 out.print("<!-- Core JavaScript Files -->");
   		 out.print("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>");
   		 out.print("<script src=\"http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js\"></script>");
   		 out.print("<script src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js\"></script>");
   		 out.print(" <!-- Custom Theme JavaScript -->");
   		 out.print("<script src=\"js/less2.js\"></script>");
   		 out.print(" <!-- Bootstrap Core CSS -->");
   		 out.print(" <link href=\"http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\">");
   		 out.print("<!-- Fonts -->");
   		 out.print("<link href=\"http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">");
   		 out.print("<link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>");
   		 out.print(" <link href='http://fonts.googleapis.com/css?family=Alegreya:400,700' rel='stylesheet' type='text/css'>");
   		 out.print("<!-- Custom CSS -->");
   		 out.print("<link href=\"css/bootstrapy.css\" rel=\"stylesheet\">");
   		 out.print("<link href=\"css/2-col-portfolio.css\" rel=\"stylesheet\">");
   		 out.print("<link href=\"css/less2.css\" rel=\"stylesheet\">");
   		 out.print("<style>");
   		 out.print("html{overflow:auto;}");
   		 out.print("</style>");
   		 
   		 
   		 out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery-gmaps-latlon-pickerloc.css\"/>");
   		 out.print("<script src=\"js/jquery-gmaps-latlon-pickerloc.js\"></script>");
   		 out.print("<!--a-->");
   		 out.print("<script src=\"http://maps.googleapis.com/maps/api/js?sensor=false&key=AIzaSyB2Xx739-t3CqaL-g0kxAquBMGWzQrhSHk\"></script>");

   		 
   		 
   		 out.print("<script type=\"text/javascript\" src=\"https://apis.google.com/js/plusone.js\">");
   		 out.print("{ parsetags: 'explicit' }");
   		 out.print("</script>");

   		 out.print("</head>");
   		 out.print("<body id=\"page-top\" data-spy=\"scroll\" data-target=\".navbar-custom\">");
   		 out.print("<nav class=\"navbar navbar-custom navbar-fixed-top top-nav-collapse\" role=\"navigation\">");
   		 out.print("<div class=\"container\">");
   		 out.print("<div class=\"navbar-header page-scroll\">");
   		 out.print("<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-main-collapse\">");
   		 out.print("<i class=\"fa fa-bars\"></i>");
   		 out.print("</button>");
   		 out.print("<a class=\"navbar-brand\" href=\"index.jsp\">");
   		 out.print("<i class=\"fa fa-angle-double-up animated\"></i> Accueil </a>");
   		 out.print("	</div>");
   		 out.print("<div class=\"collapse navbar-collapse navbar-right navbar-main-collapse\">");
   		 out.print("<ul class=\"nav navbar-nav\">");
   		 out.print("	<li class=\"hidden\">");
   		 out.print("	<a href=\"#page-top\"></a>");
   		 out.print("	</li>");
   		 out.print("		<li>");
   		 if (userService.getCurrentUser() != null) {
   		 out.print("		<a>Bienvenue ! "+userService.getCurrentUser().getNickname()+"</a>");
   		 } 
   		 out.print("		</li>");
   		 			
   		 if (userService.getCurrentUser() == null) { 
   		 out.print("	<%=\"<!--\"%>");
   		 }
   		 			
   		 out.print("		<li>");
   		 out.print("	<a href=\"/list\">Liste des Alertes</a>");
   		 out.print("		</li>");
   		 out.print("		<li>");
   		 out.print("		<a href=\"/myAlerts\">Mes Alertes</a>");
   		 out.print("		</li>");
   		 			
   		 if (userService.getCurrentUser() == null) { 
   		 out.print("		<%=\"-->\"%>");
   		 }
   		 			
   		 out.print("	<li class=\"page-scroll\">	");	
   		 if (userService.getCurrentUser() == null) { 
   		 out.print("	<a href=\""+userService.createLoginURL("index.jsp")+"\">Connexion</a>");
   		 }
   		 else {
   		 out.print("		<a href=\""+userService.createLogoutURL("index.jsp")+"\">Déconnexion</a>");
   		 }
   		 out.print("	</li>");
   		 out.print("</ul>");
   		 out.print("</div>");
   		 out.print("<!-- /.navbar-collapse -->");
   		 out.print("</div>");
   		 out.print("<!-- /.container -->");
   		 out.print("</nav>");

   		 

   		 String sujet = (String) trv.getProperty("Sujet");
   		 String rue   = (String) trv.getProperty("Rue");
   		 String Prb  = (String) trv.getProperty("Probleme");
   		 String Des   = (String) trv.getProperty("Description");
   		 String Pic   = (String) trv.getProperty("PicUrl");
   		 String lng   = (String) trv.getProperty("Long");
   		 String lat  = (String) trv.getProperty("Lat");
   		 String user = (String) trv.getProperty("User");


   		out.print("<div class=\"container\"><div class=\"row\"><div class=\"col-lg-12\"><h1 class=\"page-header\">Alerte N° :"+prmKey+"</h1></div>");
   		out.print("<div id=\"plusone-div\"></div>");
   		out.print("<script type=\"text/javascript\">");
   		 
   		out.print("gapi.plusone.render");
   		out.print("(");
   		out.print("'plusone-div',");
   		out.print("    {");
   		out.print("     \"size\": \"standard\",");
   		out.print("     \"count\": \"true\"");
   		out.print("  }");
   		out.print(");");
   		out.print("</script>");
   		out.print("</div>");
  
   		 //Dynamic

   		 if(i%2!=0){out.print("<div class=\"row\">");}
  		 resp.setContentType("text/html; charset=UTF-8");
   		 out.print("<div class=\"col-lg-5 col-md-5 portfolio-item\"><a><img width=\"700\" hight=\"200\" class=\"img-responsive\" src=\""+Pic+"\"></a><br><h3><a>"+sujet+"<h6> <br> by "+user+"</h6></a></h3><p><b>Rue : "+rue+"</b><br>"+Des+".</p>");
		
 
   		
  		 out.print("</div>");
   		
   		 out.print("<div>");
   		 out.print("<fieldset class=\"gllpLatlonPicker\">");
   		 out.print("<div class=\"gllpMap\">");
   		 out.print("Google Maps");
   		 out.print("	</div>");
   		 out.print("	<br/>");
   		 out.print("<input name=\"inputLat\" type=\"hidden\" class=\"gllpLatitude\" value=\""+lat+"\" >");
   		 out.print("<input name=\"inputLong\" type=\"hidden\" class=\"gllpLongitude\" value=\""+lng+"\">");
         out.print("<input type=\"hidden\" class=\"gllpZoom\" value=\"22\"/>");
         out.print("</fieldset>");
         out.print("</div>");

  
   		 
   		 
   		 
   		 
   		 //static
   		 out.print("  <footer>");
   		 out.print("     <div class=\"row\">");
   		 out.print("             <div class=\"col-lg-12\">");
   		 				
   		 out.print("             </div>");
   		 out.print("         </div>");
   		 out.print("      </footer>");

   		 out.print("</div>");
   		 		
   		 out.print(" </body>");
   		 out.print(" </html>");
   		 
		 	
		 	
	    	
	    	
			out.flush();
			
		
	    }
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
}

