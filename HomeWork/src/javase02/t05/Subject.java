package javase02.t05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Subject<T>{
    private Map<String, T> students = new HashMap<String, T>();
    private SubjectName subjectName;

    public Subject(SubjectName subjectName) {
        this.subjectName = subjectName;
    }

    public SubjectName getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(SubjectName subjectName) {
        this.subjectName = subjectName;
    }

    public void addStudent(String name, T mark){
        students.put(name, mark);
    }

    public T getMark(String name){
        return students.get(name);
    }

    public boolean isStudentInGroup(String name){
        return students.containsKey(name);
    }

    public static void printSubject(){
        for (SubjectName sn : SubjectName.values()){
            System.out.println(sn);
        }

    }
}
