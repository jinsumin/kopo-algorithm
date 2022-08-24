package CASE_STUDY.이항계수2;

import java.util.*;

/**
 * Created by soomin on 2022/08/24
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(N, K));
    }
}

class Solution {
    public long solution(int n, int k) {
        long[][] dp = new long[n + 1][n + 1];

        // initialize
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
                if (i == n && j == k) {
                    if (dp[n][j] != 0) {
                        return dp[n][j] % 10007;
                    }
                }
            }
        }

        return dp[n][k];
    }
}
