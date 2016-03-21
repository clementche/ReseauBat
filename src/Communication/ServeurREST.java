package Communication;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context; 
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Request; 
import javax.ws.rs.core.UriInfo;

import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import ReseauBat.Actionneur;
import ReseauBat.Gestion;

//import ReseauBat.Connection;

@Path("/switch")
public class ServeurREST{

	UriInfo uriInfo;
	Request request;
	
	//Affiche les methodes disponibles à la racine de l'URL
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public String ready(){
		return "Ca marche!";
	} 
	//url : http://localhost:8080/ReseauBat/switch
	
	KNXNetworkLinkIP link = Actionneur.link;
	Gestion gest = new Gestion(link);
	
	@Path("/allumeLampe/{numLampe}")		//Allumer la lampe
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void allumeLampe(@PathParam("numLampe") String numLampe){
		Boolean etatLampe = gest.getLum(numLampe); 			//Etat initial de la lampe
		if(etatLampe==false){								//Si éteind
			gest.switchStateLum(etatLampe, 500, numLampe);	//On allume
		}
	}
	//url : http://localhost:8080/ReseauBat/switch/allumeLampe/{numLampe}
	
	@Path("/eteindreLampe/{numLampe}")		//Eteindre la lampe
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void eteindreLampe(@PathParam("numLampe") String numLampe){
		Boolean etatLampe = gest.getLum(numLampe); 			//Etat initial de la lampe
		if(etatLampe==true){								//Si allumée
			gest.switchStateLum(etatLampe, 500, numLampe);	//On éteind
		}
	}
	//url : http://localhost:8080/ReseauBat/switch/eteindreLampe/{numLampe}

	@Path("/runChenillar")					//Demarrer le chenillar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void runChenillar(){
		gest.chenillar(500, true);
	}
	//url : http://localhost:8080/ReseauBat/switch/runChenillar
	
	@Path("/stopChenillar")					//Arreter le chenillar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void stopChenillar(){
		gest.switchOff();
	}
	//url : http://localhost:8080/ReseauBat/switch/stopChenillar
	
	@Path("/changeMotif")					//Demarrer le chenillar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void changeMotif(){
		int lower = 0;
		int higher = 3;
		int random = (int)(Math.random() * (higher-lower)) + lower;
		
		switch(random){
			case 0 : gest.chenillar(500, true);
			case 1 : gest.chenillarInv(500, true);
			case 2 : gest.milieuChenille(500, true);
			case 3 : gest.deuxDeux(500,true);
		}
	}
	//url : http://localhost:8080/ReseauBat/switch/runChenillar
	
}

