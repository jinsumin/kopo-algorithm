package week08_수학다지기.X_1011_FlyMeToTheAlphaCentauri;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        Solution solution = new Solution();
        for (int i = 0; i < testCase; i++) {
            int inputX = scanner.nextInt();
            int inputY = scanner.nextInt();
            System.out.println(solution.solution(inputX, inputY));
        }
    }
}

class Solution {
    public int solution(int inputX, int inputY) {
        int answer = 0;
        int distance = inputY - inputX;
        int max = (int) Math.sqrt(distance);
        if (max == Math.sqrt(distance)) {
            answer = (max * 2 - 1);
        } else if (distance <= max * max + max) {
            answer = (max * 2);
        } else {
            answer = (max * 2 + 1);
        }
        return answer;
    }
}
