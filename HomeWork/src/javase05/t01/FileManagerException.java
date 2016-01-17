package javase05.t01;

/**
 * Created with IntelliJ IDEA.
 * User: Ilya
 * Date: 15.01.16
 */
public class FileManagerException extends Exception {

    private String message;

    FileManagerException(String message) {
        this.message = message;
    }

    public String toString() {
        return "Exception in " + message;
    }


}
