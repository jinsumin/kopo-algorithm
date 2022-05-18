package week06_기초다지기.A_9012_괄호;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution solution = new Solution();
        for (int i = 0; i < n; i ++) {
            String input = scanner.next();
            solution.solution(input);
        }
    }
}

class Solution {
    public void solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i ++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                } else if (stack.peek() == ')') {
                    stack.push(ch);
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}
