package be.vdab.post;

import be.vdab.person.User;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author simon.chaffart
 */
public abstract class Post implements Comparable<Long>, Serializable {
    private final User user;
    private final Long timestamp;

    public Post(User user)
    {
        this.user = user;
        this.timestamp = System.currentTimeMillis();
    }

    public User getUser()
    {
        return user;
    }

    public Long getTimestamp()
    {
        return timestamp;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.timestamp);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }

        return Objects.equals(this.timestamp, other.timestamp);
    }

    @Override
    public int compareTo(Long other)
    {
        return -timestamp.compareTo(other); // - draait de sorteer volgorde om, zodat de laatste post (grootste getal) van voor wordt gesorteerd
    }

    public void display()
    {
        user.display();
        displayTimePassedSincePosting();
    }

    private void displayTimePassedSincePosting()
    {
        Long timePassedInMilliSeconds = System.currentTimeMillis() - timestamp;
        
        long seconds = TimeUnit.MILLISECONDS.toSeconds(timePassedInMilliSeconds);
        
        if (seconds < 60) {
            System.out.println(seconds + " second(s) ago");
        }
        else {
            long minutes = TimeUnit.MILLISECONDS.toMinutes(timePassedInMilliSeconds);
            System.out.println(minutes + " minute(s) ago");
        }
    }
}
