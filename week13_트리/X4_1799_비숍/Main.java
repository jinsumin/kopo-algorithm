package week13_트리.X4_1799_비숍;

import java.io.*;
import java.util.*;

/**
 * Created by soomin on 2022/07/01
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, map));
    }
}

class Solution {
    private boolean[][] visited;
    private boolean[][] isBlack;
    private int[] answer;

    public int solution(int n, int[][] map) {
        answer = new int[2];
        visited = new boolean[n][n];
        isBlack = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
            for (int j = 0; j < n; j++) {
                isBlack[i][j] = (i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1);
            }
        }
        dfs(0, true, 0, map);
        dfs(0, false, 0, map);
        return answer[0] + answer[1];
    }

    private void dfs(int index, boolean black, int count, int[][] map) {
        int length = map.length;
        for (int i = index; i < length * length; i++) {
            int r = i / length;
            int c = i % length;
            if (map[r][c] == 0 || isBlack[r][c] != black || !isValid(r, c)) {
                continue;
            }
            visited[r][c] = true;
            dfs(i + 1, black, count + 1, map);
            visited[r][c] = false;
        }
        answer[black ? 0 : 1] = Math.max(answer[black ? 0 : 1], count);
    }

    private boolean isValid(int r, int c) {
        int[] directionOfR = {-1, -1};
        int[] directionOfC = {-1, 1};
        for (int i = 0; i < 2; i++) {
            int nextR = r;
            int nextC = c;
            while (nextR >= 0 && nextR < visited.length && nextC >= 0 && nextC < visited.length) {
                if (visited[nextR][nextC]) {
                    return false;
                }
                nextR += directionOfR[i];
                nextC += directionOfC[i];
            }
        }
        return true;
    }
}
