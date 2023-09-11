package events;

public class EventFormatter {
	
	public String formatEvent(Event e, EmitMessage message) {
		String formattedEvent="";
		
		switch(e) {
		case NEW_DAY:
			formattedEvent="\n---------- Day "+message.getMessage()+" ----------";
			break;
		}
		
		return formattedEvent;
	}
}
