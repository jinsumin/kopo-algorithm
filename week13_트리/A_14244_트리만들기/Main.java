package week13_트리.A_14244_트리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/07/03
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Solution solution = new Solution();
        solution.solution(n, m);
    }
}

class Solution {

    public void solution(int n, int m) {
        StringBuilder answer = new StringBuilder();

        if (m == 2) {
            for (int i = 0; i < n - 1; i++) {
                answer.append(i).append(" ").append(i + 1).append('\n');
            }
        } else {
            answer.append(0).append(" ").append(1).append('\n');
            for (int i = 2; i < m + 1; i++) {
                answer.append(1).append(" ").append(i).append('\n');
            }
            for (int i = m; i < n - 1; i++) {
                answer.append(i).append(" ").append(i + 1).append('\n');
            }
        }

        System.out.println(answer);
    }
}
