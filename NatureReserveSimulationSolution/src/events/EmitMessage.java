package events;

public class EmitMessage {
	Emitter emitter;
	String message;
	
	public EmitMessage(Emitter emitter) {
		this.emitter=emitter;
	}
	
	public EmitMessage(Emitter emitter, String message) {
		this.emitter=emitter;
		this.message=message;
	}

	public Emitter getEmitter() {
		return emitter;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message=message;
	}
}
