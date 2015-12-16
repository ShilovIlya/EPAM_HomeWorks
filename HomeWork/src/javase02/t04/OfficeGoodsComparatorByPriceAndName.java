package javase02.t04;

import java.util.Comparator;
import javase02.t03.*;


public class OfficeGoodsComparatorByPriceAndName  implements Comparator<OfficeGoods> {
    public int compare(OfficeGoods og1, OfficeGoods og2) {
        String name1 = String.valueOf(og1.getClass());
        String name2 = String.valueOf(og2.getClass());
        int p1 = og1.getPrice();
        int p2 = og2.getPrice();
        if (name1.compareTo(name2) == 0){
            if (p1 < p2) {
                return -1;
            } else if (p1 == p2) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return name1.compareTo(name2);
        }
    }
}
