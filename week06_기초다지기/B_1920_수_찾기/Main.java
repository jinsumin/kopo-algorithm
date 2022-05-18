package week06_기초다지기.B_1920_수_찾기;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputA = new int[n];
        for (int i = 0; i < n; i++) {
            inputA[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] inputB = new int[m];
        for (int i = 0; i < m; i++) {
            inputB[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.solution(n, m, inputA, inputB);
    }
}

class Solution {
    public void solution(int n, int m, int[] inputA, int[] inputB) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(inputA[i], 0);
        }
        for (int i = 0; i < m; i++) {
            if (hashMap.containsKey(inputB[i])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
