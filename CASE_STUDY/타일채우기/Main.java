package CASE_STUDY.타일채우기;

import java.util.Scanner;

/**
 * Created by soomin on 2022/09/10
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(N));
    }
}

class Solution {
    public int solution(int N) {
        if (N % 2 == 1) {
            return 0;
        }

        int[] memo = new int[N + 1];
        memo[0] = 1;
        memo[2] = 3;

        for (int i = 4; i <= N; i += 2) {
            memo[i] = memo[i - 2] * memo[2];
            for (int j = i - 4; j >= 0; j -= 2) {
                memo[i] += memo[j] * 2;
            }

        }

        return memo[N];
    }
}
