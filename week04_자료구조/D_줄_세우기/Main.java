package week04_자료구조.D_줄_세우기;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by soomin on 2022/04/16
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.solution(n, inputs);
    }
}

class Solution {
    public void solution(int n, int[] inputs) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int studentNo = i + 1;
            if (linkedList.isEmpty()) {
                linkedList.add(studentNo);
            } else {
                int index = inputs[i];
                int size = linkedList.size();
                linkedList.add(size - index, studentNo);
            }
        }
        printStudent(linkedList);
    }

    private void printStudent(LinkedList<Integer> linkedList) {
        while (!linkedList.isEmpty()) {
            System.out.print(linkedList.pollFirst() + " ");
        }
    }
}
