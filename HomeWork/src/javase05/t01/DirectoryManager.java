package javase05.t01;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Разработать приложение, позволяющее просматривать файлы и каталоги файловой системы,
 * а также создавать и удалять текстовые файлы.
 * Для работы с текстовыми файлами необходимо реализовать функциональность записи (дозаписи) в файл.
 * Требуется определить исключения для каждого слоя приложения и корректно их обработать.
 */
public class DirectoryManager {

    private static Scanner sc = new Scanner(System.in);

    private static File path;

    public static void main(String[] args) {

        path =  new File(".");

        System.out.println("Hello");


        try {
            info();
            showDirectory();

            boolean exit = false;
            String input;
            do {
                System.out.println("Enter command:");
                input = sc.nextLine();
                switch (input) {
                    case "exit":
                        exit = true;
                        break;
                    case "info":
                        info();
                        break;
                    case "directory":
                        showDirectory();
                        break;
                    case "parent":
                        parent();
                        break;
                    case "select":
                        selectDirectory();
                        break;
                    case "edit":
                        edit();
                        break;

                }
            } while(!exit);
        } catch (ControlKeyException e) {
            System.out.println(e.toString());
        }
    }

    private static void edit() throws ControlKeyException{

        System.out.println("Write file name");
        String fileName = sc.nextLine();

        Pattern pattern = Pattern.compile(".*\\.txt");
        Matcher matcher = pattern.matcher(fileName);

        try {
            if (matcher.matches()) {

                FileManager fileManager = new FileManager(fileName, path.getPath());
                fileManager.work();

            } else {
                throw new ControlKeyException("Wrong file name");
            }
        } catch (FileManagerException e) {
            throw new ControlKeyException("edit", e);
        }
    }

    private static void selectDirectory() throws ControlKeyException{

        System.out.println("Write directory name");
        String directoryName = sc.nextLine();
        try {
            path = new File(path.getPath() + "/" + directoryName);
        } catch (Exception e) {
            throw new ControlKeyException("Wrong directory name");
        }

        showDirectory();
    }

    private static void parent() throws ControlKeyException {

        try {
            if ((new File(path.getParent()).isDirectory())) {
                System.out.println(path.getParent());
                path = new File(path.getParent());
            } else {
                System.out.println(path.getParent());
                throw new ControlKeyException("Parent is not a directory");
            }

            showDirectory();

        } catch (Exception e) {
            throw new ControlKeyException("parent", e);
        }

    }

    public static void showDirectory(){

        String[] list;

        list = path.list();

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        for (String dirItem : list) {
            System.out.println(dirItem);
        }

    }

    public static void info(){
        System.out.println("Help:");
        System.out.println("exit - finish work\ninfo - show help");
        System.out.println("directory - show current directory");
        System.out.println("parent - go to the parent directory");
        System.out.println("select - select a directory");
        System.out.println("edit - edit (create if not exist) txt file");
    }

}
