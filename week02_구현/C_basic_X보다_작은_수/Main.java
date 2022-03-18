package week02_구현.C_basic_X보다_작은_수;

import java.util.Scanner;

/**
 * Created by soomin on 2022/03/18
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i ++) {
            inputs[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.solution(n, x, inputs);
    }
}

class Solution {
    public void solution(int n, int x, int[] inputs) {
        for (int i = 0; i < n; i ++) {
            if (inputs[i] < x) {
                System.out.print(inputs[i] + " ");
            }
        }
    }
}
