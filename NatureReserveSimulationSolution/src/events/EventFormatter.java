package events;

import java.util.ArrayList;

public class EventFormatter {
	ArrayList<Event> doNotDisplayMessageEvents;
	
	public EventFormatter() {}
	
	public String formatEvent(Event e, EmitMessage message) {
		String formattedEvent="  ";
		
		switch(e) {
		case NEW_DAY:
			formattedEvent="\n---------- Day "+message.getMessage().split("BREAK")[0]+" ----------"+message.getMessage().split("BREAK")[1];
			break;
			
		case ANIMAL_CYCLE_STARTED:
			formattedEvent=">>";
			break;
			
		case BIOME:
			formattedEvent="\n|| ";
			break;
		
		case EAT:
			formattedEvent+="_eats ";
			break;
			
		case EAT_BAD_FOOD:
			formattedEvent+="_tried to eat ";
			break;
			
		case CANT_EAT:
			formattedEvent+="_thought about eating ";
			break;
			
		case EAT_ITSELF:
			formattedEvent+="_tried to eat itself ";
			break;
			
		case GROW:
			formattedEvent+="_grows to ";
			break;
			
		case EXPANDING_DIET:
			formattedEvent+="_adding in diet ";
			break;
		
		case DIE:
			formattedEvent+="_died";
			break;
		
		case MOVED:
			formattedEvent+="_moved ";
			break;
		}
			
		return formattedEvent+(e==Event.NEW_DAY ? "" : message.getMessage());
	}
}
