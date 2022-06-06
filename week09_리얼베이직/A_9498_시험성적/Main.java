package week09_리얼베이직.A_9498_시험성적;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    public String solution(int input) {
        if (input >= 90) {
            return "A";
        }
        if (input >= 80) {
            return "B";
        }
        if (input >= 70) {
            return "C";
        }
        if (input >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}