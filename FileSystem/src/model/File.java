package model;

import java.util.Date;

/**
 * Class that represents a File by its name, creation date, last modification date and read only property
 */
public class File extends FileSystem {

    /**
     * Complete File constructor
     *
     * @param name         File's name
     * @param creationDate File's creation date
     * @param lastModified File's last modification date
     * @param readOnly     File's read only property (true if it is read only, false if not)
     */
    public File(String name, Date creationDate, Date lastModified, boolean readOnly) {
        super(name, creationDate, lastModified, readOnly);
    }

    /**
     * File constructor where the name and the read only property are indicated
     *
     * @param name     File's name
     * @param readOnly File's read only property
     */
    public File(String name, boolean readOnly) {
        super(name, readOnly);
    }

    /**
     * File constructor where only the name is indicated
     *
     * @param name File's name
     */
    public File(String name) {
        super(name);
    }

}