package CASE_STUDY.영재의징검다리;

import java.util.*;

/**
 * Created by soomin on 2022/08/24
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long[][] map = new long[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(N, M, map));
    }
}

class Solution {
    private static final long MOD = 1000000007;

    public long solution(int n, int m, long[][] map) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    long sum = 0;
                    if (map[i - 1][j] != 0) {
                        sum += map[i - 1][j] % MOD;
                    }
                    if ( j - 1 >= 0 ) {
                        if (map[i - 1][j - 1] != 0) {
                            sum += map[i - 1][j - 1] % MOD;
                        }
                    }
                    if (j + 1 < m) {
                        if (map[i - 1][j + 1] != 0) {
                            sum += map[i - 1][j + 1] % MOD;
                        }
                    }
                    map[i][j] = sum % MOD;
                }
            }
        }
        return Arrays.stream(map[n - 1]).sum() % MOD;
    }
}
