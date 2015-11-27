package javase01.t06;


/**
 * Note class
 */
public class Note {
    private String note;

    /**
     *  empty note
     */
    Note(){
        note = "";
    }

    /**
     * @param s
     * note's text
     */
    Note(String s) {
        note = s;
    }
    public String toString(){
        return note;
    }
}
