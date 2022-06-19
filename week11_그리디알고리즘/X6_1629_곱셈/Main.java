package week11_그리디알고리즘.X6_1629_곱셈;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/18
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long inputA = scanner.nextLong();
        long inputB = scanner.nextLong();
        long inputC = scanner.nextLong();
        Solution solution = new Solution();
        System.out.println(solution.solution(inputA, inputB, inputC));
    }
}

class Solution {
    public long solution(long inputA, long inputB, long inputC) {
        if (inputB == 1) {
            return inputA % inputC;
        }
        long temp = solution(inputA, inputB / 2, inputC);
        if (inputB % 2 == 1) {
            return (temp * temp % inputC) * inputA % inputC;
        }
        return temp * temp % inputC;
    }
}
