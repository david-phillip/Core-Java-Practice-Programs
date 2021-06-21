package test.prac.patterns.ObserverPattern;

public class Message {
	
	private String message;

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "" + message + "";
	}
	
	
}
