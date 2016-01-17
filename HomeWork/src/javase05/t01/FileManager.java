package javase05.t01;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ilya
 * Date: 14.01.16
 */
public class FileManager {

    private String fileName;
    private String filePath;
    private int strCount;

    private static Scanner sc = new Scanner(System.in);

    public FileManager(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
        strCount = 0;
    }


    public void work() throws FileManagerException{

        System.out.println("fileName is " + fileName + " and filePath is " + filePath);
        File file = new File(filePath + "/" + fileName);
        File tempFile = new File(filePath + "/temp_" + fileName);
        if (!file.isFile()) {
            try {
                System.out.println("Create new file");
                file.createNewFile();
            } catch (IOException e) {
                throw new FileManagerException("Create new file exception");
            }
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String str;

            int strNum = 0;
            while ((str = bufferedReader.readLine()) != null) {

                strNum++;
                System.out.println(strNum + " " + str);

            }

            strCount = strNum;

        } catch (IOException e) {
            throw new FileManagerException("Read file exception");
        }

        try (BufferedReader bufferedReader  = new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {


            System.out.println("To modify this file, please enter the line number");
            int lineNum = sc.nextInt();

            String str;
            int strNum = 1;

            if (strCount == 0) {

                strCount = 1;
                System.out.println("1 if + " + strCount);

                System.out.println("Please, enter new string");
                String newStr = sc.nextLine();
                newStr = sc.nextLine();
                System.out.println("You enter: " + newStr);

                bufferedWriter.write(newStr);
                bufferedWriter.newLine();

            } else {

                System.out.println("2 if + " + strCount);
                while (((str = bufferedReader.readLine()) != null)) {

                    if (strNum == lineNum) {

                        System.out.println("Please, enter new string");
                        String newStr = sc.nextLine();
                        newStr = sc.nextLine();
                        System.out.println("You enter: " + newStr);

                        bufferedWriter.write(newStr);
                        bufferedWriter.newLine();
                    } else {
                        bufferedWriter.write(str);
                        bufferedWriter.newLine();
                    }

                    strNum++;

                }
            }

            if (lineNum > strCount)  {
                strCount++;

                System.out.println("3 if + " + strCount + " line = " + lineNum);

                System.out.println("Please, enter new string");
                String newStr = sc.nextLine();
                newStr = sc.nextLine();
                System.out.println("You enter: " + newStr);

                bufferedWriter.write(newStr);
                bufferedWriter.newLine();
            }

            System.out.println("End of editing.");

        } catch (IOException e) {
            throw new FileManagerException("Write file exception");
        }

        file.delete();
        tempFile.renameTo(file);

    }

}
