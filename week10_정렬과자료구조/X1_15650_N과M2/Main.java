package week10_정렬과자료구조.X1_15650_N과M2;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/11
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Solution solution = new Solution();
        solution.solution(n, m);
    }
}

class Solution {

    public void solution(int n, int m) {
        int[] array = new int[m];
        dfs(array, n, m, 1, 0);
    }

    private void dfs(int[] array, int n, int m, int at, int depth) {
        if (depth == m) {
            for (int val : array) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= n; i++) {
            array[depth] = i;
            dfs(array, n, m, i + 1, depth + 1);
        }
    }
}
