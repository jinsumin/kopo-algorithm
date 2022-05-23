package week07_문자열다지기.B_1157_단어공부;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    public char solution(String input) {
        input = input.toUpperCase(Locale.ROOT);
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < input.length(); i ++) {
            if (hashMap.containsKey(input.charAt(i))) {
                hashMap.put(input.charAt(i), hashMap.get(input.charAt(i)) + 1);
            } else {
                hashMap.put(input.charAt(i), 1);
            }
        }
        LinkedList<Map.Entry<Character, Integer>> entryLinkedList = new LinkedList<>(hashMap.entrySet());
        entryLinkedList.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else if (o1.getValue().equals(o2.getValue())){
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        if (entryLinkedList.size() <= 1) {
            return entryLinkedList.get(0).getKey();
        }
        if (entryLinkedList.get(0).getValue().equals(entryLinkedList.get(1).getValue())) {
            return '?';
        } else {
            return entryLinkedList.get(0).getKey();
        }
    }
}
