package week07_문자열다지기.C_1264_모음의개수;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("#")) {
                return;
            }
            Solution solution = new Solution();
            System.out.println(solution.solution(input));
        }
    }
}

class Solution {
    private final char[] VOWEL = {'a', 'e', 'i', 'o', 'u'};

    public int solution(String input) {
        int answer = 0;
        input = input.toLowerCase(Locale.ROOT);
        for (int i = 0; i < input.length(); i ++) {
            if (isVowel(input.charAt(i))) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isVowel(char charAt) {
        for (char c : VOWEL) {
            if (charAt == c) {
                return true;
            }
        }
        return false;
    }
}
