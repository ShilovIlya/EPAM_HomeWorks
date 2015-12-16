package javase02.test.t04;

import javase02.t04.*;
import javase02.t03.*;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class OfficeGoodsComparatorTest {
    @Test
    public void ComparatorByPriceTest(){
        BeginnerSet bg = new BeginnerSet();
        System.out.println("\nBeginner set before compare by price\n");
        bg.printSet();

        Comparator<OfficeGoods> comparator = new OfficeGoodsComparatorByPrice();
        Collections.sort(bg.getBeginnerSet(), comparator);

        System.out.println("\nBeginner set after compare by price\n");

        bg.printSet();
    }

    @Test
    public void ComparatorByNameTest(){
        BeginnerSet bg = new BeginnerSet();
        System.out.println("\nBeginner set before compare by name\n");
        bg.printSet();

        Comparator<OfficeGoods> comparator = new OfficeGoodsComparatorByName();
        Collections.sort(bg.getBeginnerSet(), comparator);

        System.out.println("\nBeginner set after compare by name\n");
        bg.printSet();
    }

    @Test
    public void ComparatorByPriceAndNameTest(){
        BeginnerSet bg = new BeginnerSet();
        System.out.println("\nBeginner set before compare by price and name\n");
        bg.printSet();

        Comparator<OfficeGoods> comparator = new OfficeGoodsComparatorByPriceAndName();
        Collections.sort(bg.getBeginnerSet(), comparator);

        System.out.println("\nBeginner set after compare by price and name\n");
        bg.printSet();
    }
}
