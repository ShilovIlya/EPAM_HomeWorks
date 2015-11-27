package javase01.t03;


public class FxTable {
    public static void table(double a, double b, double h) {
        System.out.println(" _________________________");
        System.out.println("|            |            |");
        System.out.println("|      x     |   tg(2x)-3 |");
        System.out.println("|____________|____________|");
        for (double x = a; x <= b; x += h){
            System.out.printf("| %10f | %10f |\n", x, F(x));
        }
        System.out.println("|____________|____________|");
    }

    private static double F(double x) {
        return Math.tan(2*x) - 3;
    }
}
