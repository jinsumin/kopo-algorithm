package CASE_STUDY.week02.아이들과선물상자;

import java.util.*;

/**
 * Created by soomin on 2022/08/10
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] C = new int[N];
        int[] W = new int[M];
        for (int i = 0; i < N; i++) {
            C[i] = scanner.nextInt();
        }
        for (int i = 0; i < M; i++) {
            W[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(N, M, C, W));
    }
}

class Solution {

    public int solution(int n, int m, int[] c, int[] w) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            priorityQueue.add(c[i]);
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            linkedList.add(w[i]);
        }
        linkedList.sort(Collections.reverseOrder());
        while (!linkedList.isEmpty()) {
            int pollOfW = linkedList.pollFirst();
            if (priorityQueue.isEmpty()) {
                return 0;
            }
            int pollOfC = priorityQueue.poll();
            int restOfC = pollOfC - pollOfW;
            if (restOfC < 0) {
                return 0;
            }
            if (restOfC > 0) {
                priorityQueue.add(restOfC);
            }
        }
        return 1;
    }
}
