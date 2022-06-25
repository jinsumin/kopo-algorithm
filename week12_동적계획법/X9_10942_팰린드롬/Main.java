package week12_동적계획법.X9_10942_팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/06/25
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] inputs = new int[n + 1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            inputs[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int t = Integer.parseInt(bufferedReader.readLine());
        Solution solution = new Solution();
        StringBuilder answer = new StringBuilder();
        while (t-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
            answer.append(solution.solution(inputs, s, e)).append("\n");
        }
        System.out.println(answer);
    }
}

class Solution {

    public int solution(int[] inputs, int s, int e) {
        if (isPalindrome(inputs, s, e)) {
            return 1;
        } else {
            return 0;
        }
    }

    private boolean isPalindrome(int[] inputs, int s, int e) {
        while (s <= e) {
            if (inputs[s] != inputs[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
