package week12_동적계획법.E_2565_전깃줄;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/06/27
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] linkedLines = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            linkedLines[i][0] = Integer.parseInt(st.nextToken());
            linkedLines[i][1] = Integer.parseInt(st.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, linkedLines));
    }
}

class Solution {

    public int solution(int n, int[][] linkedLines) {
        int answer = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(linkedLines, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (linkedLines[i][1] > linkedLines[j][1]) {
                    max = Math.max(max, dp[j]);
                }
                dp[i] = max + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            answer = Math.max(dp[i], answer);
        }
        return n - answer;
    }
}
