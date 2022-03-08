package week01_문자열.B_30;

import java.util.*;

/**
 * Created by soomin on 2022/03/08
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
    public Object solution(String input) {
        StringBuilder answer = new StringBuilder();
        int sum = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < input.length(); i ++) {
            arrayList.add(Integer.parseInt(String.valueOf(input.charAt(i))));
            sum += arrayList.get(i);
        }
        if (sum % 3 != 0) {
            return -1;
        }
        arrayList.sort(Comparator.reverseOrder());
        if (arrayList.get(arrayList.size() - 1) != 0) {
            return -1;
        }
        for (Integer integer : arrayList) {
            answer.append(integer);
        }
        return answer;
    }
}
