package ReseauBat;

import tuwien.auto.calimero.CloseEvent;
import tuwien.auto.calimero.FrameEvent;
import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.cemi.CEMILData;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.NetworkLinkListener;

public class Listener {

	
	public KNXNetworkLinkIP netLink;
	private String add;
	private Boolean appuie  = false;
	Gestion gest =  new Gestion(netLink);
	int speed = 2000;
	
	// Constructeur
	public Listener(KNXNetworkLinkIP link){
		netLink = link;
	};
	
	// On créée le Listener
	public void Listen(){
		netLink.addLinkListener(new NetworkLinkListener(){ 
			public void confirmation(FrameEvent arg0) {
			}
			
			public void indication(FrameEvent arg0) {
				System.out.println("srcadress " + arg0.getSource()); 
				// On recupere l'adresse source pour effectuer une action en fonction de qui fait.
				add = ((GroupAddress) arg0.getSource()).toString();
				appuie = !appuie;
				if (speed >= 500 ) speed -= 50;
				else speed = 1000;
				// TODO mettre la fonction chenillar 
				gest.chenillar(speed, appuie);
				System.out.println("targetadress " + ((CEMILData)arg0.getFrame()).getDestination());
			}
					
			public void linkClosed(CloseEvent arg0) {
				
			}	
		});
		
	}

	public String getAddress() {
		return add;
	}

}
