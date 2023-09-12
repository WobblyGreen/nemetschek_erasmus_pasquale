package log;

import events.EmitMessage;
import events.Event;
import events.EventFormatter;
import events.EventListener;

public class Logger implements EventListener{
	private EventFormatter eventFormatter;
	private boolean summary;
	
	public Logger(EventFormatter ef) {
		this.eventFormatter=ef;
	}
	
	public Logger(EventFormatter ef, boolean summary) {
		this(ef);
		this.summary=summary;
	}

	@Override
	public void notify(Event e) {
		System.out.println("Event "+e+" occurred");
	}

	@Override
	public void notify(Event e, EmitMessage message) {
		String toConsole;
		if(e==null) e=Event.GENERIC;
		
		if(summary) {
			if(e!=Event.SUMMARY) return;
			toConsole = eventFormatter.formatEvent(e, message);
		}
		
		else {
			if(e==Event.SUMMARY) return;
			toConsole = eventFormatter.formatEvent(e, message);
			if(!toConsole.isBlank()) toConsole+="\n";
		}
		System.out.print(toConsole);
	}
}
