package week02_구현.basic_F_상수;

import java.util.Scanner;

/**
 * Created by soomin on 2022/03/18
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputA = scanner.nextInt();
        int inputB = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(inputA, inputB));
    }
}

class Solution {
    public int solution(int inputA, int inputB) {
        int reverseA = Integer.parseInt(String
                .valueOf(new StringBuilder(Integer.toString(inputA)).reverse()));
        int reverseB = Integer.parseInt(String
                .valueOf(new StringBuilder(Integer.toString(inputB)).reverse()));
        return Math.max(reverseA, reverseB);
    }
}
