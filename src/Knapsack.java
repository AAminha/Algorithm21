public class Knapsack {
	// 교재 입력 데이터
    static int n = 4;    // n개의 아이템
    static int W = 16;
    static int[] p = {0, 40, 30, 50, 10}; // index 0은 사용하지 않는다.
    static int[] w = {0, 2, 5, 10, 5}; // index 0은 사용하지 않는다.
    //////////////////////////////////////////////////////////////

    // 임의의 자작 입력 데이터
    static int an = 4;    // n개의 아이템
    static int aW = 10;
    static int[] ap = {0, 51, 40, 30, 10}; // index 0은 사용하지 않는다.
    static int[] aw = {0, 3, 4, 6, 5}; // index 0은 사용하지 않는다.
    //////////////////////////////////////////////////////////////

	static int t_weight = 0;    // 총 weight들의 합
	static int t_profit = 0;    // 총 profit들의 합
	static int maxprofit = 0; // 지금까지 찾은 최고 해답에서의 값어치
  
	static String[] include = new String[n+1]; // n + 1
	static int numbest;
	static String[] bestset = new String[n+1]; // n + 1
  
	static boolean promising (int i) {
		int j, k;
		int totweight;
		float bound;
  
		if (t_weight >= W) {
			return false;
		}
		else {
			j = i + 1;
			bound = t_profit;
			totweight = t_weight;
			while (j <= n && totweight + w[j] <= W) {
				totweight = totweight + w[j];
				bound = bound + p[j];
				j++;
			}
			k = j;
			if (k <= n) {
				bound = bound + (W-totweight) * (p[k]/w[k]);
			}

			return bound > maxprofit;
		}
	}
  
	static void knapsack (int i, int profit, int weight) {
		t_profit = profit;
		t_weight = weight;

		if (weight <= W && profit > maxprofit) {
			maxprofit = profit;
			numbest = i;
			for (int k = 1; k < include.length; k++) {
				bestset[k] = include[k];
			}
		}
  
		if (promising(i)) { // 유망한지 판단 (더 이상 배낭에 넣을 수 없으면 유망x)
			include[i+1] = "yes";    // w[i+1] 포함
			knapsack(i+1, profit + p[i+1], weight + w[i+1]);
			include[i+1] = "no";        // w[i+1] 비포함
			knapsack(i+1, profit, weight);
		}
	}
	public static void main(String[] args) {
		knapsack (0, t_profit, t_weight);

		System.out.println("<<배열 bestset 출력>>");
		for (int k = 1; k < bestset.length; k++) {
			if (bestset[k] != "yes") {
				bestset[k] = "no";
			}
			System.out.println("bestset[" + k + "] = " + bestset[k]);
		}

		System.out.println();
		System.out.println("maxprofit = " + maxprofit);
	}
}
