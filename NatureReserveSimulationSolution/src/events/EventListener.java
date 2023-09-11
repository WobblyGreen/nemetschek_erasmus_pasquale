package events;

public interface EventListener {
	public void notify(Event e);
	public void notify(Event e, EmitMessage message);
}
