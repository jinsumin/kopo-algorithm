package week12_동적계획법.X12_1644_소수의연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by soomin on 2022/06/26
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Solution solution = new Solution();
        System.out.println(solution.solution(n));
    }
}

class Solution {
    public int solution(int n) {
        boolean[] prime = new boolean[n + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!prime[i]) {
                list.add(i);
            }
        }
        int begin = 0, end = 0, sum = 0, count = 0;
        while (true) {
            if (sum >= n) {
                sum -= list.get(begin);
                begin++;
            } else if (end == list.size()) {
                break;
            } else {
                sum += list.get(end);
                end++;
            }
            if (n == sum) {
                count++;
            }
        }
        return count;
    }
}
