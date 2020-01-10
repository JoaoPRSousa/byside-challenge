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

    /**
     * Method used to copy / add a Folder to another
     *
     * @param folderToCopy Folder to be copied
     * @param folder       Folder to move the other Folder into
     * @return true if the copy is successful, false if not
     * @throws Exception exception thrown if the receiver Folder is available for read only
     */
    public boolean copyFolderToFolder(Folder folderToCopy, Folder folder) throws Exception {
        return folder.addInnerFolder(folderToCopy);
    }

    /**
     * Method used to move a Folder to another
     *
     * @param superFolder  Folder that contains the Folder to be moved
     * @param folderToMove Folder to be moved
     * @param folder       receiver Folder
     * @return true if the move is successful, false if not
     * @throws Exception exception thrown if any of the folders is available for read only
     */
    public boolean moveFolderToFolder(Folder superFolder, Folder folderToMove, Folder folder) throws Exception {
        if (checkIfReadOnly(superFolder) || checkIfReadOnly(folderToMove) || checkIfReadOnly(folder))
            throw new Exception("There are folders that can only be read!");

        if (!superFolder.getInnerFolders().remove(folderToMove))
            throw new Exception(folderToMove.getName() + " does not exist inside " + superFolder.getName() + "!");

        return folder.addInnerFolder(folder);
    }

    /**
     * Method used to copy / add a File to a Folder
     *
     * @param file   File to be copied
     * @param folder Folder to move the other File into
     * @return true if the copy is successful, false if not
     * @throws Exception exception thrown if the receiver Folder is available for read only
     */
    public boolean copyFileToFolder(File file, Folder folder) throws Exception {
        return folder.addFile(file);
    }

    /**
     * Method used to move a File from a Folder to another
     *
     * @param fileFolder     Folder that contains the File
     * @param file           File to be moved
     * @param receiverFolder receiver Folder
     * @return true if the move is successful, false if not
     * @throws Exception exception thrown if any of the objects can only be read
     */
    public boolean moveFile(Folder fileFolder, File file, Folder receiverFolder) throws Exception {
        if (checkIfReadOnly(fileFolder) || checkIfReadOnly(file) || checkIfReadOnly(receiverFolder))
            throw new Exception("There are objects that can only be read!");

        if (!fileFolder.getFileList().remove(file))
            throw new Exception(file.getName() + " does not exist inside " + fileFolder.getName() + "!");

        return receiverFolder.addFile(file);
    }

}
