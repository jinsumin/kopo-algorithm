package week11_그리디알고리즘.C_13305_주유소;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/21
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] distances = new long[n - 1];
        long[] prices = new long[n];
        for (int i = 0; i < n - 1; i++) {
            distances[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, distances, prices));
    }
}

class Solution {
    public long solution(int n, long[] distances, long[] prices) {
        long answer = 0;
        long min = prices[0];
        for (int i = 0; i < n - 1; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            answer += min * distances[i];
        }
        return answer;
    }
}
