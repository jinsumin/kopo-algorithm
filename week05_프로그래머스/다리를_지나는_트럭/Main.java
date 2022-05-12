package week05_프로그래머스.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution.solution(2, 10, truck_weights));
    }
}
class Solution {
    public int solution(int bridge_length, int maxWeight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0, sumOfWeight = 0;
        for (int truck : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.offer(truck);
                    sumOfWeight += truck;
                    time++;
                    break;
                } else if (queue.size() == bridge_length) {
                    sumOfWeight -= queue.poll();
                } else {
                    if (sumOfWeight + truck <= maxWeight) {
                        queue.offer(truck);
                        sumOfWeight += truck;
                        time++;
                        break;
                    } else {
                        queue.offer(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}
