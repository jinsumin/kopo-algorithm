package COS_Pro.DAY06.prob01;

import java.util.*;

/**
 * Created by soomin on 2022/09/07
 * 토마토 BFS 문제
 */
public class Main {
    private static final int[] DIRECTION_R = {0, 1, 0, -1};
    private static final int[] DIRECTION_C = {1, 0, -1, 0};

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int n, int[][] garden) {
        int answer = 0;
        // 여기에 코드를 작성해주세요.
        Queue<Node> nodes = new LinkedList<Node>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (garden[r][c] == 1) {
                    nodes.offer(new Node(r, c));
                }
            }
        }
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int s = 0; s < size; s++) {
                Node current = nodes.poll();
                for (int i = 0; i < 4; i++) {
                    Node next = new Node(current.r + DIRECTION_R[i], current.c + DIRECTION_C[i]);
                    if (next.r >= 0 && next.r < n
                            && next.c >= 0 && next.c < n) {
                        if (garden[next.r][next.c] == 0) {
                            garden[next.r][next.c] = 1;
                            nodes.offer(next);
                        }
                    }
                }
            }
            answer++;
        }
        return answer - 1;
    }


    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int n1 = 3;
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(n1, garden1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int n2 = 2;
        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(n2, garden2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

    }
}