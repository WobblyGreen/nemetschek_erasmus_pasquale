package log;

import java.util.ArrayList;

import events.*;

public class Logger implements EventListener{
	private EventFormatter eventFormatter;
	private boolean summary;
	
	public Logger(EventFormatter ef, boolean summary) {
		this.eventFormatter=ef;
		this.summary=summary;
	}


	@Override
	public void notify(Emitter emitter, EmitMessage message) {
		Event e = message.getEvent();
		String toConsole;
		
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

	@Override
	public void notifyAll(Emitter emitter, ArrayList<EmitMessage> messages) {
		for(EmitMessage msg:messages) {
			if(msg.getEvent()==null) continue;
			notify(emitter, msg);
		}
		
	}
}
