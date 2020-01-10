package controller;

import model.File;

import java.util.Date;

/**
 * File class controller
 */
public class FileController extends BaseController {

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
     * Method used to change the indicated File's name
     *
     * @param file File to be renamed
     * @param name new File's name
     * @return the renamed File
     * @throws Exception exception thrown if the name indicated is empty
     */
    public File changeFileName(File file, String name) throws Exception {
        validateName(name);
        if (file.getName().equals(name)) {
            throw new Exception("The name given matches the file's name!");
        }
        file.changeName(name);
        return file;
    }

    /**
     * Method used to change the indicated File's read only property
     *
     * @param file     File to be altered
     * @param readOnly new read only property
     * @return the altered File
     * @throws Exception exception thrown if the File's read only property is already set as the value given
     */
    public File setReadOnly(File file, boolean readOnly) throws Exception {
        if (file.isReadOnly() == readOnly) {
            throw new Exception("The file's read only property is already set as " + readOnly + "!");
        }
        file.setReadOnly(readOnly);
        return file;
    }

}
