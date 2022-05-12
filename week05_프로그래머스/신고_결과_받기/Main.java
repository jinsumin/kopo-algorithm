package week05_프로그래머스.신고_결과_받기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> answerMap = new HashMap<>();
        for (String s : id_list) {
            answerMap.put(s, 0);
        }
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for (String s : id_list) {
            LinkedList<String> linkedList = new LinkedList<>();
            map.put(s, linkedList);
        }
        for (String s : report) {
            String[] names = s.split(" ");
            LinkedList<String> linkedList = map.get(names[0]);
            linkedList.add(names[1]);
            map.replace(names[0], linkedList);
        }
        for (String item : id_list) {
            if (map.get(item).size() >= k) {
                LinkedList<String> linkedList = map.get(item);
                for (String s : linkedList) {
                    int value = answerMap.get(s);
                    answerMap.replace(s, value + 1);
                }
            }
        }
        for (int i = 0; i < id_list.length; i ++) {
            answer[i] = answerMap.get(id_list[i]);
        }
        return answer;
    }
}
