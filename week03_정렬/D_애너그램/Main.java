package week03_정렬.D_애너그램;

import java.util.Scanner;

/**
 * Created by soomin on 2022/03/29
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase-- > 0) {
            String inputA = scanner.next();
            String inputB = scanner.next();
            Solution solution = new Solution();
            solution.solution(inputA, inputB);
        }
    }
}

class Solution {
    public void solution(String inputA, String inputB) {
        int[] countAlphabet = new int[200];
        for (int i = 0; i < inputA.length(); i ++) {
            countAlphabet[inputA.charAt(i)]++;
        }
        for (int i = 0; i < inputB.length(); i ++) {
            countAlphabet[inputB.charAt(i)]--;
        }
        for (int count : countAlphabet) {
            if (count != 0) {
                System.out.printf("%s & %s are NOT anagrams.\n", inputA, inputB);
                return;
            }
        }
        System.out.printf("%s & %s are anagrams.\n", inputA, inputB);
    }
}
