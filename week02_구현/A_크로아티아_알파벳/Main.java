package week02_구현.A_크로아티아_알파벳;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by soomin on 2022/03/18
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    private final String[] CROATIA_WORDS = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public int solution(String input) {
        Set<String> set = new HashSet<>(Arrays.asList(CROATIA_WORDS));
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = input.length() - 1; j > i; j--) {
                int lastIndex = j + 1;
                if (j + 1 > input.length()) {
                    lastIndex = input.length();
                }
                if (set.contains(input.substring(i, lastIndex))) {
                    input = input.substring(0, i) + "X" + input.substring(j + 1);
                }
            }
            System.out.println(input);
        }
        return input.length();
    }
}
