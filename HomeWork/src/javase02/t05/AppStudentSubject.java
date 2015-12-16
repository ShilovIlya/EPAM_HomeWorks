package javase02.t05;

import java.util.ArrayList;
import java.util.Scanner;

public class AppStudentSubject {
    private static ArrayList<Subject> groups = new ArrayList<Subject>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Hello");
        printControlKeys();
        boolean exit = false;
        String input;
        do{
            System.out.println("Enter command:");
            input = sc.nextLine();
            if (input.equals("exit")) {
                exit = true;
            } else if (input.equals("group")) {
                newGroup();
            } else if (input.equals("student")) {
                studentInfo();
            } else if (input.equals("info")) {
                printControlKeys();
            }
        } while(!exit);

    }

    public static void newGroup(){
        boolean goodSubjectFlag = false;
        System.out.println("Write an item from the list:");
        Subject.printSubject();

        do {
            String groupSubject = sc.nextLine();
            try {
                SubjectName userSubjectName = SubjectName.valueOf(groupSubject);
                for (SubjectName subjectName: SubjectName.values()){
                    if (subjectName.equals(userSubjectName)) {
                        addGroup(userSubjectName);
                        System.out.println("New group, subject - " + userSubjectName);
                        goodSubjectFlag = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Wrong subject name");
            }
            if (groupSubject.equals("exit")){
                break;
            }
            if (!goodSubjectFlag){
                System.out.println("Wrong subject name. Please write exit or a name from the list");
            }
        } while ( !goodSubjectFlag );

        Subject subject = groups.get(groups.size() - 1);

        do {
            System.out.println("Please, write student's name and mark or exit");
            String name= sc.next();

            if (name.equals("exit")){
                break;
            }

            String mark = sc.next();
            subject.addStudent(name, mark);

        } while ( true );

        groups.set(groups.size() - 1, subject);
    }

    public static void addGroup(SubjectName userSubjectName){
        System.out.println("Please, write a type of subject's marks - Double or Integer");
        String markType = sc.nextLine();
        if (markType.equals("Double")){
            addSubject(Double.valueOf(1.2), userSubjectName);
        } else {
            addSubject(Integer.valueOf(4), userSubjectName);
        }
    }

    public static <SubjectType> void addSubject(SubjectType subjectType, SubjectName subjectName){
        switch (subjectName){
            case MATHEMATICAL_ANALYSIS:
                groups.add(new Subject<SubjectType>(SubjectName.MATHEMATICAL_ANALYSIS));
                break;
            case LINEAR_ALGEBRA:
                groups.add(new Subject<SubjectType>(SubjectName.LINEAR_ALGEBRA));
                break;
            case ENGLISH:
                groups.add(new Subject<SubjectType>(SubjectName.ENGLISH));
                break;
            case PHILOSOPHY:
                groups.add(new Subject<SubjectType>(SubjectName.PHILOSOPHY));
                break;
        }
    }

    public static void printControlKeys(){
        System.out.println("Help:");
        System.out.println("exit - finish work\ninfo - show help");
        System.out.println("group - create new group");
        System.out.println("student - print student's marks");
    }


    public static void studentInfo(){
        System.out.println("Please, write student's name");
        String name = sc.next();
        for (Subject subject: groups){
            if (subject.isStudentInGroup(name)){
                System.out.println(subject.getSubjectName() + " " + subject.getMark(name));
            }
        }
    }
}
