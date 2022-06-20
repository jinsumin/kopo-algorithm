package week11_그리디알고리즘.A_11047_동전0;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/**
 * Created by soomin on 2022/06/20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, k, values));
    }
}

class Solution {
    public int solution(int n, int k, int[] values) {
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k == 0) {
                return answer;
            }
            if (k >= values[i]) {
                answer += k / values[i];
                k = k % values[i];
            }
        }
        return answer;
    }
}
