package javase04.t04;

import java.io.*;
import java.util.Scanner;

/**
 * Дана коллекция фильмов, содержащая информацию об актерах,
 * снимавшихся в главных ролях (один актер мог сниматься и в нескольких фильмах).
 * Необходимо написать приложение, позволяющее при запуске восстанавливать коллекцию фильмов,
 * позволять ее модифицировать, а по завершении работы приложения – сохранять (в файл).
 * Для восстановления/сохранения коллекции использовать  сериализацию/десериализацию.
 */
public class FilmSerializable {

    public static FilmCollection filmCollection;

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Hello");
        printControlKeys();
        boolean exit = false;
        String input;
        do {
            System.out.println("Enter command:");
            input = sc.nextLine();
            switch (input) {
                case "exit":
                    exit = true;
                    break;
                case "add":
                    addFilm();
                    break;
                case "delete":
                    deleteFilm();
                    break;
                case "info":
                    printControlKeys();
                    break;
                case "print":
                    printFilms();
                    break;
                case "openCollection":
                    openFilmCollection();
                    break;
                case "save":
                    saveFilmCollection();
                    break;
            }
        } while(!exit);

    }

    private static void printFilms() {
        filmCollection.printFilms();
    }

    private static void deleteFilm() {
        System.out.println("Please, write name");
        if (!filmCollection.removeFilm(sc.nextLine())) {
            System.out.println("Wrong name");
        }
    }

    private static void addFilm() {

        System.out.println("Please, write name");
        String filmName = sc.nextLine();

        System.out.println("Please, write the number of actors");
        int numActors = sc.nextInt();
        String [] actors = new String [numActors];

        System.out.println("Please, write actors names");
        int index = 0;
        while ((sc.hasNext()) && (index < numActors)) {
            actors[index] = sc.next();
            index++;
        }

        filmCollection.addFilm(filmName, actors);

    }

    public static void printControlKeys(){
        System.out.println("Help:");
        System.out.println("exit - finish work\ninfo - show help");
        System.out.println("add - add new film");
        System.out.println("delete - delete film");
        System.out.println("print - print films");
        System.out.println("open - open created collection or create new");
        System.out.println("save - save collection");
    }


    public static void saveFilmCollection() {

        String fileName = "src\\resources\\serialFilmCollection";
        try ( ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream(fileName))) {

            output.writeObject(filmCollection);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void openFilmCollection() {

        String fileName = "src\\resources\\serialFilmCollection";


        try ( ObjectInputStream output =
                      new ObjectInputStream(new FileInputStream(fileName))) {

            filmCollection = (FilmCollection) output.readObject();

        } catch (FileNotFoundException e) {

            filmCollection = new FilmCollection();
            saveFilmCollection();
            openFilmCollection();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
