package week07_문자열다지기.B_1157_단어공부;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Solution solution = new Solution();
        solution.solution(input);
    }
}

class Solution {
    public void solution(String input) {
        int max = 0;
        char answer = '?';
        int[] alphabet = new int['Z' + 1];
        input = input.toUpperCase(Locale.ROOT);
        for (int i = 0; i < input.length(); i ++) {
            alphabet[input.charAt(i)] ++;
        }
        for (int i = 'A'; i <= 'Z'; i ++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                answer = (char) i;
            }
        }
        for (int i = 'A'; i <= 'Z'; i ++) {
            if (alphabet[i] == max && (char) i != answer) {
                System.out.println('?');
                return;
            }
        }
        System.out.println(answer);
    }
}
