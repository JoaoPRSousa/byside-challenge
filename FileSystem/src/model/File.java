package model;

import java.util.Date;

public class File {
    public String name;
    public Date creationDate;
    public Date lastModified;

    /**
     * Constructor for File objects
     * @param name File's name
     */
    public File(String name) {
        creationDate = new Date(System.currentTimeMillis());
        this.name = name;
        lastModified = creationDate;
    }
}