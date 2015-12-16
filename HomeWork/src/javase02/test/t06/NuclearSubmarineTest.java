package javase02.test.t06;

import javase02.t06.NuclearSubmarine;
import org.junit.Test;

public class NuclearSubmarineTest {
    @Test
    public void navigationTest(){
        NuclearSubmarine nuclearSubmarine = new NuclearSubmarine(10);
        nuclearSubmarine.navigate();
    }

}
