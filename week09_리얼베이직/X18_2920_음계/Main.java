package week09_리얼베이직.X18_2920_음계;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/07
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = new int[8];
        for (int i = 0; i < 8; i++) {
            inputs[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(inputs));
    }
}

class Solution {
    public String solution(int[] inputs) {
        String answer = "";
        if (isAscending(inputs)) {
            answer = "ascending";
        } else if (isDescending(inputs)) {
            answer = "descending";
        } else {
            answer = "mixed";
        }
        return answer;
    }

    private boolean isAscending(int[] inputs) {
        for (int i = 0; i < 8; i++) {
            if (inputs[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isDescending(int[] inputs) {
        for (int i = 0; i < 8; i++) {
            if (inputs[i] != 8 - i) {
                return false;
            }
        }
        return true;
    }
}
