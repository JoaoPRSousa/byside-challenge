package model;

import java.util.Date;

public abstract class FileSystem {
    /*
     * FileSystem's name
     */
    private String name;
    /*
     * FileSystem's creation date
     */
    private Date creationDate;
    /*
     * FileSystem's last modification date
     */
    private Date lastModified;
    /*
     * FileSystem's read only property
     */
    private boolean readOnly;

    /**
     * Complete FileSystem constructor
     *
     * @param name         FileSystem's name
     * @param creationDate FileSystem's creation date
     * @param lastModified FileSystem's last modification date
     * @param readOnly     FileSystem's read only property (true if it is read only, false if not)
     */
    public FileSystem(String name, Date creationDate, Date lastModified, boolean readOnly) {
        this.name = name;
        this.creationDate = creationDate;
        this.lastModified = lastModified;
        this.readOnly = readOnly;
    }

    /**
     * FileSystem constructor where the name and the read only property are indicated
     *
     * @param name     FileSystem's name
     * @param readOnly FileSystem's read only property
     */
    public FileSystem(String name, boolean readOnly) {
        this.name = name;
        this.readOnly = readOnly;
    }

    /**
     * FileSystem constructor where only the name is indicated
     *
     * @param name FileSystem's name
     */
    public FileSystem(String name) {
        this.name = name;
        creationDate = new Date(System.currentTimeMillis());
        lastModified = creationDate;
        this.readOnly = false;
    }

    /**
     * Method that return the FileSystem's name
     *
     * @return FileSystem's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method that returns the FileSystem's creation date
     *
     * @return FileSystem's creation date
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Method that returns the FileSystem's last modification date
     *
     * @return FileSystem's last modification date
     */
    public Date getLastModified() {
        return this.lastModified;
    }

    /**
     * Method that returns the FileSystem's read only property
     *
     * @return true if the FileSystem's available for read only, false if not
     */
    public boolean isReadOnly() {
        return this.readOnly;
    }

    /**
     * Method used to change the FileSystem's name
     *
     * @param name new name
     * @throws Exception exception thrown if the name given is empty
     */
    public void changeName(String name) throws Exception {
        if (name.isEmpty()) {
            throw new Exception("The " + this.getClass().toString().toLowerCase() + " name can not be empty!");
        }
        this.name = name;
        modified();
    }

    /**
     * Method used to change the FileSystem's read only property
     *
     * @param readOnly new read only setting (true/false)
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
        modified();
    }

    /**
     * Method used to check if the FileSystem's read only
     *
     * @throws Exception exception throw if the FileSystem's available for read only
     */
    public void checkIfReadOnly() throws Exception {
        if (this.readOnly) {
            throw new Exception("The " + this.getClass().toString().toLowerCase() + " is available for read only!");
        }
    }

    /**
     * Method used to update the FileSystem's last modification date
     */
    public void modified() {
        this.lastModified = new Date(System.currentTimeMillis());
    }
}
