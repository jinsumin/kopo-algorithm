package week03_정렬.C_점수_집계;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by soomin on 2022/03/29
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase-- > 0) {
            int[] inputs = new int[5];
            for (int i = 0; i < 5; i ++) {
                inputs[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            solution.solution(inputs);
        }
    }
}

class Solution {
    public void solution(int[] inputs) {
        Arrays.sort(inputs);
        if (inputs[3] - inputs[1] >= 4) {
            System.out.println("KIN");
            return;
        }
        System.out.println(inputs[1] + inputs[2] + inputs[3]);
    }
}
