package javase05.t01;

/**
 * Created with IntelliJ IDEA.
 * User: Ilya
 * Date: 15.01.16
 */
public class ControlKeyException extends Exception {

    private String message;
    private Exception e;


    ControlKeyException(String message, Exception e) {
        this.message = message;
        this.e = e;
    }

    ControlKeyException(String message) {
        this.message = message;
        this.e = null;
    }

    public String toString() {
        if (e!= null) {
            return "Exception in " + message + "with message: " + e.toString();
        } else {
            return message;
        }
    }


}
