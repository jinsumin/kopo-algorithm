package CASE_STUDY.상범빌딩;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by soomin on 2022/09/09
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        int C = scanner.nextInt();
        Solution solution = new Solution();
        while (!(L == 0 && R == 0 && C == 0)) {
            char[][][] building = new char[L][R][C];
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String input = scanner.next();
                    for (int c = 0; c < C; c++) {
                        building[l][r][c] = input.charAt(c);
                    }
                }
            }
            solution.solution(L, R, C, building);
            L = scanner.nextInt();
            R = scanner.nextInt();
            C = scanner.nextInt();
        }
    }
}

class Node {
    int l, r, c;

    public Node(int l, int r, int c) {
        this.l = l;
        this.r = r;
        this.c = c;
    }
}

class Solution {
    private static final int[] DIRECTION_L = {0, 1, 0, -1, 0, 0};
    private static final int[] DIRECTION_R = {1, 0, -1, 0, 0, 0};
    private static final int[] DIRECTION_C = {0, 0, 0, 0, 1, -1};
    private static int move = 0;

    public void solution(int l, int r, int c, char[][][] building) {
        if (bfs(l, r, c, building)) {
            System.out.println("Escaped in " + move + " minute(s).");
        } else {
            System.out.println("Trapped!");
        }
    }

    private boolean bfs(int l, int r, int c, char[][][] building) {
        boolean[][][] visited = new boolean[l][r][c];
        Queue<Node> queue = new LinkedList<Node>();
        Node startNode = getStartNode(l, r, c, building);
        queue.offer(startNode);
        assert startNode != null;
        visited[startNode.l][startNode.r][startNode.c] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Node current = queue.poll();
                assert current != null;
                if (building[current.l][current.r][current.c] == 'E') {
                    return true;
                }
                for (int i = 0; i < 6; i++) {
                    Node next = new Node(current.l + DIRECTION_L[i], current.r + DIRECTION_R[i], current.c + DIRECTION_C[i]);
                    if (next.l >= 0 && next.l < l && next.r >= 0 && next.r < r && next.c >= 0 && next.c < c) {
                        if (building[next.l][next.r][next.c] != '#') {
                            if (!visited[next.l][next.r][next.c]) {
                                queue.offer(next);
                                visited[next.l][next.r][next.c] = true;
                            }
                        }
                    }
                }
            }
            move++;
        }
        return false;
    }

    private Node getStartNode(int l, int r, int c, char[][][] building) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (building[i][j][k] == 'S') {
                        return new Node(i, j, k);
                    }
                }
            }
        }
        return null;
    }
}
