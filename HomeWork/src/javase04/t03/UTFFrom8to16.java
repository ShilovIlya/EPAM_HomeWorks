package javase04.t03;

import java.io.*;

/**
 * Дан файл, содержащий буквы текст на кириллице. Кодировка файла utf-8.
 * Прочитайте информацию из файла и перепишите ее в файл в кодировкой utf-16.
 */
public class UTFFrom8to16 {

    public static void main(String[] args) {

        String inputFileName = "src\\resources\\8.txt";
        String outputFileName = "src\\resources\\16.txt";

        try (BufferedReader inFile = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName), "UTF8"))) {

            String s;
            try (BufferedWriter outFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName), "UTF16"))) {
                while ((s = inFile.readLine()) != null) {
                    outFile.write(s);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
