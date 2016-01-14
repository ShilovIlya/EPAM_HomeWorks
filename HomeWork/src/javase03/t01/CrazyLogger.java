package javase03.t01;


import java.util.Calendar;
import java.util.Formatter;

/*
Необходимо создать класс CrazyLogger, ведущий журнал лога,
используя как накопитель объект типа StringBuilder.
Логгер должен содержать методы поиска определенной информации в таком логе
[с возможностью вывода ее в поток ввода вывода].
Информацию логгер хранит в форматированном виде: dd-mm-YYYY : hh-mm – message;.
*/

/**
 * The <code>CrazyLogger</code> class is logger.
 * It contains messages in <code>logs</code> in format: dd-mm-YYYY : hh-mm - message.
 * Methods:
 * Add new message - <code>addMessage</code>;
 * Print all logs - <code>printLogs</code>;
 * Search message by time - <code>search</code>;
 */
public class CrazyLogger {

    private StringBuilder logs;

    public CrazyLogger() {
        logs = new StringBuilder();
    }

    /**
     * Add time and message to logs in format: dd-mm-YYYY : hh-mm - message
     * @param message
     */
    public void addMessage(String message) {

        Calendar calendar = Calendar.getInstance();
        Formatter formatter = new Formatter();
        formatter.format("%td-", calendar);
        formatter.format("%tM-", calendar);
        formatter.format("%tY : ", calendar);
        formatter.format("%tH-", calendar);
        formatter.format("%tM - ", calendar);

        logs.append(formatter);
        logs.append(message);
        logs.append(";");

    }

    /**
     * print all message from logs
     */
    public void printLogs() {

        System.out.println("In logs:");
        System.out.println(logs);
        System.out.println("End");

    }


    /**
     * @param time message time
     * @return first message with equal time
     */
    public String search(String time) {

        int start = logs.indexOf(time);
        System.out.println("start = " + start);
        int end = logs.indexOf(";", start);
        System.out.println("end = " + end);
        return logs.substring(start, end + 1);

    }

}
