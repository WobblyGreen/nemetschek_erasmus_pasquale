package events;

public class EmitMessage {
	private Emitter emitter;
	private Event event;
	private String message;

	
	public EmitMessage(Event event, String message) {
		this.message=message;
		this.event=event;
	}
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void setEmitter(Emitter emitter) {
		this.emitter = emitter;
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
