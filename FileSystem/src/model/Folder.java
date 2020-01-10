package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Folder {
    private String name;
    private List<Folder> innerFolders;
    private List<File> fileList;
    private Date creationDate;
    private Date lastModified;
    private boolean readOnly;

    /**
     * Constructor included to instantiate complete Folder objects
     * @param name     Folder's name
     * @param folders  Folder's inner folders
     * @param fileList Folder's files
     * @param readOnly true if the folder is available for read only, false if not
     */
    public Folder(String name, List<Folder> folders, List<File> fileList, boolean readOnly) {
        creationDate = new Date(System.currentTimeMillis());
        this.name = name;
        innerFolders = folders;
        this.fileList = fileList;
        lastModified = creationDate;
        this.readOnly = readOnly;
    }

    /**
     * When a folder is created, it has nothing inside it, therefore, it is only created indicating its name
     * @param name Folder's name
     */
    public Folder(String name) {
        creationDate = new Date(System.currentTimeMillis());
        this.name = name;
        this.innerFolders = new ArrayList<>();
        this.fileList = new ArrayList<>();
        this.readOnly = false;
    }
}