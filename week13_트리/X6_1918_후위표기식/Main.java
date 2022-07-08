package week13_트리.X6_1918_후위표기식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by soomin on 2022/07/07
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {

    public StringBuilder solution(String input) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '+', '-', '*', '/' -> {
                    while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(ch)) {
                        answer.append(stack.pop());
                    }
                    stack.add(ch);
                }
                case '(' -> stack.add(ch);
                case ')' -> {
                    while (!stack.isEmpty() && !stack.peek().equals('(')) {
                        answer.append(stack.pop());
                    }
                    stack.pop();
                }
                default -> answer.append(ch);
            }
        }
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer;
    }

    private int getPriority(char peek) {
        if (peek == ('(') || peek == (')')) {
            return 1;
        } else if (peek == '+' || peek == '-') {
            return 2;
        } else if (peek == '*' || peek == '/') {
            return 3;
        }
        return 0;
    }
}
