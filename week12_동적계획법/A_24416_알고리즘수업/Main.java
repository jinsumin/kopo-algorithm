package week12_동적계획법.A_24416_알고리즘수업;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/24
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution solution = new Solution();
        solution.solution(n);
    }
}

class Solution {
    private long countOfCaseA = 0;
    private long countOfCaseB = 0;

    public void solution(int n) {
        fib(n);
        fibonacci(n);
        System.out.println(countOfCaseA + " " + countOfCaseB);
    }

    private void fib(int n) {
        if (n == 1 || n == 2) {
            countOfCaseA++;
            return;
        }
        fib(n - 1);
        fib(n - 2);
    }

    private void fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            countOfCaseB++;
            f[i] = f[i - 1] + f[i - 2];
        }
    }
}
