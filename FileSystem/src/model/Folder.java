package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class that represents a Folder by its name, creation date, last modification date and read only property, inner
 * folder list and file list
 */
public class Folder extends FileSystem {
    /**
     * Folder's inner folder list
     */
    private List<Folder> innerFolders;
    /**
     * Folder's file list
     */
    private List<File> fileList;

    /**
     * Complete Folder constructor
     *
     * @param name         Folder's name
     * @param creationDate Folder's creation date
     * @param lastModified Folder's last modification date
     * @param readOnly     Folder's read only property (true if it is read only, false if not)
     * @param innerFolders Folder's inner folders
     * @param fileList     Folder's file list
     */
    public Folder(String name, Date creationDate, Date lastModified, boolean readOnly, List<Folder> innerFolders,
                  List<File> fileList) {
        super(name, creationDate, lastModified, readOnly);
        this.innerFolders = innerFolders;
    }

    /**
     * Constructor included to instantiate complete Folder objects
     *
     * @param name         Folder's name
     * @param readOnly     true if the folder is available for read only, false if not
     * @param innerFolders Folder's inner folders
     * @param fileList     Folder's files
     */
    public Folder(String name, boolean readOnly, List<Folder> innerFolders, List<File> fileList) {
        super(name, readOnly);
        this.innerFolders = innerFolders;
        this.fileList = fileList;
    }

    /**
     * When a folder is created, it has nothing inside it, therefore, it is only created indicating its name
     *
     * @param name Folder's name
     */
    public Folder(String name) {
        super(name);
        this.innerFolders = new ArrayList<>();
        this.fileList = new ArrayList<>();
    }

    /**
     * Method used to get the Folder's inner folders
     *
     * @return Folder's inner folders
     */
    public List<Folder> getInnerFolders() {
        return this.innerFolders;
    }

    /**
     * Method used to get the Folder's file list
     *
     * @return Folder's file list
     */
    public List<File> getFileList() {
        return this.fileList;
    }

    /**
     * Method used to add a folder to the Folder's inner folder list
     *
     * @param folder the folder to add
     * @return true if the addition is succeeded, false if not
     * @throws Exception exception thrown if the Folder's available for read only
     */
    public boolean addInnerFolder(Folder folder) throws Exception {
        checkIfReadOnly();
        modified();
        return this.innerFolders.add(folder);
    }

    /**
     * Method used to remove a folder from the Folder's inner folder list
     *
     * @param folder the folder to be removed
     * @return true if the removal is succeeded, false if not
     * @throws Exception exception thrown if the Folder's available for read only
     */
    public boolean deleteInnerFolder(Folder folder) throws Exception {
        checkIfReadOnly();
        if (!this.innerFolders.remove(folder)) {
            throw new Exception(folder.getName() + " does not exist inside " + this.getName());
        } else {
            modified();
            return true;
        }
    }

    /**
     * Method used to add a File to the Folder's file list
     *
     * @param file File to be added to the Folder's file list
     * @return true if the addition is succeeded, false if not
     * @throws Exception exception thrown if the Folder's available for read only
     */
    public boolean addFile(File file) throws Exception {
        checkIfReadOnly();
        modified();
        return this.fileList.add(file);
    }

    /**
     * Method used to remove a file from the Folder's file list
     *
     * @param file file to be removed from the Folder's file list
     * @return true if the removal is succeeded, false if not
     * @throws Exception exception thrown if the Folder's available for read only
     */
    public boolean removeFile(File file) throws Exception {
        checkIfReadOnly();
        if (!this.fileList.remove(file)) {
            throw new Exception(file.getName() + " does not exist inside " + this.getName());
        } else {
            modified();
            return true;
        }
    }
}