package week10_정렬과자료구조.B_2751_수정렬하기2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by soomin on 2022/06/09
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.solution(n, inputs);
    }
}

class Solution {
    public void solution(int n, int[] inputs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(inputs);
        for (int i = 0; i < n; i++) {
            sb.append(inputs[i]).append("\n");
        }
        System.out.println(sb);
    }
}
