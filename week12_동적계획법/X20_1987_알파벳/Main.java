package week12_동적계획법.X20_1987_알파벳;

import java.io.*;
import java.util.*;

/**
 * Created by soomin on 2022/06/30
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String input = reader.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j) - 'A';
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(r, c, map));
    }
}

class Solution {
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private long answer = 0;

    public long solution(int r, int c, int[][] map) {
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, false);
        dfs(r, c, 0, map, visited, 0, 0);
        return answer;
    }

    private void dfs(int r, int c, int count, int[][] map, boolean[] visited, int x, int y) {
        if (visited[map[x][y]]) {
            answer = Math.max(answer, count);
        } else {
            visited[map[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int nextR = x + dx[i];
                int nextC = y + dy[i];
                if (nextR >= 0 && nextC >= 0 && nextR < r && nextC < c) {
                    dfs(r, c, count + 1, map, visited, nextR, nextC);
                }
            }
            visited[map[x][y]] = false;
        }
    }
}
