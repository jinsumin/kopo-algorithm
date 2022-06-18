package week10_정렬과자료구조.X3_15657_N과M8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by soomin on 2022/06/14
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.solution(n, m, inputs);
    }
}

class Solution {
    public void solution(int n, int m, int[] inputs) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int input : inputs) {
            arrayList.add(input);
        }
        Collections.sort(arrayList);
        int[] array = new int[m];
        dfs(arrayList, array, n, m, 1, 0);
    }

    private void dfs(ArrayList<Integer> arrayList, int[] array, int n, int m, int at, int depth) {
        if (depth == m) {
            for (int val : array) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= n; i++) {
            array[depth] = arrayList.get(i - 1);
            dfs(arrayList, array, n, m, i, depth + 1);
        }
    }
}
