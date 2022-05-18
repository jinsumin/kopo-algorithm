package week06_기초다지기.E_1259_팰린드롬수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int input = scanner.nextInt();
        while (input != 0) {
            solution.solution(input);
            input = scanner.nextInt();
        }
    }
}

class Solution {
    public void solution(int input) {
        String str = Integer.toString(input);
        String reverseStr = String.valueOf(new StringBuilder(str).reverse());
        if (str.equals(reverseStr)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
