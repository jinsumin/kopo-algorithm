package week09_리얼베이직.E_10872_팩토리얼;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/07
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(n));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 1;
        for (int i = 1; i <= n; i++ ) {
            answer *= i;
        }
        return answer;
    }
}
