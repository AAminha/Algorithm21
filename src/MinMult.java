public class MinMult {
    // 교재의 입력 데이터 (Example 3.5)
    final static int[] dd = {5, 2, 3, 4, 6, 7, 8};

    // 임의의 자작 입력 데이터
    final static int[] d = {3, 8, 5, 4, 3, 2, 6, 4};
    static int n = d.length-1;
    static int[][] P = new int[n][n+1];

    public static int minimum(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return (a < b ? a : b);
        }
    }

    public static void order(int i, int j) {

        if (i == j) {
            System.out.print("A" + i + " ");
        } else {
            int k = P[i][j];
            System.out.print("( ");
            order(i, k);
            order(k+1, j);
            System.out.print(") ");
        }
    }

    public static void main(String[] args) {
        int i, j, k, diagonal, num;
        // 인덱스가 0인 것들은 비워두기로 한다.
        int[][] M = new int[n+1][n+1];

        for (i = 1; i <= n; i++) {
            M[i][i] = 0;
        }

        for (diagonal = 1; diagonal <= n-1; diagonal++) {
            for (i = 1; i <= n-diagonal; i++) {
                j = i + diagonal;
                for (k = i; k <= j - 1; k++) {
                    num = M[i][k] + M[k+1][j] + d[i-1] * d[k] * d[j];
                    M[i][j] = minimum(M[i][j], num);
                    if (M[i][j] == num) {
                        P[i][j] = k;
                    }
                }
            }
        }
        System.out.println(M[1][n]);

        order(1, 7);
        System.out.println();

        for (int a = 1; a < P.length; a++) {
            for (int b = 1; b < P[a].length; b++) {
                System.out.print(P[a][b] + " ");
            }
            System.out.println();
        }
    }
}