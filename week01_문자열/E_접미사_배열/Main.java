package week01_문자열.E_접미사_배열;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by soomin on 2022/03/10
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Solution solution = new Solution();
        solution.solution(input);
    }
}

class Solution {
    public void solution(String input) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < input.length(); i ++) {
            arrayList.add(input.substring(i));
        }
        arrayList.sort(Comparator.naturalOrder());
        for (String s : arrayList) {
            System.out.println(s);
        }
    }
}
