package week01_문자열.D_듣보잡;

import java.util.*;

/**
 * Created by soomin on 2022/03/10
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] neverHeardNameList = new String[n];
        String[] neverSeenNameList = new String[m];
        for (int i = 0; i < n; i ++) {
            neverHeardNameList[i] = scanner.next();
        }
        for (int i = 0; i < m; i ++) {
            neverSeenNameList[i] = scanner.next();
        }
        Solution solution = new Solution();
        solution.solution(neverHeardNameList, neverSeenNameList);
    }
}

class Solution {
    public void solution(String[] neverHeardNameList, String[] neverSeenNameList) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<String> answerList = new ArrayList<>();
        for (String s : neverHeardNameList) {
            hashMap.put(s, 1);
        }
        for (String s : neverSeenNameList) {
            if (hashMap.containsKey(s)) {
                answerList.add(s);
            }
        }
        Collections.sort(answerList);
        System.out.println(answerList.size());
        for (String s : answerList) {
            System.out.println(s);
        }
    }
}
