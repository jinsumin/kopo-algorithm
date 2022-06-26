package week12_동적계획법.X13_7579_앱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/06/26
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
        StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
        int[] memories = new int[n];
        int[] prices = new int[n];
        for (int i = 0; i < n; i ++) {
            memories[i] = Integer.parseInt(stringTokenizer1.nextToken());
            prices[i] = Integer.parseInt(stringTokenizer2.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, m, memories, prices));
    }
}

class Solution {

    public int solution(int n, int m, int[] memories, int[] prices) {
        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[n][100001];

        for (int i = 0; i < n; i++) {
            int price = prices[i];
            int memory = memories[i];
            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {
                    if ( j >= price ) {
                        dp[i][j] = memory;
                    }
                } else {
                    if ( j >= price ) {
                        dp[i][j] = Math.max(dp[i - 1][j - price] + memory, dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                if (dp[i][j] >= m) {
                    answer = Math.min(answer, j);
                }
            }
        }
        return answer;
    }
}
