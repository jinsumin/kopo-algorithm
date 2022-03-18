package week02_구현.basic_G_두_수_비교하기;

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
    public String solution(int inputA, int inputB) {
        if (inputA > inputB) {
            return ">";
        }
        if (inputA < inputB) {
            return "<";
        }
        return "==";
    }
}
