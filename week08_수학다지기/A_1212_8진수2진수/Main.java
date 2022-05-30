package week08_수학다지기.A_1212_8진수2진수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    private final String[] FIRST_BINARY_NUMBERS = {"0", "1", "10", "11", "100", "101", "110", "111"};
    private final String[] BINARY_NUMBERS = {"000", "001", "010", "011", "100", "101", "110", "111"};

    public String solution(String input) {
        StringBuilder answer = new StringBuilder();
        answer.append(FIRST_BINARY_NUMBERS[Integer.parseInt(String.valueOf(input.charAt(0)))]);
        for (int i = 1; i < input.length(); i++) {
            answer.append(BINARY_NUMBERS[Integer.parseInt(String.valueOf(input.charAt(i)))]);
        }
        return String.valueOf(answer);
    }
}
