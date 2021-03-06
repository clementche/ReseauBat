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
	private Boolean appuie  = true;
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
				if(add.equals("1/1/1")){
					if (speed >= 500 ) speed -= 50;
					else speed = 2000;
					gest.switchOff();
					gest.chenillar(speed, appuie);
				}
				else if(add.equals("1/1/2")){
					gest.switchOff();
				}
				else if (add.equals("1/1/3")){
					appuie = !appuie;
					netLink.close();
				}
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
