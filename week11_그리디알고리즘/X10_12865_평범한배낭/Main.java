package week11_그리디알고리즘.X10_12865_평범한배낭;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by soomin on 2022/06/20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, k, weights, values));
    }
}

class Solution {
    public int solution(int n, int k, int[] weights, int[] values) {
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return sumOfWeights(n - 1, k, weights, dp, values);
    }

    private int sumOfWeights(int i, int k, int[] weights, int[][] dp, int[] values) {
        if (i < 0) {
            return 0;
        }
        if (dp[i][k] == -1) {
            if (weights[i] > k) {
                dp[i][k] = sumOfWeights(i - 1, k, weights, dp, values);
            } else {
                dp[i][k] = Math.max(sumOfWeights(i - 1, k, weights, dp, values),
                        sumOfWeights(i - 1, k - weights[i], weights, dp, values) + values[i]);
            }
        }
        return dp[i][k];
    }
}
