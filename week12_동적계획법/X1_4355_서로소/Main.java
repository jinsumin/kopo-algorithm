package week12_동적계획법.X1_4355_서로소;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/23
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution solution = new Solution();
        while (n != 0) {
            System.out.println(solution.solution(n));
            n = scanner.nextInt();
        }
    }
}

class Solution {
    public long solution(int n) {
        long answer = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                answer -= answer / i;
            }
        }
        if (n > 1) {
            answer -= answer / n;
        }
        return answer;
    }
}
