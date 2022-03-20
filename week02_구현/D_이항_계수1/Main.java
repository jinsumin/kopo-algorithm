package week02_구현.D_이항_계수1;

import java.util.Scanner;

/**
 * Created by soomin on 2022/03/20
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(n, k));
    }
}

class Solution {
    public int solution(int n, int k) {
        int answer = 1;
        for (int i = n; i > n - k; i --) {
            answer *= i;
        }
        for (int i = 1; i <= k; i ++) {
            answer /= i;
        }
        return answer;
    }
}
