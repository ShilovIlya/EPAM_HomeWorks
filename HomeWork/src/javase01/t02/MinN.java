package javase01.t02;

/* search min N for task
*task: a(i) = 1/((i+1)^2). Search min n: a(n) < eps
*@param eps
*@print a(1),a(2),...,a(n),n
*/
public class MinN {
    public static void min(double eps) {
        int i = 0;
        double a;
        do {
            i++;
            a = 1.0/((i+1)*(i+1));
            System.out.println("i = " + i + ", a = " + a + ";");
        } while(a > eps);
        //print min N
        System.out.println("n = " + i);
    }
}