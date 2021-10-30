public class Path {
    static int[][] P = new int[][] {
        {0, 0, 4, 0, 4},
        {5, 0, 0, 0, 4},
        {5, 5, 0, 0, 4},
        {5, 5, 0, 0, 0},
        {0, 1, 4, 1, 0}
    };

    public static void path(int q, int r) {
        if (P[q][r] != 0) {
            path(q, P[q][r]-1);
            System.out.print(P[q][r] + " ");
            path(P[q][r]-1, r);
        }
    }
    public static void main(String[] args) {
        int s = 5;  // 시작 정점
        int e = 3;  // 도착 정점
        path(s-1, e-1);
    }
}
