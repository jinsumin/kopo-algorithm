package week09_리얼베이직.D_8958_OX퀴즈;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        Solution solution = new Solution();
        for (int i = 0; i < testCase; i++) {
            System.out.println(solution.solution(scanner.next()));
        }
    }
}

class Solution {
    public int solution(String input) {
        int answer = 0;
        int weight = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'O') {
                weight++;
            } else {
                weight = 0;
            }
            answer += weight;
        }
        return answer;
    }
}
