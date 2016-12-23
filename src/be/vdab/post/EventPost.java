package be.vdab.post;

import be.vdab.person.User;
import be.vdab.util.EventType;
import be.vdab.util.PostException;

/**
 *
 * @author simon.chaffart
 */
public class EventPost extends Post{
    private EventType eventType;

    public EventPost(User user, EventType eventType) throws PostException
    {
        super(user);
        setEventType(eventType);
    }

    public EventType getEventType()
    {
        return eventType;
    }

    public void setEventType(EventType eventType) throws PostException 
    {
        if (eventType != null) {
        this.eventType = eventType;
        }
        else {
            throw new PostException("Het eventtype mag niet null zijn");
        }
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("EVENT: " + eventType);
    }
    
    
}
