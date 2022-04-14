package week04_자료구조.B_콘서트;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by soomin on 2022/04/14
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i ++) {
            inputs[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, inputs));
    }
}

class Solution {
    public int solution(int n, int[] inputs) {
        int answer = 1;
        Arrays.sort(inputs);
        for (int i = 0; i < n; i ++) {
            if (answer < inputs[i]) {
                return answer;
            }
            answer = inputs[i] + 1;
        }
        return answer;
    }
}
