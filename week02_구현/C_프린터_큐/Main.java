package week02_구현.C_프린터_큐;

import java.util.*;

/**
 * Created by soomin on 2022/03/18
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase-- > 0) {
            int n = scanner.nextInt();
            int targetIndex = scanner.nextInt();
            int[] priority = new int[n];
            for (int i = 0; i < n; i++) {
                priority[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            System.out.println(solution.solution(n, targetIndex, priority));
        }
    }
}

class Solution {
    public int solution(int n, int targetIndex, int[] priority) {
        int answer = 0;
        LinkedList<Node> linkedList = new LinkedList<>();
        for (int index = 0; index < n; index++) {
            linkedList.offer(new Node(index, priority[index]));
        }
        while (!linkedList.isEmpty()) {
            Node currentNode = linkedList.poll();
            answer++;
            int size = linkedList.size();
            boolean flag = true;
            for (int i = 0; i < size; i++) {
                if (linkedList.get(i).getPriority() > currentNode.getPriority()) {
                    linkedList.offer(currentNode);
                    answer--;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (currentNode.getIndex() == targetIndex) {
                    return answer;
                }
            }
        }
        return answer;
    }
}

class Node {
    private int index;
    private int priority;

    public Node(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
