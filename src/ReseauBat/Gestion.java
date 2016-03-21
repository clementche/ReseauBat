package ReseauBat;

import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.exception.KNXException;
import tuwien.auto.calimero.exception.KNXFormatException;
import tuwien.auto.calimero.exception.KNXTimeoutException;
import tuwien.auto.calimero.link.KNXLinkClosedException;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;

public class Gestion {
	private KNXNetworkLinkIP link;
	ProcessCommunicator pc;
	public GroupAddress lamp1;
	public GroupAddress lamp2;
	public GroupAddress lamp3;
	public GroupAddress lamp4;
	
	public Gestion(KNXNetworkLinkIP netLink){
		link = netLink;
		try {
			pc = new ProcessCommunicatorImpl(link);
		} catch (KNXLinkClosedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Boolean getLum(String numLamp){
		try {
			Thread.sleep(500);
			return pc.readBool(new GroupAddress("0/2/"+numLamp));
		} catch (KNXFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (KNXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	
	public void switchStateLum(boolean etat, int speed, String numLamp){
		try {
			
			try {
				Thread.sleep(speed);
				pc.write(new GroupAddress("0/1/" + numLamp), etat);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (KNXTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KNXLinkClosedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KNXFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public void switchOff(){
		try {
			try {
				pc.write(new GroupAddress("0/1/1"), false);
				Thread.sleep(500);
				pc.write(new GroupAddress("0/1/2"), false);
				Thread.sleep(500);
				pc.write(new GroupAddress("0/1/3"), false);
				Thread.sleep(500);
				pc.write(new GroupAddress("0/1/4"), false);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (KNXTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KNXLinkClosedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KNXFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void switchOn(){
		try {
			
			try {
				pc.write(new GroupAddress("0/1/1"), true);
				Thread.sleep(500);
				pc.write(new GroupAddress("0/1/2"), true);
				Thread.sleep(500);
				pc.write(new GroupAddress("0/1/3"), true);
				Thread.sleep(500);
				pc.write(new GroupAddress("0/1/4"), true);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (KNXTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KNXLinkClosedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KNXFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void chenillar(int speed, boolean start){
		// ecrire la fonction chenillar 
		this.switchOff();
		while(start){
			this.switchStateLum(true , speed, "1");
			this.switchStateLum(true , speed,"2");
			this.switchStateLum(false , speed,"1");
			this.switchStateLum(true , speed, "3");
			this.switchStateLum(false , speed, "2");
			this.switchStateLum(true , speed, "4");
			this.switchStateLum(false , speed, "3");
			this.switchStateLum(true , speed, "1");
			this.switchStateLum(false , speed, "4");
		}
	}
	
	
	public void chenillar2(int speed, int start){
		// ecrire la fonction chenillar
		this.switchOff();
		while(start > 0){
			this.switchStateLum(true , speed, "1");
			this.switchStateLum(true , speed,"2");
			this.switchStateLum(false , speed,"1");
			this.switchStateLum(true , speed, "3");
			this.switchStateLum(false , speed, "2");
			this.switchStateLum(true , speed, "4");
			this.switchStateLum(false , speed, "3");
			this.switchStateLum(true , speed, "1");
			this.switchStateLum(false , speed, "4");
			start--;
		}
	}
	
	public void milieuchenille(int speed, boolean start){
		this.switchOff();
		while(start){
			this.switchStateLum(false , speed, "2");
			this.switchStateLum(false , speed, "3");
			this.switchStateLum(true , speed, "2");
			this.switchStateLum(true , speed, "3");
			this.switchStateLum(true , speed, "4");
			this.switchStateLum(true , speed, "1");
			this.switchStateLum(false , speed, "2");
			this.switchStateLum(false , speed, "3");
		}
		
	}
	
	public void chenillarInv(int speed, boolean start){
		// ecrire la fonction chenillar 
		this.switchOff();
		while(start){
			this.switchStateLum(true , speed, "4");
			this.switchStateLum(true , speed,"3");
			this.switchStateLum(false , speed,"4");
			this.switchStateLum(true , speed, "2");
			this.switchStateLum(false , speed, "3");
			this.switchStateLum(true , speed, "1");
			this.switchStateLum(false , speed, "2");
			this.switchStateLum(true , speed, "4");
			this.switchStateLum(false , speed, "1");
		}
	}
	
}
