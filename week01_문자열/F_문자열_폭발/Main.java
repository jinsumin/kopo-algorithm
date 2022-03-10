package week01_문자열.F_문자열_폭발;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by soomin on 2022/03/10
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String bomb = scanner.next();
        Solution solution = new Solution();
        System.out.println(solution.solution(input, bomb));
    }
}

class Solution {
    public String solution(String input, String bomb) {
        StringBuilder answer = new StringBuilder();
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < input.length(); i ++) {
            linkedList.offer(input.charAt(i));
            if (linkedList.peekLast() == bomb.charAt(bomb.length() - 1)) {
                if (isContainBomb(linkedList, bomb)) {
                    deleteBomb(linkedList, bomb);
                }
            }
        }
        if (linkedList.isEmpty()) {
            return "FRULA";
        }
        for (Character character : linkedList) {
            answer.append(character);
        }
        return String.valueOf(answer);
    }

    private void deleteBomb(LinkedList<Character> linkedList, String bomb) {
        for (int j = 0; j < bomb.length(); j ++) {
            linkedList.pollLast();
        }
    }

    private boolean isContainBomb(LinkedList<Character> linkedList, String bomb) {
        if (linkedList.size() < bomb.length()) {
            return false;
        }
        for (int i = 0; i < bomb.length(); i ++) {
            if (bomb.charAt(i) != linkedList.get(linkedList.size() - bomb.length() + i)) {
                return false;
            }
        }
        return true;
    }
}
