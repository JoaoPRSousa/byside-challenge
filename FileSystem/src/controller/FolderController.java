package controller;

import model.File;
import model.Folder;

import java.util.Date;
import java.util.List;

public class FolderController extends BaseController {

    /**
     * Method used to create a complete Folder
     *
     * @param name         Folder's name
     * @param creationDate Folder's creation date
     * @param lastModified Folder's last modification date
     * @param readOnly     Folder's read only property (true if it is read only, false if not)
     * @param innerFolders Folder's inner folders
     * @param fileList     Folder's file list
     * @return the created Folder
     * @throws Exception exception thrown if the name indicated is empty
     */
    public Folder createFolder(String name, Date creationDate, Date lastModified, boolean readOnly,
                             List<Folder> innerFolders, List<File> fileList) throws Exception {
        validateName(name);
        return new Folder(name, creationDate, lastModified, readOnly, innerFolders, fileList);
    }

    /**
     * Method used to create a Folder indicating its name and read only property
     *
     * @param name     Folder's name
     * @param readOnly Folder's read only property
     * @return the created Folder
     * @throws Exception exception thrown if the name indicated is empty
     */
    public Folder createReadOnlyFolder(String name, boolean readOnly) throws Exception {
        validateName(name);
        return new Folder(name, readOnly);
    }

    /**
     * Method used to create a Folder indicating only its name
     *
     * @param name Folder's name
     * @return the created Folder
     * @throws Exception exception thrown if the name indicated is empty
     */
    public Folder createSimpleFolder(String name) throws Exception {
        validateName(name);
        return new Folder(name);
    }

}
