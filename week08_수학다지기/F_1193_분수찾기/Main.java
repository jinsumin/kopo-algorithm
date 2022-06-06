package week08_수학다지기.F_1193_분수찾기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(x));
    }
}

class Solution {
    public String solution(int x) {
        String[] memo = new String[x + 1];
        memo[1] = "1/1";
        boolean toggle = false;
        int upNumber = 1;
        int downNumber = 1;
        for (int i = 2; i <= x; i++ ) {
            if (!toggle) {
                if (downNumber == 1) {
                    downNumber++;
                }
            }
        }
        return memo[x];
    }
}
