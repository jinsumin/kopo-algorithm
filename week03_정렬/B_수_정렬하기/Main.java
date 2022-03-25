package week03_정렬.B_수_정렬하기;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by soomin on 2022/03/25
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i ++) {
            inputs[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.solution(n, inputs);
    }
}

class Solution {
    public void solution(int n, int[] inputs) {
        Arrays.sort(inputs);
        for (int input : inputs) {
            System.out.println(input);
        }
    }
}
