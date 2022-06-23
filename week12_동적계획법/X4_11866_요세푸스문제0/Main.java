package week12_동적계획법.X4_11866_요세푸스문제0;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by soomin on 2022/06/23
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Solution solution = new Solution();
        solution.solution(n, k);
    }
}

class Solution {
    public void solution(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('<');
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int count = k;
            int answer = 0;
            for (int i = 0; i < count; i++) {
                answer = queue.poll();
                if (i == count - 1) {
                    break;
                }
                queue.offer(answer);
            }
            stringBuilder.append(answer).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append('>');
        System.out.println(stringBuilder);
    }
}

