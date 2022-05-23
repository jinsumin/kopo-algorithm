package week07_문자열다지기.F_1148_단어만들기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> dictionary = new ArrayList<>();
        while (true) {
            String input = scanner.next();
            if (input.equals("-")) {
                break;
            }
            dictionary.add(input);
        }
        ArrayList<String> words = new ArrayList<>();
        while (true) {
            String input = scanner.next();
            if (input.equals("#")) {
                break;
            }
            words.add(input);
        }
        Solution solution = new Solution();
        solution.solution(dictionary, words);
    }
}

class Solution {
    public void solution(ArrayList<String> dictionary, ArrayList<String> words) {
        // TO DO:
        HashMap<Character, Integer> hashMap = new HashMap<>();
    }
}
