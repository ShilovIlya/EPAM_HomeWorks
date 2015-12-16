package javase02.test.t03;

import javase02.t03.*;
import org.junit.Test;
import java.util.ArrayList;

public class OfficeGoodsTest {
    OfficeGoods officeGoods = new OfficeGoods(10);
    Paper paper = new Paper(100, 8);
    Writer writer = new Writer();
    Pen pen = new Pen("GEL");
    Pencil pencil = new Pencil(20, "RED");
    CopyBook copyBook = new CopyBook(200, 48, "Math");
    Diary diary = new Diary(150, 50, "School");
    DrawingPad drawingPad = new DrawingPad(300, 100, "Art school");

    @Test
    public void printOfficeGoods() throws Exception{
        System.out.println("officeGoods: "+ officeGoods +"\npaper: "+ paper +"\nwriter: "+ writer +"\npen: "+ pen +"\npencil: "+ pencil +
                "\ncopyBook: "+ copyBook +"\ndiary: "+ diary +"\ndrawingPad: "+ drawingPad);
    }

    @Test
    public void beginnerTest() {
        ArrayList<OfficeGoods> beginner = new ArrayList<OfficeGoods>();
        beginner.add(new Pen(30, "BLACK", "BALLPOINT"));
        beginner.add(new CopyBook(245, 48, "Java workbook"));
        System.out.println("Beginner:");
        for (OfficeGoods og: beginner){
            System.out.println(og);
        }
        System.out.println("----");
    }

    @Test
    public void beginnerSetTest() {
        System.out.println("Beginner set:");
        BeginnerSet beginnerSet = new BeginnerSet();
        beginnerSet.printSet();
        System.out.println("end");
    }


}
