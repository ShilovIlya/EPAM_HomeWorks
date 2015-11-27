package javase01.test;

import javase01.t02.MinN;
import javase01.t03.FxTable;
import javase01.t04.MaxSum2InArr;
import javase01.t05.Xmatrix;
import javase01.t06.Notebook;
import org.junit.*;


public class Tests {
    @Test
    public void test2(){
        double epsilon = 1e-3;
        System.out.println("Task 2, param: eps = " + epsilon);
        MinN.min(epsilon);
    }
    @Test
    public void test3(){
        double a,b,h;
        a = -Math.PI/2;
        b = Math.PI/2;
        h = 0.1 + Math.PI/16;
        System.out.println("Task 3, param: a = " + a + ", b = " + b + ", h = " + h);
        FxTable.table(a, b, h);
    }

    @Test
    public void test4(){
        double[] a = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
        double max = MaxSum2InArr.array(a);
        Assert.assertEquals(81, max, 1e-5);
    }
    @Test
    public void test5(){
        int dim = 5;
        System.out.println("Task 5, param: n = dim(matrix) = " + dim);
        Xmatrix.printNMatrix(dim);
    }
    @Test
    public void test6(){
        Notebook notebook1 = new Notebook();
        Notebook notebook2 = new Notebook("myNotebook");
        notebook1.addNote("Hello World!");
        notebook1.addNote("WOW");
        notebook1.addNote("3");
        notebook1.editNote(0, "... world");
        notebook1.deleteNote(1);
        notebook1.lookAllNotes();
    }
}
