package fixMyRabatMain;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.images.*;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.*;
import com.google.appengine.api.images.ServingUrlOptions;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;



@SuppressWarnings("serial")
public class NewAlerte extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		ImagesService imagesService = ImagesServiceFactory.getImagesService();
		UserService userService = UserServiceFactory.getUserService();
		
		// Récupère une Map de tous les champs d'upload de fichiers
        Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);

        // Récupère la liste des fichiers uploadés dans le champ "uploadedFile"
        // (il peut y en avoir plusieurs si c'est un champ d'upload multiple, d'où la List)
        List<BlobKey> blobKeys = blobs.get("photo");

        // Récupère la clé identifiant du fichier uploadé dans le Blobstore (à sauvegarder)
        String cleFichierUploade = blobKeys.get(0).getKeyString();
		
        // Récupération de l'URL de l'image
        String urlImage = imagesService.getServingUrl(ServingUrlOptions.Builder.withBlobKey(blobKeys.get(0)));
		
		// Crée l'entité de type "Alerte"
		Entity alerte = new Entity("Alerte");
		
		// Assigne des propriétés à l'entité Alerte
        com.google.appengine.api.datastore.Key key=KeyFactory.createKey("Alerte",1);
		alerte.setProperty("Sujet",req.getParameter("inputSuj"));
		alerte.setProperty("Rue",req.getParameter("inputRue"));
		alerte.setProperty("Description",req.getParameter("inputDes"));
		alerte.setProperty("Probleme",req.getParameter("SelectP"));
		alerte.setProperty("PicUrl",urlImage);
		alerte.setProperty("Lat",req.getParameter("inputLat"));
		alerte.setProperty("Long",req.getParameter("inputLong"));
		alerte.setProperty("User",userService.getCurrentUser().getNickname());
		
		// Enregistre l'entité dans le Datastore
		datastore.put(alerte);
		datastore.delete(key);		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/redirect.html");
		try {
			req.setAttribute("subscribed",true);
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

}
