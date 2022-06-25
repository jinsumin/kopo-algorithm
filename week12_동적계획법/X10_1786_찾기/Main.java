package week12_동적계획법.X10_1786_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by soomin on 2022/06/25
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String T = bufferedReader.readLine();
        String P = bufferedReader.readLine();
        Solution solution = new Solution();
        System.out.println(solution.solution(T, P));
    }
}

class Solution {

    public StringBuilder solution(String T, String P) {
        StringBuilder answer = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int count = kmp(T, P, list);
        answer.append(count).append("\n");
        for (int i = 0; i < count; i++) {
            answer.append(list.get(i)).append("\n");
        }
        return answer;
    }

    private int kmp(String T, String P, List<Integer> list) {
        int count = 0;
        int[] pattern = getPattern(P);
        int j = 0;
        for (int i = 0; i < T.length(); i++) {
            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = pattern[j - 1];
            }
            if (T.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) {
                    count++;
                    list.add(i - j + 1);
                    j = pattern[j];
                } else {
                    j++;
                }
            }
        }
        return count;
    }

    private int[] getPattern(String P) {
        int[] pattern = new int[P.length()];
        int j = 0;
        for (int i = 1; i < P.length(); i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = pattern[j - 1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                j++;
                pattern[i] = j;
            }
        }
        return pattern;
    }
}
