package week06_기초다지기.F_2231_분해합;

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
        for (int number = 1; number <= input; number++) {
            if (isDivideHap(input, number)) {
                return number;
            }
        }
        return 0;
    }

    private boolean isDivideHap(int input, int number) {
        int result = number;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result == input;
    }
}
