package week02_구현.basic_A_세로읽기;

import java.util.Scanner;

/**
 * Created by soomin on 2022/03/18
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = new String[5];
        for (int i = 0; i < inputs.length; i ++) {
            inputs[i] = scanner.next();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(inputs));
    }
}

class Solution {
    private final int MAX_WORD_LENGTH = 15;

    public String solution(String[] inputs) {
        StringBuilder answer = new StringBuilder();
        int index = -1;
        while (index <= MAX_WORD_LENGTH) {
            index++;
            for (String input : inputs) {
                if (index < input.length()) {
                    answer.append(input.charAt(index));
                }
            }
        }
        return String.valueOf(answer);
    }
}
