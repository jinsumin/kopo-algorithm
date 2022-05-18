package week06_기초다지기.C_1874_스택_수열;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution solution = new Solution();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i ++) {
            inputs[i] = scanner.nextInt();
        }
        solution.solution(inputs);
    }
}

class Solution {
    public void solution(int[] inputs) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int currentNumber = 1; currentNumber <= 10; currentNumber++) {
            if (stack.isEmpty()) {
                stack.push(currentNumber);
                answer.append('+');
            } else if (stack.peek() <= currentNumber) {
                stack.push(currentNumber);
                answer.append('+');
            } else if (stack.peek() == currentNumber) {
                stack.pop();
                answer.append('-');
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(answer);
    }
}
