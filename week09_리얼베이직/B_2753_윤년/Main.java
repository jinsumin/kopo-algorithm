package week09_리얼베이직.B_2753_윤년;

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
    public int solution(int input) {
        if ((isMultipleOfFour(input) && !isMultipleOfHundred(input)) || isMultipleOfFourHundred(input)) {
            return 1;
        } else {
            return 0;
        }
    }

    private boolean isMultipleOfFour(int input) {
        return input % 4 == 0;
    }

    private boolean isMultipleOfHundred(int input) {
        return input % 100 == 0;
    }

    private boolean isMultipleOfFourHundred(int input) {
        return input % 400 == 0;
    }
}
