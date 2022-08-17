package CASE_STUDY.카드;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by soomin on 2022/08/10
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Solution solution = new Solution();
        solution.solution(N);
    }
}

class Solution {

    public void solution(int N) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int number = N; number >= 1; number--) {
            list.addFirst(number);
            for (int rotate = 0; rotate < number; rotate++) {
                int element = list.pollLast();
                list.addFirst(element);
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            answer.append(list.get(i)).append(" ");
        }
        System.out.println(answer);
    }
}
