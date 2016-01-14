package javase03.test.t01;


import javase03.t01.CrazyLogger;
import org.junit.Test;

import java.util.Calendar;
import java.util.Formatter;

import static java.lang.Thread.sleep;

/*
Необходимо создать класс CrazyLogger, ведущий журнал лога,
используя как накопитель объект типа StringBuilder.
Логгер должен содержать методы поиска определенной информации в таком логе
[с возможностью вывода ее в поток ввода вывода].
Информацию логгер хранит в форматированном виде: dd-mm-YYYY : hh-mm – message;.
*/
public class CrazyLoggerTest {

    CrazyLogger crazyLogger = new CrazyLogger();

    @Test
    public void addMessageTest() {

        crazyLogger.addMessage("Happy New Year!");

    }

    @Test
    public void printLogsTest() {

        crazyLogger.addMessage("Add");
        crazyLogger.addMessage("some");
        crazyLogger.addMessage("message");
        crazyLogger.printLogs();

    }

    @Test
    public void searchTest() {

        crazyLogger.addMessage("Wow");

        Calendar calendar = Calendar.getInstance();
        Formatter formatter = new Formatter();
        formatter.format("%td-", calendar);
        formatter.format("%tM-", calendar);
        formatter.format("%tY : ", calendar);
        formatter.format("%tH-", calendar);
        formatter.format("%tM - ", calendar);

        String answer = crazyLogger.search(formatter.toString());

        System.out.println("Answer for searching is: " + answer);

    }

}
