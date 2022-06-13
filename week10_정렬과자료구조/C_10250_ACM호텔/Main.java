package week10_정렬과자료구조.C_10250_ACM호텔;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/13
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase-- > 0) {
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            int n = scanner.nextInt();
            Solution solution = new Solution();
            System.out.println(solution.solution(h, w, n));
        }
    }
}

class Solution {
    public String solution(int h, int w, int n) {
        String roomNumber = "";
        int count = 0;
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= h; j++) {
                if (count == n) {
                    return roomNumber;
                }
                if (i < 10) {
                    roomNumber = j + "0" + i;
                } else {
                    roomNumber = j + "" + i;
                }
                count++;
            }
        }
        return roomNumber;
    }
}
