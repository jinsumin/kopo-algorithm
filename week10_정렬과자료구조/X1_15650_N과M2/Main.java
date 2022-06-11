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
        int[] array = new int[n];
        fillArray(array, n);
        boolean[] visited = new boolean[n];
        combination(array, visited, 0, n, m);
    }

    private void fillArray(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
    }

    private void combination(int[] array, boolean[] visited, int start, int n, int m) {
        if (m == 0) {
            print(array, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(array, visited, i + 1, n, m - 1);
            visited[i] = false;
        }
    }

    private void print(int[] array, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }
}