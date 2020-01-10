package controller;

import model.FileSystem;

public class BaseController {

    /**
     * Method used to validate the name to be given to the object
     *
     * @param name object's name
     * @throws Exception exception thrown if the name indicated is empty
     */
    public void validateName(String name) throws Exception {
        if (name.isEmpty()) throw new Exception("The name can not be empty!");
    }

    /**
     * Method used to check if the object is read only
     * @param object object to be checked
     * @return true if the object is read only, false if it isn't
     */
    public boolean checkIfReadOnly(Object object) {
        FileSystem fileSystem = (FileSystem) object;
        return fileSystem.isReadOnly();
    }

}
