package javase02.t04;

import javase02.t03.*;
import java.util.Comparator;

public class OfficeGoodsComparatorByPrice implements Comparator<OfficeGoods> {
    public int compare(OfficeGoods og1, OfficeGoods og2) {
        if (og1.getPrice() < og2.getPrice()) {
            return -1;
        } else if (og1.getPrice() == og2.getPrice()) {
            return 0;
        } else {
            return 1;
        }
    }
}
