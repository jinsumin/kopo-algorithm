package week11_그리디알고리즘.X8_9465_스티커;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/19
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for (int i = 0; i < testCase; i++) {
            int n = scanner.nextInt();
            int[][] arr = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
            for (int j = 0; j < 2; j++) { //초기화
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = scanner.nextInt();
                }
            }
            Solution solution = new Solution();
            System.out.println(solution.solution(n, arr, dp));
        }
    }
}

class Solution {

    public int solution(int n, int[][] arr, int[][] dp) {
        dp[0][1] = arr[0][1];
        dp[1][1] = arr[1][1];
        for (int a = 2; a <= n; a++) {
            dp[0][a] = Math.max(dp[1][a - 1], dp[1][a - 2]) + arr[0][a];
            dp[1][a] = Math.max(dp[0][a - 1], dp[0][a - 2]) + arr[1][a];
        }
        return Math.max(dp[0][n], dp[1][n]);
    }
}