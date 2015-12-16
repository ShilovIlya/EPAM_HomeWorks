package javase02.t03;


import java.util.ArrayList;

public class BeginnerSet {
      private ArrayList<OfficeGoods> beginnerSet = new ArrayList<OfficeGoods>();

    public BeginnerSet(){
        beginnerSet.add(new Pen(50, "BLACK", "BALLPOINT"));
        beginnerSet.add(new Pencil(37, "BLACK", "M"));
        beginnerSet.add(new CopyBook(120, 48, "ALGEBRA"));
        beginnerSet.add(new Diary(170, 30, "SCHOOL"));
        beginnerSet.add(new DrawingPad(250, 48, "ART SCHOOL"));
        beginnerSet.add(new Pen(45, "RED", "BALLPOINT"));
        beginnerSet.add(new Pen(48, "BLUE", "BALLPOINT"));
        beginnerSet.add(new Pen(70, "BLACK", "GEL"));
        beginnerSet.add(new Pencil(37, "BLACK", "H"));
        beginnerSet.add(new Diary(200, 180, "PERSONAL"));
        beginnerSet.add(new CopyBook(110, 36, "ENGLISH"));
        beginnerSet.add(new DrawingPad(200, 90, "SKETCHES"));
    }

    public ArrayList<OfficeGoods> getBeginnerSet() {
        return beginnerSet;
    }

    public void printSet(){
        for (OfficeGoods officeGoods: beginnerSet){
            System.out.println(officeGoods);
        }
    }
}
