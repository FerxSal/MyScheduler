package myScheduler;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public final class ResourceSchedular {
	
	private static ResourceSchedular resourcescheduler = new ResourceSchedular( );
	
	private ResourceSchedular () { // private constructor
        resourcesAvailable = 5;
        queue = new Vector<Object>();
        lastqueue = new LinkedList<Message>();
    }
    
	 /* Static 'instance' method */
	public static ResourceSchedular getInstance( ) {
	      return resourcescheduler;
	}
	
	private static int resourcesAvailable;
	private static Vector<Object> queue;
	private static Queue<Message> lastqueue;
	
	
	public static Queue<Message> getLastqueue() {
		return lastqueue;
	}

	public static Vector<Object> getQueue() {
		return queue;
	}

 
	public static void setMyStaticMember(int val) {
        resourcesAvailable = val;
    }
    
    public static int getResourceAvailable() {
        return resourcesAvailable;
    }
    

	public static void enqueueMessages(int totalmessages,Object message){
		
		int i=0;
		if (totalmessages > ResourceSchedular.getResourceAvailable() )
			queue.add(i++,message);				
	}
	
    
	public static void prioAndDequeue(int totalmessages){
		
		Message msg = null;
		
	  if (totalmessages > ResourceSchedular.getResourceAvailable()){	
		
		 while (queue.size() >0 ){
			 
		  msg = (Message)queue.get(0);
		  String prio = msg.getMessageGroupID();
	      
	      if (msg instanceof Message){	
	    	
	    	 for (int i=0; i <= queue.size() -1;i++){	     		    		 
	    		if ((((Message)queue.get(i)).getMessageGroupID()).equals(prio)){    			
	    		    lastqueue.add((Message)queue.get(i));
	    		    queue.remove(i);
	    	 }
	      }
	     }
	  
		 }
	  }
	}
			
}
