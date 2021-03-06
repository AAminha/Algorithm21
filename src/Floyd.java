public class Floyd {
    final static int INF = 99999;

    // 교재 입력 데이터 (Figure 3.2)
    static int[][] WW = {
        {0, 1, INF, 1, 5},
        {9, 0, 3, 2, INF},
        {INF, INF, 0, 4, INF},
        {INF, INF, 2, 0, 3},
        {3, INF, INF, INF, 0}
    };

    // 임의의 자작 데이터
    static int[][] W = {
        {0,7,4,INF,INF,1},
        {2,0,5,INF,5,INF},
        {INF,INF,0,5,INF,INF},
        {INF,2,INF,0,5,4},
        {INF,3,INF,INF,0,2},
        {4,INF,1,INF,5,0}
    };

    // 배열 원소 출력 함수
    public static void printItem (int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 99999) {
                    System.out.print("INF" + "\t");
                } else {
                    System.out.print(array[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int n = W.length;
        int i, j, k;

        int[][] D = new int[n][n];  // 최단거리행렬 선언
        int[][] P = new int[n][n];

        // 배열 W을 배열 D에 복사하는 과정
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                D[i][j] = W[i][j];
            }
        }

        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        P[i][j] = k+1;
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }

        // 배열 출력
        System.out.println("<< 배열 W >>");
        printItem(W);
        System.out.println("<< 배열 D >>");
        printItem(D);
        System.out.println("<< 배열 P >>");
        printItem(P);
    }
}