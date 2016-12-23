package be.vdab.post;

import be.vdab.person.User;
import be.vdab.util.PostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author simon.chaffart
 */
public class CommentedPost extends MessagePost {
    private int likes = 0;
    private final List<MessagePost> comments = new ArrayList<>();

    public CommentedPost(User user, String message) throws PostException
    {
        super(user, message);
    }

    public void like()
    {
        likes++;
    }

    /**
     * Deze methode het aantal likes niet verder verlagen onder nul
     *
     */
    public void unlike()
    {
        if (likes >= 0) {
            likes--;
        }
    }

    public void addComment(MessagePost messagepost)
    {
        comments.add(messagepost);
    }

    @Override
    public void display()
    {
        super.display();
        if (likes > 0) {
            System.out.println(" - " + likes + " people like(s) this");
        }
        if (comments.isEmpty()) {
            System.out.println("\tno comments");
        }
        else {
            comments.forEach(c -> System.out.println("\t" + c.getMessage()));
        }
    }
}
