package week03_정렬.E_ATM;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by soomin on 2022/03/30
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
        int answer = 0;
        int sum = 0;
        Arrays.sort(inputs);
        for (int i = 0; i < n; i ++) {
            answer += sum + inputs[i];
            sum += inputs[i];
        }
        return answer;
    }
}
