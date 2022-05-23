package week07_문자열다지기.D_1032_명령프롬프트;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] inputs = new String[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.next();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, inputs));
    }
}

class Solution {
    public String solution(int n, String[] inputs) {
        StringBuilder answer = new StringBuilder();
        String input = inputs[0];
        for (int i = 0; i < input.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (inputs[j].charAt(i) != input.charAt(i)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                answer.append('?');
            } else {
                answer.append(input.charAt(i));
            }
        }
        return String.valueOf(answer);
    }
}
