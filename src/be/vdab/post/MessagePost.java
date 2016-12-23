package be.vdab.post;

import be.vdab.person.User;
import be.vdab.util.PostException;

/**
 *
 * @author simon.chaffart
 */
public class MessagePost extends Post {
    private String message;

    public MessagePost(User user, String message) throws PostException
    {
        super(user);
        setMessage(message);
    }

    public String getMessage()
    {
        return message;
    }

    private void setMessage(String message) throws PostException
    {
        if (message != null && !message.trim().isEmpty()) {
        this.message = message;
        }
        else if (message == null) {
            throw new PostException("De message mag niet null zijn");
        }
        else if (message.isEmpty()) {
            throw new PostException("De message mag niet leeg zijn");
        }
        else if (message.trim().isEmpty()) {
            throw new PostException("De message mag niet enkel spaties bevatten");
        }
    }
    
    @Override
    public void display() {
        super.display();
        System.out.println("MESSAGE: " + message);
    }
}
