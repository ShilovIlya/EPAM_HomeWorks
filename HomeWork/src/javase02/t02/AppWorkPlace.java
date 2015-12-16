package javase02.t02;

import java.util.ArrayList;
import java.util.Scanner;

public class AppWorkPlace {
    private static ArrayList<WorkPlace> workers = new ArrayList<WorkPlace>();
    private static String currentWorker;

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
            } else if (input.equals("new worker")) {
                newWorker();
            } else if (input.equals("select worker")) {
                changeWorker();
            } else if (input.equals("info")) {
                printControlKeys();
            } else if (input.equals("new item")) {
                newItem();
            } else if (input.equals("sum")) {
                System.out.println("Sum price " + currentWorker + "'s work place = " + printSumPrice());
            }
        } while(!exit);

    }

    public static int printSumPrice(){
        for (WorkPlace workPlace: workers){
            if (currentWorker.equals(workPlace.getWorkerName())){
                return workPlace.sumPrice();
            }
        }
        return 0;
    }


    public static void workerAddItem(String itemName){
        for (WorkPlace workPlace: workers){
            if (currentWorker.equals(workPlace.getWorkerName())){
                workPlace.addItem(itemName);
            }
        }
    }

    public static void newItem(){
        boolean goodItemFlag = false;
        System.out.println("Write an item from the list:");
        WorkPlace.printOptions();

        do {
            String itemName = sc.nextLine();
            for (String option: WorkPlace.options){
                if (itemName.equals(option)) {
                    workerAddItem(itemName);
                    goodItemFlag = true;
                }
            }
            if (itemName.equals("exit")){
                break;
            }
            if (!goodItemFlag){
                System.out.println("Wrong item. Please write exit or item from the list");
            }
        } while ( !goodItemFlag );
    }

    public static void changeWorker(){
        System.out.println("Please write a name from the list:");
        boolean badName = true;
        for (WorkPlace wp: workers){
            System.out.println(wp.getWorkerName());
        }
        do {
            String name = sc.nextLine();
            for (WorkPlace wp: workers){
                if (name.equals(wp.getWorkerName())){
                    currentWorker = name;
                    badName = false;
                }
            }
            if (name.equals("exit")){
                badName = false;
            }
            if (badName){
                System.out.println("Wrong name. Please write exit or a name from the list");
            }
        } while (badName);
    }

    public static void newWorker(){
        System.out.println("Write worker name");
        String name = sc.nextLine();
        workers.add(new WorkPlace(name));
        System.out.println(name + " added to workers");
    }

    public static void printControlKeys(){
        System.out.println("Help:");
        System.out.println("exit - finish work\ninfo - show help");
        System.out.println("new worker - create new worker\n select worker - choose current worker");
        System.out.println("new item - add new item to work place");
        System.out.println("sum - print total price of worker place");
    }

}
