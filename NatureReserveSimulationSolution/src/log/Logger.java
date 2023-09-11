package log;

import events.EmitMessage;
import events.Event;
import events.EventListener;

public class Logger implements EventListener{

	@Override
	public void notify(Event e) {
		System.out.println("Event "+e+" occurred");
	}

	@Override
	public void notify(Event e, EmitMessage message) {
		String toLog = e+" "+message.getMessage();
		System.out.print("\n"+(message.getEmitter()==null ? "" : message.getEmitter()+" ")+toLog);
	}
	
	
	private String getActionFromEvent(Event e) {
		return "";
	}
	

}
