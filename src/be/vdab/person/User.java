package be.vdab.person;

import be.vdab.util.UserException;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author simon.chaffart
 */
public final class User implements Comparable<User>, Serializable {
   private String username;
   private String job;
   private File profilephoto;
   private final LocalDate registrationdate;

    /** De waarden voor username, job en profilephoto moeten ingevuld zijn anders wordt er een PostException gethrowed
     * 
     * @param username String, mag niet null of leeg zijn
     * @param job String, mag niet null of leeg zijn
     * @param profilephoto File, mag niet null zijn
     * @throws UserException 
     */
    public User(String username, String job, File profilephoto) throws UserException
    {
        setUsername(username);
        setJob(job);
        setProfilephoto(profilephoto);
        registrationdate = LocalDate.now();
    }

    public String getUsername()
    {
        return username;
    }

    public final void setUsername(String username) throws UserException
    {
        if (username != null && !username.trim().isEmpty()) {
        this.username = username;
        }
        else if (username == null) {
            throw new UserException("De username mag niet null zijn");
        }
        else if (username.isEmpty()) {
            throw new UserException("De username mag niet leeg zijn");
        }
        else if (username.trim().isEmpty()) {
            throw new UserException("De username mag niet enkel spaties bevatten");
        }
    }

    public String getJob()
    {
        return job;
    }

    public final void setJob(String job) throws UserException
    {
        if (job != null && !job.trim().isEmpty()) {
        this.job = job;
        }
        else if (job == null) {
            throw new UserException("De job mag niet null zijn");
        }
        else if (job.isEmpty()) {
            throw new UserException("De job mag niet leeg zijn");
        }
        else {
            throw new UserException("De job mag niet enkel spaties bevatten");
        }
    }

    public File getProfilephoto()
    {
        return profilephoto;
    }

    public final void setProfilephoto(File profilephoto) throws UserException
    {
        if (profilephoto != null)  {
        this.profilephoto = profilephoto;
        }
        else {
            throw new UserException("Profilephoto mag niet null zijn");
        }
    }

    public LocalDate getRegistrationdate()
    {
        return registrationdate;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.registrationdate);
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
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        
        return Objects.equals(this.registrationdate, other.registrationdate);
    }

    @Override
    public int compareTo(User other)
    {
        return username.compareTo(other.username);
    }
    
    public void display() {
        System.out.println("Van " + username + " geregistreerd op " + registrationdate);
        System.out.println("\t" + profilephoto);
        System.out.println("\tJob: " + job);
    }

    @Override
    public String toString()
    {
        return username + ";" + job + ";" + profilephoto + ";" + registrationdate;
    }
    
}
