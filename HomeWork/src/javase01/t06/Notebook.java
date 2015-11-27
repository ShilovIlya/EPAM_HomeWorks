package javase01.t06;

import java.util.ArrayList;

/**
 * class for work with a notebook
 */
public class Notebook {
    private ArrayList<Note> notes;
    private String notebookName;

    /**
     * initialize name
     * @param name
     * the name of the notebook
     */
    public Notebook(String name){
        notes = new ArrayList<Note>();
        notebookName = name;
    }

    /**
     * Use default name = "myNotebook"
     */
    public Notebook(){
        this("myNotebook");
    }

    /**
     * add new note
     * @param newNote
     * new note
     */
    public void addNote(String newNote){
        notes.add(new Note(newNote));
    }

    /**
     * delete the note
     * @param pos
     * note's index
     */
    public void deleteNote(int pos){
        notes.remove(pos);
    }

    /**
     * edit the note
     * @param pos
     * note's index
     * @param newNode
     * new node's text
     */
    public void editNote(int pos, String newNode){
        notes.set(pos, new Note(newNode));
    }

    /**
     * print all nodes
     */
    public void lookAllNotes(){
       for (int i = 0; i < notes.size(); i++){
           System.out.println(notes.get(i));
       }
    }
}
