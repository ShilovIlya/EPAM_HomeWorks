package javase02.t02;

import javase02.t03.*;

import java.util.ArrayList;
import java.util.Scanner;

public class WorkPlace {
    public ArrayList<OfficeGoods> items = new ArrayList<OfficeGoods>();
    protected String workerName;
    public static String[] options = {"Pen","Pencil","CopyBook","Diary","DrawingPad"};
    public static Scanner scanner = new Scanner(System.in);

    public static void printOptions(){
        for (String opt: options){
            System.out.println(opt);
        }
    }
    WorkPlace(String name){
        workerName = name;
    }

    public String getWorkerName() {
        return workerName;
    }

    public int sumPrice(){
        int sum = 0;
        for (OfficeGoods officeGoods: items){
            sum += officeGoods.getPrice();
        }
        return sum;
    }


    public void addItem(String name){
        if (name.equals("Pen")) {
            addPen();

        } else if (name.equals("Pencil")) {
            addPencil();

        } else if (name.equals("CopyBook")) {
            addCopyBook();

        } else if (name.equals("Diary")) {
            addDiary();

        } else if (name.equals("DrawingPad")) {
            addDrawingPad();

        } else {
            System.out.println("Wrong item name. Please try again");
        }
    }

    protected void addPen(){
        System.out.println("Write color");
        String color = scanner.next();
        System.out.println("Write price");
        int price = scanner.nextInt();
        System.out.println("Write type of pen");
        String type = scanner.next();
        items.add(new Pen(price, color, type));
        System.out.println("New item in " + workerName + "'s work place:\n" + items.get(items.size() - 1));
    }

    protected void addPencil() {
        System.out.println("Write color");
        String color = scanner.next();
        System.out.println("Write price");
        int price = scanner.nextInt();
        System.out.println("Write hardness of pencil");
        String type = scanner.next();
        items.add(new Pencil(price, color, type));
        System.out.println("New item in " + workerName + "'s work place:\n" + items.get(items.size() - 1));
    }

    protected void addCopyBook(){
        System.out.println("Write a price");
        int price = scanner.nextInt();
        System.out.println("Write a number of pages");
        int pageCount = scanner.nextInt();
        System.out.println("Write a subject");
        String name = scanner.next();
        items.add(new CopyBook(price, pageCount, name));
        System.out.println("New item in " + workerName + "'s work place:\n" + items.get(items.size() - 1));
    }

    protected void addDiary(){
        System.out.println("Write a price");
        int price = scanner.nextInt();
        System.out.println("Write a number of pages");
        int pageCount = scanner.nextInt();
        System.out.println("Write a subject");
        String name = scanner.next();
        items.add(new Diary(price, pageCount, name));
        System.out.println("New item in " + workerName + "'s work place:\n" + items.get(items.size() - 1));
    }


    protected void addDrawingPad(){
        System.out.println("Write a price");
        int price = scanner.nextInt();
        System.out.println("Write a number of pages");
        int pageCount = scanner.nextInt();
        System.out.println("Write a subject");
        String name = scanner.next();
        items.add(new DrawingPad(price, pageCount, name));
        System.out.println("New item in " + workerName + "'s work place:\n" + items.get(items.size() - 1));
    }

}
