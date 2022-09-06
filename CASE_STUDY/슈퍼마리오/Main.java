package CASE_STUDY.슈퍼마리오;

import java.util.Scanner;

/**
 * Created by soomin on 2022/09/06
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = new int[10];
        for (int i = 0; i < 10; i++) {
            inputs[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(inputs));
    }
}

class Solution {
    public int solution(int[] inputs) {
        int sum = 0;
        for (int input : inputs) {
            sum += input;
            if (sum > 100) {
                if (Math.abs((sum - input) - 100) < Math.abs(sum - 100)) {
                    return sum - input;
                } else {
                    return sum;
                }
            }
        }
        return sum;
    }
}
