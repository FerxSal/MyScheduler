package myScheduler;


public class Gateway implements IGateway, Runnable {

	private Message msg;
	private Resource resource;
	
		
	public Gateway(Message msg, Resource resource) {
		super();
		this.msg = msg;
		this.resource = resource;
		
	}

	public void send(Message msg) {
		msg.setStatus("Sending Message...");
		msg.setStatus("In Progress");
		
	}

	public void run() {
		
		String name = Thread.currentThread().getName();
        synchronized (resource) {
	            try{
	                System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
	                send(msg);
	                resource.wait();
	            }catch(InterruptedException e){
	                e.printStackTrace();
	            }
	            System.out.println(name+" waiter thread got notified at time:"+System.currentTimeMillis());
	            //process the message now
	            System.out.println(name+" processed: "+msg.getPayload());
	        }
          msg.completed();
          System.out.println(msg.getStatus());
	    }

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

				
	}


