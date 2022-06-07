package week09_리얼베이직.G_1018_체스판다시칠하기;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/07
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] boards = new String[n];
        for (int i = 0; i < n; i++) {
            boards[i] = scanner.next();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, m, boards));
    }
}

class Solution {
    public int solution(int n, int m, String[] boards) {
        int answer = 64;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int countCaseA = getCountOfOddLines(i, j, boards, 'B') + getCountOfEvenLines(i, j, boards, 'W');
                int countCaseB = getCountOfOddLines(i, j, boards, 'W') + getCountOfEvenLines(i, j, boards, 'B');
                answer = Math.min(Math.min(countCaseA, countCaseB), answer);
            }
        }
        return answer;
    }

    private int getCountOfEvenLines(int n, int m, String[] boards, char tile) {
        int countOfWrongTile = 0;
        char startTile = tile;
        for (int i = n; i < n + 8; i += 2) {
            tile = startTile;
            for (int j = m; j < m + 8; j++) {
                if (tile != boards[i].charAt(j)) {
                    countOfWrongTile++;
                }
                if (tile == 'W') {
                    tile = 'B';
                } else {
                    tile = 'W';
                }
            }
        }
        return countOfWrongTile;
    }

    private int getCountOfOddLines(int n, int m, String[] boards, char tile) {
        int countOfWrongTile = 0;
        char startTile = tile;
        for (int i = n + 1; i < n + 8; i += 2) {
            tile = startTile;
            for (int j = m; j < m + 8; j++) {
                if (tile != boards[i].charAt(j)) {
                    countOfWrongTile++;
                }
                if (tile == 'W') {
                    tile = 'B';
                } else {
                    tile = 'W';
                }
            }
        }
        return countOfWrongTile;
    }
}
