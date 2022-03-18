package week02_구현.basic_B_팰린드롬인지_확인하기;

import java.util.Scanner;

/**
 * Created by soomin on 2022/03/18
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    public int solution(String input) {
        if (isPalindrome(input)) {
            return 1;
        }
        return 0;
    }

    private boolean isPalindrome(String input) {
        StringBuilder reverseInput = new StringBuilder(input).reverse();
        return reverseInput.toString().equals(input);
    }
}
