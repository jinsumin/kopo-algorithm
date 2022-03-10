package week01_문자열.C_그룹_단어_체커;

import java.util.Scanner;

/**
 * Created by soomin on 2022/03/09
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String[] input = new String[number];
        for (int i = 0; i < input.length; i ++) {
            input[i] = scanner.next();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    public int solution(String[] input) {
        int answer = 0;
        for (String word : input) {
            if (isGroupWord(word)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isGroupWord(String word) {
        boolean[] alphabet = new boolean[26];
        int pivot = word.charAt(0) - 'a';
        for (int i = 0; i < word.length(); i ++) {
            if (word.charAt(i) - 'a' != pivot) {
                if (alphabet[word.charAt(i) - 'a']) {
                    return false;
                }
            }
            alphabet[word.charAt(i) - 'a'] = true;
            pivot = word.charAt(i) - 'a';
        }
        return true;
    }
}
