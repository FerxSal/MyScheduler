package myScheduler;

public class Message implements IMessage{

	private String messageID;
	private String messageGroupID;
	private String payload;
	private String status;
	private static int contmessages;
	
	
	public static int getContmessages() {
		return contmessages;
	}

	public static void setContmessages(int contmessages) {
		Message.contmessages = contmessages;
	}

	public Message(String messageID, String messageGroupID, String payload,String status) {
		super();
		this.messageID = messageID;
		this.messageGroupID = messageGroupID;
		this.payload = payload;
		this.status = status;
		contmessages++;
		
	}

	public String getMessageID() {
		return messageID;
	}
	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}
	public String getMessageGroupID() {
		return messageGroupID;
	}
	public void setMessageGroupID(String messageGroupID) {
		this.messageGroupID = messageGroupID;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void completed() {
		setStatus("Message Delivered!");
		
	}

		
	
}
