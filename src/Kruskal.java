import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

public class Kruskal {
    // 교재의 입력 데이터(Figure 4.7) => n도 설정해야 한다.
    static int[][] EE = {
        {1, 2, 1},
        {1, 3, 3},
        {2, 3, 3},
        {2, 4, 6},
        {3, 4, 4},
        {3, 5, 2},
        {4, 5, 5}
    };
    static int nn = 5;           // vertex의 개수

    // 임의의 자작 입력 데이터
    static int[][] E = {
        {1, 2, 5},
        {1, 3, 4},
        {2, 3, 6},
        {2, 4, 2},
        {3, 4, 1},
        {3, 5, 3},
        {4, 5, 4},
        {4, 6, 3},
        {5, 6, 7}
    };
    static int n = 6;           // vertex의 개수

    static int m = E.length;    // edge의 개수

    static int[][] U = new int[n+1][2];

    static void sort() {
        Arrays.sort (E, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[2] - a2[2];
            }
        });
    }

    static void makeset (int i)
    {
        // U[i]에서 인덱스 0은 parent, 인덱스 1은 depth를 의미.
        // U[0]은 사용하지 않겠다.
        U[i][0] = i;
        U[i][1] = 0;
    }
    static void initial (int n)
    {
        int i;
        for (i = 1; i <= n; i++) {
            makeset(i);
        }
    }

    static int find (int i)
    {
        int j;

        j = i;
        while (U[i][0] != j) {
            j = U[i][0];
        }
        return j;
    }

    static Boolean equal (int p, int q)
    {
        if (p == q) {
            return true;
        }
        else {
            return false;
        }
    }

    static void merge (int p, int q)
    {
        if (U[p][1] == U[q][1]) {
            U[p][1] = U[p][1] + 1;            // 트리 깊이 증가
            U[q][0] = p;
        }
        else if (U[p][1] < U[q][1]) {         // 깊이가 작은 트리를 자식마디로 만든다.
            U[p][0] = q;
        }
        else {
            U[q][0] = p;
        }
    }
    public static void main(String[] args) {

        sort();         // 배열 E를 가중치 순서대로 정렬

        // 배열 F[0]은 사용하지 않겠다.
        ArrayList<Integer[]> F = new ArrayList<>();
        initial(n);

        int[] e;        // 배열 E를 순서대로 받아오는 배열
        int num = 0;
        int i, j;
        int p, q;

        while (F.size() < n-1) {
            e = E[num];
            i = e[0];
            j = e[1];

            p = find(i);
            q = find(j);

            if (!equal(p, q)) {
                merge(p, q);
                F.add(new Integer[]{e[0], e[1], e[2]});
            }
            
            num++;
        }
        
        System.out.print("F = {");
        for (int k = 0; k < F.size(); k++) {
            System.out.print("(");
            for (int m = 0; m < 3; m++) {
                System.out.print(F.get(k)[m]);
                if (m != 2) {
                    System.out.print(", ");
                }
            }
            System.out.print(")");
            if (k != F.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.print("}");
    }
}