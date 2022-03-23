package week02_구현.F_로봇청소기;

import java.util.Scanner;

/**
 * Created by soomin on 2022/03/20
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int direction = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, m, r, c, direction, map));
    }
}

class Solution {
    private final int[] MOVE_R = {-1, 0, 1, 0};
    private final int[] MOVE_C = {0, 1, 0, -1};
    private final int EMPTY = 0;
    private final int WALL = 1;
    private static int countOfClean = 0;

    public class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int n, int m, int r, int c, int direction, int[][] map) {
        boolean[][] cleaned = new boolean[n][m];
        Node currentNode = new Node(r, c);
        // 1. 현재 위치를 청소한다.
        cleanCurrentArea(currentNode, cleaned);
        // 2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
        searchArea(map, cleaned, currentNode, direction);
        return countOfClean;
    }

    private void cleanCurrentArea(Node currentNode, boolean[][] cleaned) {
        if (!cleaned[currentNode.r][currentNode.c]) {
            cleaned[currentNode.r][currentNode.c] = true;
            countOfClean++;
            // printMap(cleaned);
        }
    }

    private void printMap(boolean[][] cleaned) {
        for (int i = 0; i < cleaned.length; i++) {
            for (int j = 0; j < cleaned[0].length; j++) {
                if (cleaned[i][j]) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void searchArea(int[][] map, boolean[][] cleaned, Node currentNode, int direction) {
        // a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
        // b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
        int leftDirection = (direction + 3) % 4;    // 왼쪽 회전
        for (int i = 0; i < 4; i++) {
            Node leftNode = new Node(currentNode.r + MOVE_R[leftDirection], currentNode.c + MOVE_C[leftDirection]);
            if (leftNode.r >= 0 && leftNode.c >= 0 && leftNode.r < map.length && leftNode.c < map[0].length) {
                if (map[leftNode.r][leftNode.c] == EMPTY) { // 왼쪽 공간이 비어있고
                    if (!cleaned[leftNode.r][leftNode.c]) { // 동시에 청소가 안된 공간이라면
                        cleanCurrentArea(leftNode, cleaned);
                        searchArea(map, cleaned, leftNode, leftDirection);
                        return;
                    }
                }
            }
            leftDirection = (leftDirection + 3) % 4;    // 왼쪽 회전
        }
        // c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
        // d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
        if (allDirectionsAreaCleanedOrWalls(map, cleaned, currentNode, direction)) {
            int backDirection = (direction + 2) % 4;    // 후진 방향
            Node backNode = new Node(currentNode.r + MOVE_R[backDirection], currentNode.c + MOVE_C[backDirection]);
            if (backNode.r >= 0 && backNode.c >= 0 && backNode.r < map.length && backNode.c < map[0].length) {
                if (map[backNode.r][backNode.c] != WALL) {
                    searchArea(map, cleaned, backNode, direction);  // 뒤로 한칸 이동하고 정 방향 바라보기
                }
            }
        }
    }

    private boolean allDirectionsAreaCleanedOrWalls(int[][] map, boolean[][] cleaned, Node currentNode, int direction) {
        for (int i = 0; i < 4; i++) {
            Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]);
            if (nextNode.r >= 0 && nextNode.c >= 0 && nextNode.r < map.length && nextNode.c < map[0].length) {
                if (map[nextNode.r][nextNode.c] == EMPTY && !cleaned[nextNode.r][nextNode.c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
