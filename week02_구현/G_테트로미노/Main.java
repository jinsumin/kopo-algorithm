package week02_구현.G_테트로미노;

import java.util.Scanner;

/**
 * Created by soomin on 2022/03/23
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, m, map));
    }
}

class Solution {
    private static int maxOfSum = 0;

    private class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int n, int m, int[][] map) {
        /*calBlueFigureA();
        calBlueFigureB();
        calYellowFigureA();
        calRedFigureA();
        calRedFigureB();
        calRedFigureC();
        calRedFigureD();
        calGreenFigureA();
        calGreenFigureB();
        calGreenFigureC();
        calGreenFigureD();
        calPurpleFigureA();
        calPurpleFigureB();
        calPurpleFigureC();
        calPurpleFigureD(n, m, map);*/
        return maxOfSum;
    }
}
