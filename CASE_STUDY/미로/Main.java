package CASE_STUDY.미로;

import java.io.*;
import java.util.*;

/**
 * Created by soomin on 2022/08/17
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String elements = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(elements.charAt(j)));
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(N, M, map));
    }
}

class Solution {
    private static int answer = 0;

    private static final int[] MOVE_R = {1, 0, -1, 0};
    private static final int[] MOVE_C = {0, 1, 0, -1};

    private static class Node {
        private final int r;
        private final int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int n, int m, int[][] map) {
        Node startNode = new Node(0, 0);
        Node endNode = new Node(n - 1, m - 1);
        boolean[][] visited = new boolean[n][m];
        bfs(map, visited, startNode, endNode);
        return answer;
    }

    private void bfs(int[][] map, boolean[][] visited, Node startNode, Node endNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(startNode);
        while (!queue.isEmpty()) {
            answer++;
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Node currentNode = queue.poll();
                assert currentNode != null;
                if (currentNode.r == endNode.r && currentNode.c == endNode.c) {
                    return;
                }
                if (!visited[currentNode.r][currentNode.c]) {
                    visited[currentNode.r][currentNode.c] = true;
                    for (int i = 0; i < 4; i++) {
                        int nextR = currentNode.r + MOVE_R[i];
                        int nextC = currentNode.c + MOVE_C[i];
                        if (nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length) {
                            continue;
                        }
                        if (visited[nextR][nextC]) {
                            continue;
                        }
                        if (map[nextR][nextC] == 0) {
                            continue;
                        }
                        queue.offer(new Node(nextR, nextC));
                    }
                }
            }
        }
    }
}
