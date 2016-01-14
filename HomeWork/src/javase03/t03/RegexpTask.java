package javase03.t03;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Необходимо определить в тексте статьи* (html-файл),
    ссылается ли автор на рисунки последовательно или нет,
    а также выделить все предложения, в которых встречаются ссылки на рисунки.
    Для разбора текста использовать регулярные выражения.
*/
public class RegexpTask {

    public static void main(String []args) {

        try (InputStreamReader textFile = new InputStreamReader(new FileInputStream("src\\resources\\text.html"), "utf-8")) {

            BufferedReader text = new BufferedReader(textFile);

//            Pattern p = Pattern.compile("([\\u0410-\\u042F]*\\(\u0420\u0438\u0441\\s?.?\\s?(\\d+)\\).)");
            Pattern p = Pattern.compile("[ \\.]+([А-Я&&[^\\.]]+.+\\(\u0420\u0438\u0441\\s?.?\\s?(\\d+)\\)[^\\.]*\\.{1})");
            ArrayList<Integer> ref = new ArrayList<>(20);
            ArrayList<String> sent = new ArrayList<>(20);

            System.out.println("Start reading ");
            String str;
            while ((str = text.readLine()) != null) {
                Matcher m = p.matcher(str);
                if (m.find()) {
                    sent.add(m.group(1));
                    ref.add(new Integer(m.group(2)));
                }

                while (m.find()) {
                    ref.add(new Integer(m.group(2)));
                }

            }

            for (int i = 0; i < sent.size(); i++) {
                System.out.println(sent.get(i));
            }

            for (int i = 1; i < ref.size(); i++) {
                System.out.println("i-ая ссылка: " + ref.get(i));
                if (ref.get(i - 1) > ref.get(i)) {
                    System.out.print("Ссылки не последовательны");
                    break;
                }
                if (i == ref.size() - 1) {
                    System.out.println("Ссылки последовательны");
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
