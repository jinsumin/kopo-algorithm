package CASE_STUDY.점프점프;

import java.util.Scanner;

/**
 * Created by soomin on 2022/09/06
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int P1 = scanner.nextInt();
        int P2 = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(X, Y, P1, P2));
    }
}

class Solution {
    public int solution(int X, int Y, int P1, int P2) {
       int[] memo = new int[10001];
       for (int i = 0; i < 100; i++) {
           memo[(X * i) + P1]++;
           memo[(Y * i) + P2]++;
       }
       for (int i = 0; i < 10001; i++) {
           if (memo[i] == 2) {
               return i;
           }
       }
       return -1;
    }
}
