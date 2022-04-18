package week04_자료구조.E_스택;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/04/18
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] inputs = new String[n];
        for (int i = 0; i < n; i ++) {
            inputs[i] = scanner.nextLine();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, inputs));
    }
}

class Solution {
    public String solution(int n, String[] inputs) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i ++) {
            if (inputs[i].startsWith("push")) {
                StringTokenizer stringTokenizer = new StringTokenizer(inputs[i], " ");
                stringTokenizer.nextToken();
                stack.push(Integer.valueOf(stringTokenizer.nextToken()));
            } else {
                answer.append(read(inputs[i], stack)).append("\n");
            }
        }
        return String.valueOf(answer);
    }

    private int read(String input, Stack<Integer> stack) {
        if (input.equals("top")) {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.peek();
        }
        if (input.equals("pop")) {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.pop();
        }
        if (input.equals("size")) {
            return stack.size();
        }
        if (input.equals("empty")) {
            if (stack.isEmpty()) {
                return 1;
            }
            return 0;
        }
        return -1;
    }
}
