package week11_그리디알고리즘.X9_9251_LCS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by soomin on 2022/06/19
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputA = scanner.next();
        String inputB = scanner.next();
        Solution solution = new Solution();
        System.out.println(solution.solution(inputA, inputB));
    }
}

class Solution {
    public int solution(String inputA, String inputB) {
        char[] arrayA = inputA.toCharArray();
        char[] arrayB = inputB.toCharArray();
        int[][] dp = new int[arrayA.length][arrayB.length];
        for (int i = 0; i < arrayA.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return longestCommonSubsequence(arrayA, arrayB, dp, arrayA.length - 1, arrayB.length - 1);
    }

    private int longestCommonSubsequence(char[] arrayA, char[] arrayB, int[][] dp, int r, int c) {
        if (r == -1 || c == -1) {
            return 0;
        }
        if (dp[r][c] == -1) {
            dp[r][c] = 0;
            if (arrayA[r] == arrayB[c]) {
                dp[r][c] = longestCommonSubsequence(arrayA, arrayB, dp, r - 1, c - 1) + 1;
            } else {
                dp[r][c] = Math.max(longestCommonSubsequence(arrayA, arrayB, dp, r - 1, c),
                        longestCommonSubsequence(arrayA, arrayB, dp, r, c - 1));
            }
        }
        return dp[r][c];
    }
}
