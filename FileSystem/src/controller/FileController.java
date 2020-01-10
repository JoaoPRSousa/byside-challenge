package controller;

import model.File;

import java.util.Date;

/**
 * File class controller
 */
public class FileController {

    /**
     * Method used to create a complete File
     *
     * @param name         File's name
     * @param creationDate File's creation date
     * @param lastModified File's last modification date
     * @param readOnly     File's read only property
     * @return the created File
     * @throws Exception exception thrown if the name indicated is empty
     */
    public File createFile(String name, Date creationDate, Date lastModified, boolean readOnly) throws Exception {
        validateName(name);
        return new File(name, creationDate, lastModified, readOnly);
    }

    /**
     * Method used to create a File indicating its name and read only property
     *
     * @param name     File's name
     * @param readOnly File's read only property
     * @return the created File
     * @throws Exception exception thrown if the name indicated is empty
     */
    public File createReadOnlyFile(String name, boolean readOnly) throws Exception {
        validateName(name);
        return new File(name, readOnly);
    }

    /**
     * Method used to create a File indicating only its name
     *
     * @param name File's name
     * @return the created File
     * @throws Exception exception thrown if the name indicated is empty
     */
    public File createSimpleFile(String name) throws Exception {
        validateName(name);
        return new File(name);
    }

    /**
     * Method used to validate the name to be given to the File
     *
     * @param name File's name
     * @throws Exception exception thrown if the name indicated is empty
     */
    private void validateName(String name) throws Exception {
        if (name.isEmpty()) throw new Exception("The file's name can not be empty!");
    }

}
