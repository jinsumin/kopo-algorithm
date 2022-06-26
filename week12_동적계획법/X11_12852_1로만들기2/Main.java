package week12_동적계획법.X11_12852_1로만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by soomin on 2022/06/26
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Solution solution = new Solution();
        solution.solution(n);
    }
}

class Solution {
    public void solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] dp = new int[n + 1];
        int[] path = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 2; i<= n; i++) {
            if (i % 3 == 0) {
                if (dp[i / 3] + 1 < dp[i]) {
                    dp[i] = dp[i / 3] + 1;
                    path[i] = i / 3;
                }
            }
            if (i % 2 == 0) {
                if (dp[i / 2] < dp[i]) {
                    dp[i] = dp[i / 2] + 1;
                    path[i] = i / 2;
                }
            }
            if (dp[i - 1] + 1 < dp[i]) {
                dp[i] = dp[i - 1] + 1;
                path[i] = i - 1;
            }
        }
        stringBuilder.append(dp[n]).append("\n");
        while (n > 0) {
            stringBuilder.append(n).append(" ");
            n = path[n];
        }
        System.out.println(stringBuilder);
    }
}
