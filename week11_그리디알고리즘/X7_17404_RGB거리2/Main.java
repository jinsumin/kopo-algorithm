package week11_그리디알고리즘.X7_17404_RGB거리2;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/18
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map, n));
    }
}

class Solution {
    public long solution(int[][] map, int n) {
        long answer = 1001;
        int[][] dp = new int[n + 1][3];
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (i == k) {
                    dp[1][i] = map[1][i];
                } else {
                    dp[1][i] = 1001;
                }
            }
            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + map[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + map[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + map[i][2];
            }
            for (int i = 0; i < 3; i++) {
                if (i != k) {
                    answer = Math.min(answer, dp[n][i]);
                }
            }
        }
        return answer;
    }
}
