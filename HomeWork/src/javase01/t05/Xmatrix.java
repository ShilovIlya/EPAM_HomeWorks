package javase01.t05;

/**
 * 1 0 0 ... 0 0 1
 * 0 1 0 ... 0 1 0
 * 0 0 1 ... 1 0 0
 *  ...  ...  ...
 * 0 0 1 ... 1 0 0
 * 0 1 0 ... 0 1 0
 * 1 0 0 ... 0 0 1
 */
public class Xmatrix {
    public static void printRandMatrix(){
        int n = (int)(10*Math.random());
        printNMatrix(n);
    }
    public static void printNMatrix(int n){
        int[][] Xmat = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if ((i == j) || (i + j == n - 1)){
                    Xmat[i][j] = 1;
                }
                else {
                    Xmat[i][j] = 0;
                }
                System.out.print(Xmat[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
