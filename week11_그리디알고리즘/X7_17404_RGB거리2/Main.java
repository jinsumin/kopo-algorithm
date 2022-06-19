package week11_그리디알고리즘.X7_17404_RGB거리2;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/18
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map, n));
    }
}

class Solution {
    public int solution(int[][] map, int n) {
        // TO DO : logic
        for (int i = 2; i < n; i++) {
            map[i][0] += Math.min(map[i - 1][1], map[i - 1][2]);
            map[i][1] += Math.min(map[i - 1][0], map[i - 1][2]);
            map[i][2] += Math.min(map[i - 1][0], map[i - 1][1]);
        }

        return 0;
    }
}
