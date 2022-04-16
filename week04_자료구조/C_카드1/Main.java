package week04_자료구조.C_카드1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by soomin on 2022/04/14
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution solution = new Solution();
        solution.solution(n);
    }
}

class Solution {
    public void solution(int n) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int number = 1; number <= n; number++) {
            linkedList.offer(number);
        }
        while (!linkedList.isEmpty()) {
            System.out.print(linkedList.pollFirst() + " ");
            if (linkedList.size() == 0) {
                return;
            }
            linkedList.offerLast(linkedList.pollFirst());
            if (linkedList.size() == 1) {
                System.out.print(linkedList.poll());
                return;
            }
        }
    }
}
