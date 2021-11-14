public class OptSearchTree {
    
    public static double minimum(double a, double b) {
        if (a == 0) {
            return b;
        } else {
            return (a < b ? a : b);
        }
    }
    public static void main (String[] args) {
        int i, j, diagonal;

        // 교재 입력 데이터 (Example 3.9)
        double[] pp = {3.0/8, 3.0/8, 1.0/8, 1.0/8};

        // 임의의 자작 입력 데이터
        double[] p = {2.0/9, 3.0/9, 1.0/9, 2.0/9, 1.0/9};
        int n = p.length;  // n = 5

        // 배열 A의 행은 1~n+1 열은 0~n
        double[][] A = new double[n+2][n+1];

        // 배열 R의 행은 1~n+1 열은 0~n
        int[][] R = new int[n+2][n+1];
        for (i = 1; i <= n; i++) {
            A[i][i-1] = 0;
            A[i][i] = p[i-1];
            R[i][i] = i;
            R[i][i-1] = 0;
        }

        A[n+1][n] = 0;
        R[n+1][n] = 0;
        double num = 0;
        for (diagonal = 1; diagonal <= n-1; diagonal++) {
            for (i = 1; i <= n-diagonal; i++) {
                j = i + diagonal;
                for (int k = i; k <= j; k++) {
                    num = A[i][k-1] + A[k+1][j];
                    A[i][j] = minimum(A[i][j], num);
                    if (A[i][j] == num) {
                        R[i][j] = k;
                    }
                }
                
                for (int m = i; m <= j; m++) {
                    A[i][j] += p[m-1];
                }
            }
        }
        System.out.println("A[1][5] = " + A[1][n]);
    }
}