package ReseauBat;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;


import tuwien.auto.calimero.exception.KNXException;
import tuwien.auto.calimero.knxnetip.Discoverer;
import tuwien.auto.calimero.knxnetip.KNXnetIPConnection;
import tuwien.auto.calimero.knxnetip.servicetype.SearchResponse;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.medium.TPSettings;


public class Connection {

	// ip de la maquette 
	private InetSocketAddress remoteEP;
	private InetAddress addressMaquette;
	private String remoteHost;
	// ip de l'ordi
	private  String localHost = "192.168.1.10";
	private InetSocketAddress localEP; 
	// port à utiliser
	private static final int knxServerPort = KNXnetIPConnection.DEFAULT_PORT;
	
	// Constructeur avec parametre de l'adresse de l'ordi et de la maquette
	public Connection(String ipMaquette, String ipOrdi){
		try {
			remoteHost = ipMaquette;
			localHost = ipOrdi;
			localEP = new InetSocketAddress(InetAddress.getByName(ipOrdi), 0);
			remoteEP = new InetSocketAddress(ipMaquette, knxServerPort);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Constructeur avec uniquement l'adresse de l'ordi le reste est découvert tout seul
	public Connection(String ipOrdi){
		Discoverer disc;
		try {
			disc = new Discoverer(knxServerPort, false);
			try {
				disc. startSearch(500, true) ;
				while(disc.isSearching()){
					Thread.sleep(100); 
				}
					for (SearchResponse sr : disc.getSearchResponses()){ 
						System.out.println("Adresse :" + sr.getControlEndpoint().getAddress());
						addressMaquette = sr.getControlEndpoint().getAddress();
					}
					localHost = ipOrdi;
					try {
						localEP = new InetSocketAddress(InetAddress.getByName(ipOrdi), 0);
						remoteEP = new InetSocketAddress(addressMaquette,knxServerPort);
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			} catch (InterruptedException e) {
				System.out.println("Adresse impossible a trouver");
				e.printStackTrace();
			} 

		} catch (KNXException e) {
			System.out.println("Impossible de découvrir le réseau");
			e.printStackTrace();
		} 

	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public String getLocalHost() {
		return localHost;
	}

	// Etablissement de la connection avec la maquette
	public KNXNetworkLinkIP connect(){
		
		try{
			// on établit la connexion
			KNXNetworkLinkIP knxLink = new KNXNetworkLinkIP(KNXNetworkLinkIP.TUNNELING, localEP, remoteEP, false,
					new TPSettings(false));
			
			System.out.println("Connection to " + remoteHost + " successfully established");
			return knxLink;
		}
		catch (KNXException e) {
			System.out.println("Erreur de connexion");
			e.printStackTrace();
			return null;
		} catch (InterruptedException e) {
			System.out.println("Connexion interrompus");
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	// on se déconnecte de la maquette
	public void disconnet(KNXNetworkLinkIP knxLink){
		knxLink.close();		
		System.out.println("Connection got closed");	
	}
	
	
	
}
