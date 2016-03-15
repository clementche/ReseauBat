package ReseauBat;


import tuwien.auto.calimero.link.KNXNetworkLinkIP;




public class Actionneur {
	
	public static void main(final String[] args)
	{
		// Etablissement de la connection
			Connection conn = new Connection("192.168.0.1");
			KNXNetworkLinkIP link;
			// on se connecte à la maquette 
			link = conn.connect();
			
			// Permet de faire des actions sur la maquette 
			Gestion gest = new Gestion(link);
			Listener listen ;
			
			boolean etat = gest.getLum1();
			if(etat)
				System.out.println("La lumière 1 est allumée");
			else 
				System.out.println("La lumière 1 est éteinte");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gest.switchStateLum1(!etat, 500);
			
			// Création du listener qui écoute sur la maqutte 
			listen = new Listener(link);
			listen.Listen();
			
			conn.disconnet(link);
	
	}
}
