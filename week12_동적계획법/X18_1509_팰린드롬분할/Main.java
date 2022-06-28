package week12_동적계획법.X18_1509_팰린드롬분할;

import java.io.*;

/**
 * Created by soomin on 2022/06/29
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {

    public int solution(String input) {
        boolean[][] palindrome = new boolean[input.length() + 1][input.length() + 1];
        int[] dp = new int[input.length() + 1];
        for (int i = 1; i <= input.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        findPalindrome(input, palindrome);
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 1; j <= i; j++) {
                if (palindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[input.length()];
    }

    private void findPalindrome(String input, boolean[][] palindrome) {
        for (int i = 1; i <= input.length(); i++) {
            for (int j = i; j <= input.length(); j++) {
                boolean flag = true;
                int begin = i - 1;
                int end = j - 1;
                while (begin <= end) {
                    if (input.charAt(begin++) != input.charAt(end--)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    palindrome[i][j] = true;
                }
            }
        }
    }
}
