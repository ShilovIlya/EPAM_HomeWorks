package javase03.t02;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Application with questions and answers.
 * First of all, you should choose localization - ru or en.
 * Than you choose question number.
 * And see answer.
 */
public class L10nQuestions {

    public static void main(String [] args) {

        Locale language;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, write language: ru or en");

        String lang = scanner.next();
        if (lang.equals("ru")) {
            language = new Locale("ru");
        } else {
            language = new Locale("en");
        }

        System.out.println();

        int questionCount = 5;

        ResourceBundle bundle = ResourceBundle.getBundle("resources.prop", language);

        System.out.println(bundle.getString("prop.key0"));

        for (int questionCounter = 1; questionCounter <= questionCount * 2 - 1; questionCounter += 2) {

            String key = "prop.key" + questionCounter;

            System.out.print(questionCounter / 2 + 1 + ") ");

            System.out.println(bundle.getString(key));

        }

        String questionStringNumber = scanner.next();
        Integer questionIntNumber = new Integer(questionStringNumber);
        questionIntNumber = questionIntNumber * 2;
        System.out.println(bundle.getString("prop.key" + questionIntNumber));

        scanner.close();
    }

}
