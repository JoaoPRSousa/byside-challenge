package controller;

public class BaseController {

    /**
     * Method used to validate the name to be given to the File
     *
     * @param name File's name
     * @throws Exception exception thrown if the name indicated is empty
     */
    public void validateName(String name) throws Exception {
        if (name.isEmpty()) throw new Exception("The name can not be empty!");
    }

}
