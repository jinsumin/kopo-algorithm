package week12_동적계획법.X15_2579_계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by soomin on 2022/06/27
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] stairs = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(reader.readLine());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, stairs));
    }
}

class Solution {
    public int solution(int n, int[] stairs) {
        if (n < 2) {
            return stairs[0];
        }
        int[][] dp = new int[n][2];
        dp[0][1] = 0;
        dp[0][0] = stairs[0];
        dp[1][1] = stairs[1];
        dp[1][0] = stairs[0] + stairs[1];
        for (int i = 2; i < n; i++) {
            dp[i][0] = dp[i - 1][1] + stairs[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
