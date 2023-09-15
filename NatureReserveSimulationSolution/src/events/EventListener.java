package events;

import java.util.ArrayList;

public interface EventListener {
	public void notify(Emitter emitter, EmitMessage message);
	public void notifyAll(Emitter emitter, ArrayList<EmitMessage> messages);
}
