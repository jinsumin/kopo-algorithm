package week06_기초다지기.G_2798_블랙잭;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, m, input));
    }
}

class Solution {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public int solution(int n, int m, int[] input) {
        boolean[] visited = new boolean[n];
        combination(input, visited, 0, n, 3, m);
        Collections.sort(arrayList);
        return m - arrayList.get(0);
    }

    private void combination(int[] input, boolean[] visited, int start, int n, int r, int m) {
        if (r == 0) {
            pushVisitedNumbers(input, visited, n, m);
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(input, visited, i + 1, n, r - 1, m);
            visited[i] = false;
        }
    }

    private void pushVisitedNumbers(int[] input, boolean[] visited, int n, int m) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += input[i];
            }
        }
        if (sum <= m) {
            arrayList.add(m - sum);
        }
    }
}
