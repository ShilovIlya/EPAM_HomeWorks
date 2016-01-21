package javase10.t02;

public class DAOLibraryException extends Exception {

    private String message;
    private Exception parent;

    public DAOLibraryException(String message, Exception e) {
        this.message = message;
        this.parent = e;
    }

    public DAOLibraryException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public void printStackTrace() {
        parent.printStackTrace();
    }


}
