package week13_트리.X3_10775_공항;

import java.io.*;

/**
 * Created by soomin on 2022/07/01
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(reader.readLine());
        int P = Integer.parseInt(reader.readLine());
        int[] docks = new int[G + 1];
        for (int i = 1; i < G + 1; i++) {
            docks[i] = i;
        }
        int[] inputs = new int[P];
        for (int i = 0; i < P; i++) {
            inputs[i] = Integer.parseInt(reader.readLine());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(P, docks, inputs));
    }
}

class Solution {

    public int solution(int P, int[] docks, int[] inputs) {
        int answer = 0;
        for (int i = 0; i < P; i++) {
            int wrongGate = find(docks, inputs[i]);
            if (wrongGate == 0) {
                break;
            }
            answer++;
            merge(docks, wrongGate, wrongGate - 1);
        }
        return answer;
    }

    private int find(int[] docks, int target) {
        if (target == docks[target]) {
            return target;
        }
        return docks[target] = find(docks, docks[target]);
    }

    private void merge(int[] docks, int targetA, int targetB) {
        targetA = find(docks, targetA);
        targetB = find(docks, targetB);
        if (targetA != targetB) {
            docks[targetA] = targetB;
        }
    }
}
