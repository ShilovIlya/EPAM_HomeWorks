package javase02.t04;

import javase02.t03.*;
import java.util.Comparator;

public class OfficeGoodsComparatorByName implements Comparator<OfficeGoods> {
    public int compare(OfficeGoods og1, OfficeGoods og2) {
        String name1 = String.valueOf(og1.getClass());
        String name2 = String.valueOf(og2.getClass());
        return name1.compareTo(name2);
    }
}
