package week12_동적계획법.B_1912_연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/06/25
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] inputs = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, inputs));
    }
}

class Solution {
    public long solution(int n, int[] inputs) {
        long answer = 0;
        int[] dp = new int[n];
        dp[0] = inputs[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) {
                answer += dp[i - 1];
                dp[i] += (dp[i - 1] + inputs[i]);
            } else {
                answer = 0;
            }
        }
        return answer;
    }
}
