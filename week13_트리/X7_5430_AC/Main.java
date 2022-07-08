package week13_트리.X7_5430_AC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by soomin on 2022/07/07
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        while (testCase-- > 0) {
            String operation = reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            String[] array = reader.readLine().replace("[", "").replace("]", "").split(",");
            answer.append(ACFunction(operation, n, array)).append('\n');
        }
        System.out.println(answer);
    }

    private static StringBuilder ACFunction(String operation, int n, String[] array) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.offer(Integer.parseInt(array[i]));
        }
        boolean sign = true;
        for (int i = 0; i < operation.length(); i++) {
            char type = operation.charAt(i);
            if (type == 'R') {
                sign = !sign;
            } else {
                if (deque.isEmpty()) {
                    return new StringBuilder("error");
                }
                if (sign) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (!deque.isEmpty()) {
            if (sign) {
                result.append(deque.pollFirst());
            } else {
                result.append(deque.pollLast());
            }
            if (!deque.isEmpty()) {
                result.append(",");
            }
        }
        result.append("]");
        return result;
    }
}
