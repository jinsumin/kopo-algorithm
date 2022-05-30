package week08_수학다지기.B_1225_이상한곱셈;

import java.util.Scanner;

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
    public long solution(String inputA, String inputB) {
        long sumOfA = 0;
        for (int i = 0; i < inputA.length(); i++) {
            sumOfA += Character.getNumericValue(inputA.charAt(i));
        }
        long sumOfB = 0;
        for (int i = 0; i < inputB.length(); i++) {
            sumOfB += Character.getNumericValue(inputB.charAt(i));
        }
        return sumOfA * sumOfB;
    }
}
