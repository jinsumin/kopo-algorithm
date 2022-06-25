package week12_동적계획법.X8_1806_부분합;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        long[] inputs = new long[n + 1];
        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, s, inputs));
    }
}

class Solution {

    public long solution(int n, int s, long[] inputs) {
        long min = Long.MAX_VALUE;
        int begin = 0;
        int end = 0;
        int sum = 0;
        while (begin <= n && end <= n) {
            if (sum >= s && min > end - begin) {
                min = end - begin;
            }
            if (sum < s) {
                sum += inputs[end++];
            } else {
                sum -= inputs[begin++];
            }
        }
        if (min >= Long.MAX_VALUE) {
            return 0;
        } else {
            return min;
        }
    }
}
