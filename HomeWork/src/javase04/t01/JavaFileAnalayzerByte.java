package javase04.t01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Прочитайте файл, содержащий код на языке Java.
 * Определите, какие ключевые слова языка Java это код содержит.
 *
 * Ключевые слова языка Java:
 *
 * abstract, assert, boolean, break, byte, case, catch, char, class, const,
 * continue, default, do, double, else, enum, extends, final, finally, float,
 * for, goto, if, implements, import, instanceof, int, interface, long, native,
 * new, package, private, protected, public, return, short, static, strictfp, super,
 * switch, synchronized, this, throw, throws, transient, try, void, volatile, while
 *
 * Выведите эти слова и их количество в другой файл.
 * Используйте только байтовые потоки ввода-вывода.
 */
public class JavaFileAnalayzerByte {

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



        try (FileInputStream inFile = new FileInputStream("src\\javase03\\t03\\RegexpTask.java")){

            System.out.println("Start ");

            int bytesAvailable = inFile.available();
            byte[] bytesRead = new byte[bytesAvailable];
            inFile.read(bytesRead);

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < bytesAvailable; i++) {
                stringBuilder.append((char)bytesRead[i]);
                if ((char)bytesRead[i] == '\n') {
                    updateWordsCount(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
                System.out.print((char) bytesRead[i]);
            }

            try (FileOutputStream outFile = new FileOutputStream("src\\resources\\ByteRegexpTaskWordsCount.txt")) {

                for (int i = 0; i < words.length; i++) {
                    if ( wordsCount[i] != 0 ) {
                        String s = words[i] + " " + wordsCount[i] + "\n";
                        outFile.write(s.getBytes());
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
