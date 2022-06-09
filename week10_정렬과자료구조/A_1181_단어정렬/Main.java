package week10_정렬과자료구조.A_1181_단어정렬;

import java.util.*;

/**
 * Created by soomin on 2022/06/09
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
        Solution solution = new Solution();
        solution.solution(n, words);
    }
}

class Solution {
    public void solution(int n, String[] words) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String word : words) {
            if (!arrayList.contains(word)) {
                arrayList.add(word);
            }
        }
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() == o2.length()) {
                    return Integer.compare(o1.compareTo(o2), 0);
                } else {
                    return -1;
                }
            }
        });
        for (String word : arrayList) {
            System.out.println(word);
        }
    }
}
