package week07_문자열다지기.G_1254_팰린드롬만들기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    public int solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <= input.length(); i++) {
            String customString = getCustomString(input, stack, i);
            if (isPalindrome(customString)) {
                return input.length() + i;
            }
        }
        return input.length();
    }

    private String getCustomString(String input, Stack<Character> stack, int i) {
        StringBuilder result = new StringBuilder(input);
        for (int j = 0; j < i; j++) {
            stack.push(input.charAt(j));
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return String.valueOf(result);
    }

    private boolean isPalindrome(String customString) {
        return customString.equals(String.valueOf(new StringBuilder(customString).reverse()));
    }
}
