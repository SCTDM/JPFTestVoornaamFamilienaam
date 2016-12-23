package be.vdab;

import be.vdab.newsfeed.NewsFeed;
import be.vdab.person.User;
import be.vdab.post.CommentedPost;
import be.vdab.post.EventPost;
import be.vdab.post.MessagePost;
import be.vdab.post.PhotoPost;
import be.vdab.post.Post;
import be.vdab.util.EventType;
import be.vdab.util.PostException;
import be.vdab.util.UserException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author simon.chaffart
 */
public class Network {
    public static void main(String[] args)
    {
        // Met enkel spaties al naam
        try {
            User user = new User("    ", "loodgieter", new File("BartWaterslagers.jpg"));

            user.display();
        }
        catch ( UserException ex ) {
            System.out.print("Met enkel spaties al naam: \t");
            System.out.println(ex.toString());
        }

        // Met een lege string als naam
        try {
            User user = new User("", "loodgieter", new File("BartWaterslagers.jpg"));

            user.display();
        }
        catch ( UserException ex ) {
            System.out.print("Met een lege string als naam: \t");
            System.out.println(ex.toString());
        }

        // Met null als value voor naam
        try {
            User user = new User(null, "loodgieter", new File("BartWaterslagers.jpg"));

            user.display();
        }
        catch ( UserException ex ) {
            System.out.print("Met null als value voor naam: \t");
            System.out.println(ex.toString());
        }

        // Met enkel spaties als job
        try {
            User user = new User("Bart Waterslagers", "      ", new File("BartWaterslagers.jpg"));

            user.display();
        }
        catch ( UserException ex ) {
            System.out.print("Met enkel spaties als job: \t");
            System.out.println(ex.toString());
        }

        // Met een lege string als job
        try {
            User user = new User("Bart Waterslagers", "", new File("BartWaterslagers.jpg"));

            user.display();
        }
        catch ( UserException ex ) {
            System.out.print("Met een lege string als job: \t");
            System.out.println(ex.toString());
        }

        // Met null als value voor job
        try {
            User user = new User("Bart Waterslagers", null, new File("BartWaterslagers.jpg"));

            user.display();
        }
        catch ( UserException ex ) {
            System.out.print("Met null als value voor job: \t");
            System.out.println(ex.toString());
        }

        // Met null als value voor de File parameter
        try {
            User user = new User("Bart Waterslagers", "loodgieter", null);

            user.display();
        }
        catch ( UserException ex ) {
            System.out.print("Met null als value voor de File parameter: \t");
            System.out.println(ex.toString());
        }

        System.out.println("------------------------EINDE VAN EXCEPTION CHECKING------------------------\n");

        // Correcte users
        try {
            User user1 = new User("Marie Christine", "bediende", new File("MarieChristine.jpg"));

            user1.display();

            User user2 = new User("Bart Waterslagers", "loodgieter", new File("BartWaterslagers.jpg"));

            user2.display();

            User user3 = new User("Bart Peeters", "zanger", new File("BartPeeters.jpg"));

            user3.display();

            SortedSet<User> users = new TreeSet<>();

            users.add(user1);
            users.add(user2);
            users.add(user3);

            System.out.println("\n------------------------PRINTEN VAN TREESET------------------------\n");

            users.forEach(u -> u.display());

            System.out.println("\n------------------------EXCEPTION CHECKING VAN MESSAGEPOSTS------------------------\n");

            // Met enkel spaties als message
            try {
                MessagePost messagePost = new MessagePost(user1, "      ");;

                messagePost.display();
            }
            catch ( PostException ex ) {
                System.out.print("Met enkel spaties als message: \t");
                System.out.println(ex.toString());
            }

            // Met een lege string als message
            try {
                MessagePost messagePost = new MessagePost(user1, "");;

                messagePost.display();
            }
            catch ( PostException ex ) {
                System.out.print("Met een lege string als message: \t");
                System.out.println(ex.toString());
            }

            // Met null als message
            try {
                MessagePost messagePost = new MessagePost(user1, null);;

                messagePost.display();
            }
            catch ( PostException ex ) {
                System.out.print("Met null als message: \t");
                System.out.println(ex.toString());
            }

            System.out.println("\n------------------------CORRECTE MESSAGEPOSTS------------------------\n");

            // Correcte MessagePost
            MessagePost messagePost1 = new MessagePost(user1, "Hello world");;

            messagePost1.display();

            // Een delay van 1 seconden tussen de aanmaaktijdstippen creëren
            Thread.sleep(1000);

            // Correcte MessagePost
            MessagePost messagePost2 = new MessagePost(user1, "Hello world2");;

            messagePost2.display();

            // Een delay van 1 seconden tussen de aanmaaktijdstippen creëren
            Thread.sleep(1000);

            System.out.println("\n------------------------CORRECTE COMMENTEDPOSTS------------------------\n");

            System.out.println("COMMENTEDPOST 1: ");
            // Correcte post met likes
            CommentedPost commentedPost1 = new CommentedPost(user2, "Bart Waterslagers Hello world");

            for (int i = 0; i < 10; i++) {
                commentedPost1.like();
            }

            for (int i = 0; i < 2; i++) {
                commentedPost1.unlike();
            }

            commentedPost1.display();

            // Een delay van 1 seconden tussen de aanmaaktijdstippen creëren
            Thread.sleep(1000);

            System.out.println("\nCOMMENTEDPOST 2: ");

            // Correcte post met een comment
            CommentedPost commentedPost2 = new CommentedPost(user2, "Hello world2");

            commentedPost2.addComment(new MessagePost(user1, "Marie hier, groeten"));

            commentedPost2.display();

            // Een delay van 1 seconden tussen de aanmaaktijdstippen creëren
            Thread.sleep(1000);

            System.out.println("\n------------------------EXCEPTION CHECKING EVENTPOSTS------------------------\n");

            // Met null als als parameter voor EventType
            try {
                EventPost eventPost = new EventPost(user3, null);
            }
            catch ( PostException ex ) {
                System.out.println("Met null als als parameter voor EventType: \t" + ex.toString());
            }

            System.out.println("\n------------------------CORRECTE EVENTPOSTS------------------------\n");

            EventPost eventPost1 = new EventPost(user3, EventType.OPTREDEN);

            eventPost1.display();

            // Een delay van 1 seconden tussen de aanmaaktijdstippen creëren
            Thread.sleep(1000);

            System.out.println("\n------------------------EXCEPTION CHECKING PHOTOPOST------------------------\n");

            // Met null als parameter voor filename
            try {
                PhotoPost photoPost = new PhotoPost(user3, null, "Mijn eerste foto op Social Network");
            }
            catch ( PostException ex ) {
                System.out.println("Met null als parameter voor filename: \t" + ex.toString());
            }

            // Met enkel spaties als parameter voor caption
            try {
                PhotoPost photoPost = new PhotoPost(user3, new File("MijnFoto.jpg"), "        ");
            }
            catch ( PostException ex ) {
                System.out.println("Met enkel spaties als parameter voor caption: \t" + ex.toString());
            }

            // Met een lege string als parameter voor caption
            try {
                PhotoPost photoPost = new PhotoPost(user3, new File("MijnFoto.jpg"), "");
            }
            catch ( PostException ex ) {
                System.out.println("Met een lege string als parameter voor caption: \t" + ex.toString());
            }

            // Met null als parameter voor caption
            try {
                PhotoPost photoPost = new PhotoPost(user3, new File("MijnFoto.jpg"), null);
            }
            catch ( PostException ex ) {
                System.out.println("Met null als parameter voor caption: \t" + ex.toString());
            }

            System.out.println("\n------------------------CORRECTE PHOTOPOSTS------------------------\n");

            PhotoPost photoPost1 = new PhotoPost(user3, new File("MijnFoto.jpg"), "Mijn eerste foto op Social Network");

            photoPost1.display();

            System.out.println("\n------------------------NEWSFEED------------------------\n");

            NewsFeed newsfeed1 = new NewsFeed();

            newsfeed1.addPost(messagePost1);
            newsfeed1.addPost(messagePost2);
            newsfeed1.addPost(commentedPost1);
            newsfeed1.addPost(commentedPost2);
            newsfeed1.addPost(eventPost1);
            newsfeed1.addPost(photoPost1);

            newsfeed1.show();
            
            // Een delay van 1 minuut maken voor het controleren van de display method van de voor timestamp
            System.out.println("GOING IN TO SLEEP FOR 30 SECONDS TO CONFIRM DISPLAY METHOD");
            Thread.sleep(30 * 1000);

            System.out.println("\n------------------------WERKEN MET EEN SET------------------------\n");

            Set<Post> postsSet = new HashSet<>();

            postsSet.addAll(newsfeed1.getPosts());

            postsSet.forEach(p -> {
                p.display();
                System.out.println();
            });
            
            // Een delay van 1 minuut maken voor het controleren van de display method van de voor timestamp
            System.out.println("GOING IN TO SLEEP FOR 30 SECONDS TO CONFIRM DISPLAY METHOD");
            Thread.sleep(30 * 1000);

            System.out.println("\n------------------------WEGSCHRIJVEN EN INLEZEN VAN NEWSFEED------------------------\n");

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("posts.dat"));) {
                oos.writeObject(newsfeed1);
            }
            catch ( IOException ex ) {
                System.out.println(ex.toString());
            }

            // Inlezen en weergeven van newsfeed
            NewsFeed newsfeed2 = new NewsFeed();

            try (FileInputStream fis = new FileInputStream("posts.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);) {
                newsfeed2 = (NewsFeed) ois.readObject();
            }
            catch ( Exception ex ) {
                System.out.println(ex.toString());
            }

            newsfeed2.show();

        }
        catch ( UserException | PostException | InterruptedException ex ) {
            System.err.println(ex.toString());
        }

    }
}
