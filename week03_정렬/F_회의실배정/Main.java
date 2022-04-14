package week03_정렬.F_회의실배정;

import java.util.*;

/**
 * Created by soomin on 2022/03/30
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] key = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i ++) {
            key[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, key, value));
    }
}

class Solution {
    public int solution(int n, int[] key, int[] value) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            map.put(key[i], value[i]);
        }
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        // entryList.sort(Map.Entry.comparingByValue());
        // 정렬 다시 구현...
        System.out.println(entryList);
        int previousValue = -1;
        for(Map.Entry<Integer, Integer> entry : entryList){
            if (previousValue <= entry.getKey()) {
                previousValue = entry.getValue();
                count++;
                System.out.println("회의 시간 : " + entry.getKey() + " ~ " + entry.getValue());
            }
        }
        return count;
    }
}
