package week07_문자열다지기.E_1141_접두사;

import java.util.Arrays;
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
    public int solution(int n, String[] inputs) {
        int answer = n;
        Arrays.sort(inputs);
        for (int i = 0; i < inputs.length - 1; i ++) {
            for (int j = i + 1; j < n; j ++) {
                if (inputs[j].startsWith(inputs[i])) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}
