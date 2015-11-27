package javase01.t04;

/*
a[1...2n];
max(a[1]+a[2n],a[2]+a[2n-1],...,a[n]+a[n+1])
*/

public class MaxSum2InArr {
    public static double array(double[] a){
        int n_2 = a.length;
        double max = a[0] + a[n_2-1];
        for (int i = 1; i < n_2-1; i++){
            if (max < a[i] + a[n_2-1-i]) {
                max = a[i] + a[n_2-1-i];
            }
        }
        return max;
    }
}
