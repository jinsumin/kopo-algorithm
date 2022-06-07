package week09_리얼베이직.C_2738_구구단;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dan = scanner.nextInt();
        Solution solution = new Solution();
        solution.solution(dan);
    }
}

class Solution {
    public void solution(int dan) {
        for (int i = 1; i <= 9; i++ ) {
            System.out.println(dan + " * " + i + " = " + dan * i);
        }
    }
}
