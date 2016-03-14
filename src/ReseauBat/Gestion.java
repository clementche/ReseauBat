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
	
	public Boolean getLum1(){
		try {
			Thread.sleep(150);
			return pc.readBool(new GroupAddress("0/2/1"));
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
	
	public Boolean getLum2(){
		try {
			Thread.sleep(150);
			return pc.readBool(new GroupAddress("0/2/2"));
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
	public Boolean getLum3(){
		try {
			Thread.sleep(150);
			return pc.readBool(new GroupAddress("0/2/3"));
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
	public Boolean getLum4(){
		try {
			Thread.sleep(150);
			return pc.readBool(new GroupAddress("0/2/4"));
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
	
	
	public void switchStateLum1(boolean etat, int speed){
		try {
			
			try {
				Thread.sleep(speed);
				pc.write(new GroupAddress("0/1/1"), etat);
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
	
	
	public void switchStateLum2(boolean etat, int speed){
		try {
			
			try {
				Thread.sleep(speed);
				pc.write(new GroupAddress("0/1/2"), etat);
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
	
	public void switchStateLum3(boolean etat, int speed){
		try {
			
			try {
				Thread.sleep(speed);
				pc.write(new GroupAddress("0/1/3"), etat);
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
	
	public void switchStateLum4(boolean etat, int speed){
		try {
			
			try {
				Thread.sleep(speed);
				pc.write(new GroupAddress("0/1/4"), etat);
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
				Thread.sleep(150);
				pc.write(new GroupAddress("0/1/2"), false);
				Thread.sleep(150);
				pc.write(new GroupAddress("0/1/3"), false);
				Thread.sleep(150);
				pc.write(new GroupAddress("0/1/4"), false);
				Thread.sleep(150);
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
				Thread.sleep(150);
				pc.write(new GroupAddress("0/1/2"), true);
				Thread.sleep(150);
				pc.write(new GroupAddress("0/1/3"), true);
				Thread.sleep(150);
				pc.write(new GroupAddress("0/1/4"), true);
				Thread.sleep(150);
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
		while(start){
			this.switchStateLum1(true , speed);
			this.switchStateLum2(true , speed);
			this.switchStateLum1(false , speed);
			this.switchStateLum3(true , speed);
			this.switchStateLum2(false , speed);
			this.switchStateLum4(true , speed);
			this.switchStateLum3(false , speed);
			this.switchStateLum1(true , speed);
			this.switchStateLum4(false , speed);
		}
	}
	
}
