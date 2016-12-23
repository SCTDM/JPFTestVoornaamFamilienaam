package be.vdab.post;

import be.vdab.person.User;
import be.vdab.util.PostException;
import java.io.File;

/**
 *
 * @author simon.chaffart
 */
public final class PhotoPost extends Post{
    private File filename;
    private String caption;

    public PhotoPost(User user, File filename, String caption) throws PostException
    {
        super(user);
        setFilename(filename);
        setCaption(caption);
    }

    public File getFilename()
    {
        return filename;
    }

    public final void setFilename(File filename) throws PostException
    {
        if (filename != null) {
        this.filename = filename;
        }
        else {
            throw new PostException("Filename mag niet null zijn");
        }
    }

    public String getCaption()
    {
        return caption;
    }

    public final void setCaption(String caption) throws PostException
    {
        if (caption != null && !caption.trim().isEmpty()) {
        this.caption = caption;
        }
        else if (caption == null) {
            throw new PostException("De caption mag niet null zijn");
        }
        else if (caption.isEmpty()) {
            throw new PostException("De caption mag niet leeg zijn");
        }
        else {
            throw new PostException("De caption mag niet enkel spaties bevatten");
        }
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("PHOTO: " + filename + " " + caption);
    }
    
    
}
