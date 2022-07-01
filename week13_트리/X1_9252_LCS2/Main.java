package week13_트리.X1_9252_LCS2;

import java.io.*;
import java.util.*;

/**
 * Created by soomin on 2022/07/01
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputA = reader.readLine();
        String inputB = reader.readLine();
        Solution solution = new Solution();
        solution.solution(inputA, inputB);
    }
}

class Solution {

    public void solution(String inputA, String inputB) {
        int lengthA = inputA.length();
        int lengthB = inputB.length();
        int[][] dp = new int[lengthA + 1][lengthB + 1];
        for (int i = 1; i < lengthA + 1; i++) {
            for (int j = 1; j < lengthB + 1; j++) {
                if (inputA.charAt(i - 1) == inputB.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[lengthA][lengthB]);
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        while (lengthA > 0 && lengthB > 0) {
            if (dp[lengthA][lengthB] == dp[lengthA - 1][lengthB]) {
                lengthA--;
            } else if (dp[lengthA][lengthB] == dp[lengthA][lengthB - 1]) {
                lengthB--;
            } else {
                stack.push(inputA.charAt(lengthA - 1));
                lengthA--;
                lengthB--;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
