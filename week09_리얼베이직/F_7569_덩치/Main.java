package week09_리얼베이직.F_7569_덩치;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/07
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] inputs = new int[n][2];
        for (int i = 0; i < n; i++) {
            inputs[i][0] = scanner.nextInt();
            inputs[i][1] = scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.solution(n, inputs);
    }
}

class Solution {
    public void solution(int n, int[][] inputs) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            int rank = 1;
            for (int j = 0; j < n; j ++) {
                if (inputs[i][0] < inputs[j][0] && inputs[i][1] < inputs[j][1]) {
                    rank++;
                }
            }
            answer.append(rank).append(" ");
        }
        System.out.println(answer);
    }
}
