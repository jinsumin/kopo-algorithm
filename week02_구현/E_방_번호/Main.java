package week02_구현.E_방_번호;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by soomin on 2022/03/20
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roomNumber = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(roomNumber));
    }
}

class Solution {
    public int solution(int roomNumber) {
        int[] plasticKey = new int[9];  // 1, 2, 3, 4, 5, 6, 7, 8;
        String input = Integer.toString(roomNumber);
        int length = input.length();
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == '9') {
                plasticKey[6] ++;
            } else {
                plasticKey[Integer.parseInt(String.valueOf(input.charAt(i)))]++;
            }
        }
        plasticKey[6] = (int) Math.ceil((double) plasticKey[6] / 2);
        return Arrays.stream(plasticKey).max().getAsInt();
    }
}
