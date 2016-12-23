package be.vdab.newsfeed;

import be.vdab.post.Post;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author simon.chaffart
 */
public class NewsFeed implements Serializable {
    private final List<Post> posts = new ArrayList<>();

    public List<Post> getPosts()
    {
        return posts;
    }
    
    public void addPost(Post post) {
        posts.add(post);
    }
    
    public void show() {
        posts.forEach(p -> {p.display();System.out.println();});
    }
}
