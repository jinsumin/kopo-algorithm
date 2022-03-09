package week01_문자열.A_알파벳_찾기;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by soomin on 2022/03/08
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Solution solution = new Solution();
        solution.solution(input);
    }
}

class Solution {
    public final int INIT_ALPHABET = 'a';
    public final int EMPTY = -1;

    public void solution(String input) {
        int[] answer = new int[26];
        Arrays.fill(answer, -1);
        for (int i = 0; i < input.length(); i ++) {
            if (answer[(input.charAt(i) - INIT_ALPHABET)] == EMPTY) {
                answer[(input.charAt(i) - INIT_ALPHABET)] = i;
            }
        }
        for (int j : answer) {
            System.out.print(j + " ");
        }
    }
}
