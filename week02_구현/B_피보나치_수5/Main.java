package week02_구현.B_피보나치_수5;

import java.util.Scanner;

/**
 * Created by soomin on 2022/03/18
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    public int solution(int input) {
        int[] memo = new int[21];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= input; i ++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[input];
    }
}
