package week06_기초다지기.C_1874_스택_수열;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution solution = new Solution();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i ++) {
            inputs[i] = scanner.nextInt();
        }
        solution.solution(n, inputs);
    }
}

class Solution {
    public void solution(int n, int[] inputs) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int[] compareArray = new int[n];
        int number = 1;
        for (int i = 0; i < n; i++) {
            while (number <= inputs[i]) {
                stack.push(number++);
                answer.append("+\n");
            }
            if (number > inputs[i]) {
                compareArray[i] = stack.pop();
                answer.append("-\n");
            }
        }
        if (Arrays.equals(inputs, compareArray)) {
            System.out.println(answer);
        } else {
            System.out.println("NO");
        }
    }
}
