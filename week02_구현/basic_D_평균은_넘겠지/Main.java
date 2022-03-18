package week02_구현.basic_D_평균은_넘겠지;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by soomin on 2022/03/18
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int i = 0; i < testCase; i ++) {
            int n = scanner.nextInt();
            int[] inputs = new int[n];
            for (int j = 0; j < n; j ++) {
                inputs[j] = scanner.nextInt();
            }
            Solution solution = new Solution();
            System.out.println(solution.solution(n, inputs));
        }
    }
}

class Solution {
    public String solution(int n, int[] inputs) {
        double average = Arrays.stream(inputs).sum() / (double)n;
        int countOfOverAvg = 0;
        for (int i = 0; i < n; i ++) {
            if (inputs[i] > average) {
                countOfOverAvg++;
            }
        }
        return String.format("%.3f", (double)countOfOverAvg / (double)n * 100) + "%";
    }
}
