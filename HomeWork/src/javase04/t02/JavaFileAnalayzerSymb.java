package javase04.t02;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Прочитайте файл, содержащий код на языке Java.
 * Определите, какие ключевые слова языка Java это код содержит.
 * Выведите эти слова и их количество в другой файл.
 * Используйте только символьные потоки ввода-вывода.
 */
public class JavaFileAnalayzerSymb {
    private static String [] words = new String[]{ "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};

    private static int [] wordsCount = new int[words.length];

    public static void updateWordsCount(String str) {

        for (int i = 0; i < words.length; i++) {

            Pattern pattern = Pattern.compile(words[i]);
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                wordsCount[i]++;
            }

        }

    }

    public static void main(String[] args) {

        try (FileReader file = new FileReader("src\\javase03\\t03\\RegexpTask.java")){

            BufferedReader inFile = new BufferedReader(file);

            String str;

            while ((str = inFile.readLine()) != null) {
                updateWordsCount(str);
            }

            try (FileWriter outFile = new FileWriter("src\\resources\\SymbRegexpTaskWordsCount.txt")) {

                for (int i = 0; i < words.length; i++) {
                    if ( wordsCount[i] != 0 ) {
                        String s = words[i] + " " + wordsCount[i] + "\n";
                        outFile.write(s);
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
