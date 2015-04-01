package myScheduler;

import java.util.ArrayList;
import java.util.List;

public class ResourceSchedularMain {

	
	public static void main(String args[]){
		
		
	  List myList = new ArrayList<String>();	
	  ResourceSchedular rs = ResourceSchedular.getInstance();
	  ResourceSchedular.setMyStaticMember(1);		
	  System.out.println(ResourceSchedular.getResourceAvailable());
	  //Create Resources based on static var numtotal Resources 
	  Resource resource1 = new Resource("Resource01",rs);
//	  Resource resource2 = new Resource("Resource02",rs);
//	  Resource resource3 = new Resource("Resource03",rs);
//	  Resource resource4 = new Resource("Resource04",rs);
//	  Resource resource5 = new Resource("Resource05",rs);
	  
	  //Create Messages, to be delivered  
	  Message msg1 = new Message("message1", "Prio2","sending message1","init");
	  Message msg2 = new Message("message2", "Prio1","sending message2","init");
	  Message msg3 = new Message("message3", "Prio2","sending message3","init");
	  Message msg4 = new Message("message4", "Prio3","sending message4","init");
	  System.out.println("Number Of Messages Others "+Message.getContmessages());
	  Message msg5 = new Message("message5", "Prio3","sending message5","init");
	  Message msg6 = new Message("message6", "Prio2","sending message6","init");
	  Message msg7 = new Message("message7", "Prio2","sending message7","init");
	  Message msg8 = new Message("message8", "Prio1","sending message8","init");
	  Message msg9 = new Message("message9", "Prio2","sending message9","init");
	  
	  System.out.println("Number Of Messages "+Message.getContmessages());
	  
	  //Gateway is alocated in how many Resources are created and sets a message to be send
	  Gateway gateway1 = new Gateway(msg1,resource1);
//	  Gateway gateway2 = new Gateway(msg2,resource2);
//	  Gateway gateway3 = new Gateway(msg3,resource3);
//	  Gateway gateway4 = new Gateway(msg4,resource4);
//	  Gateway gateway5 = new Gateway(msg5,resource5);
	  
	  
	  Thread t2 = new Thread(gateway1,"gateway1");
	  t2.start();
//	  new Thread(gateway2,"gateway2").start();
//	  new Thread(gateway3,"gateway3").start();
//	  new Thread(gateway4,"gateway4").start();
//	  new Thread(gateway5,"gateway5").start();
	  
	  Thread t1 = new Thread(resource1,"resource1");
	  t1.start();
	  try {
		t1.join();
		ResourceSchedular.setMyStaticMember(ResourceSchedular.getResourceAvailable()+1);
	    System.out.println(ResourceSchedular.getResourceAvailable()  + "   free Resource");
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
//	  new Thread(resource2,"resource2").start();
//	  new Thread(resource3,"resource3").start();
//	  new Thread(resource4,"resource4").start();
//	  new Thread(resource5,"resource5").start();	
	  
	  
	  ResourceSchedular.enqueueMessages(Message.getContmessages(),msg2);
	  ResourceSchedular.enqueueMessages(Message.getContmessages(),msg3);
	  ResourceSchedular.enqueueMessages(Message.getContmessages(),msg4);
	  
	  ResourceSchedular.enqueueMessages(Message.getContmessages(),msg5);
	  ResourceSchedular.enqueueMessages(Message.getContmessages(),msg6);
	  ResourceSchedular.enqueueMessages(Message.getContmessages(),msg7);
	  
	  ResourceSchedular.prioAndDequeue(Message.getContmessages());
	    
	  if (ResourceSchedular.getQueue().size() == 0 && ResourceSchedular.getResourceAvailable() > 0){
		 
		while ( ResourceSchedular.getLastqueue().size() != 0){
		     	
			gateway1 = new Gateway(ResourceSchedular.getLastqueue().poll(),resource1);	
			t2 = new Thread(gateway1,"gateway1");
			t2.start();
			
			t1 = new Thread(resource1,"resource1");
			t1.start();
			
			try {
				t2.join();
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		  
	  }
	  
	   System.out.println(ResourceSchedular.getResourceAvailable() + "  Resources Available");
	}
	
	
	
}
