package CASE_STUDY.루트;

import java.util.Scanner;

/**
 * Created by soomin on 2022/09/04
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int B = scanner.nextInt();
        int N = scanner.nextInt();
        while (!(B == 0 && N == 0)) {
            Solution solution = new Solution();
            System.out.println(solution.solution(B, N));
            B = scanner.nextInt();
            N = scanner.nextInt();
        }
    }
}

class Solution {
    public int solution(int B, int N) {
        int A = 1;
        int min = (int) Math.abs(Math.pow(A, N) - B);
        while (true) {
            A++;
            int value = (int) Math.abs(Math.pow(A, N) - B);
            if (value < min) {
                min = value;
            } else {
                return A - 1;
            }
        }
    }
}
