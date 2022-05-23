package week07_문자열다지기.F_1148_단어만들기;

import java.lang.reflect.Array;
import java.util.*;

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
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < word.length(); j ++) {
                if (hashMap.containsKey(word.charAt(j))) {
                    hashMap.put(word.charAt(j), hashMap.get(word.charAt(i)) + 1);
                } else {
                    hashMap.put(word.charAt(j), 1);
                }
            }
            ArrayList<String> arrayList = new ArrayList<>();
            for (String s : dictionary) {
                if (isPossibleWord(s, hashMap)) {
                    arrayList.add(s);
                }
            }
            HashMap<Character, Integer> answer = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                char targetChar = word.charAt(j);
                int count = 0;
                for (String s : arrayList) {
                    if (hasChar(s, targetChar)) {
                        count++;
                    }
                }
                answer.put(targetChar, count);
            }
            LinkedList<Map.Entry<Character, Integer>> entryLinkedList = new LinkedList<Map.Entry<Character, Integer>>(answer.entrySet());
            entryLinkedList.sort(new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            printMin(entryLinkedList);
            printMax(entryLinkedList);
            System.out.println();
        }
    }

    private void printMin(LinkedList<Map.Entry<Character, Integer>> entryLinkedList) {
        StringBuilder alphabets = new StringBuilder();
        ArrayList<Character> arrayList = new ArrayList<>();
        int size = entryLinkedList.size();
        int number = entryLinkedList.get(size - 1).getValue();
        for (int i = size - 1; i >= 0; i--) {
            if (entryLinkedList.get(i).getValue() == number) {
                arrayList.add(entryLinkedList.get(i).getKey());
            }
        }
        Collections.sort(arrayList);
        for (Character character : arrayList) {
            alphabets.append(character);
        }
        System.out.print(alphabets + " " + number + " ");
    }

    private void printMax(LinkedList<Map.Entry<Character, Integer>> entryLinkedList) {
        StringBuilder alphabets = new StringBuilder();
        ArrayList<Character> arrayList = new ArrayList<>();
        int number = entryLinkedList.get(0).getValue();
        for (Map.Entry<Character, Integer> characterIntegerEntry : entryLinkedList) {
            if (characterIntegerEntry.getValue() == number) {
                alphabets.append(characterIntegerEntry.getKey());
            }
        }
        Collections.sort(arrayList);
        for (Character character : arrayList) {
            alphabets.append(character);
        }
        System.out.print(alphabets + " " + number + " ");
    }

    private boolean hasChar(String s, char targetChar) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == targetChar) {
                return true;
            }
        }
        return false;
    }

    private boolean isPossibleWord(String s, HashMap<Character, Integer> hashMap) {
        HashMap<Character, Integer> newHashMap = new HashMap<>(hashMap);
        for (int i = 0; i < s.length(); i++) {
            if (!newHashMap.containsKey(s.charAt(i))) {
                return false;
            } else {
                if (newHashMap.get(s.charAt(i)) == 0) {
                    return false;
                }
                newHashMap.put(s.charAt(i), newHashMap.get(s.charAt(i)) - 1);
            }
        }
        return true;
    }
}
