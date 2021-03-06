package myScheduler;

public class Resource implements Runnable{

	String resourceID;
	ResourceSchedular rs;
	
    public Resource(String resourceID,ResourceSchedular rs){
       this.resourceID = resourceID;
       ResourceSchedular.setMyStaticMember(ResourceSchedular.getResourceAvailable()-1);
      
    }
	    
	public String getResourceID() {
		return resourceID;
	}

	public void setResourceID(String resourceID) {
		this.resourceID = resourceID;
	}


	public void run() {
	
		 String name = Thread.currentThread().getName();
	        System.out.println(name+" started");
	        try {
	            Thread.sleep(5000);
	            synchronized (this) {
	               
	                this.notify();
	               // msg.notifyAll();
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }      
	    }     
	}
	

