package week13_트리.X5_1562_계단수;

import java.io.*;

/**
 * Created by soomin on 2022/07/01
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Solution solution = new Solution();
        System.out.println(solution.solution(n));
    }
}

class Solution {
    private static final long MOD = 1000000000;

    public long solution(int n) {
        long[][][] dp = new long[n + 1][10][1 << 10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }
        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    int visit = k | (1 << j);
                    if (j == 0) {
                        dp[i][j][visit] += dp[i - 1][j + 1][k] % MOD;
                    } else if (j == 9) {
                        dp[i][j][visit] += dp[i - 1][j - 1][k] % MOD;
                    } else {
                        dp[i][j][visit] += dp[i - 1][j + 1][k] % MOD + dp[i - 1][j - 1][k] % MOD;
                    }
                    dp[i][j][visit] %= MOD;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i][(1 << 10) - 1] % MOD;
            sum %= MOD;
        }
        return sum;
    }
}
