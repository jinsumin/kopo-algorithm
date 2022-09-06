package CASE_STUDY.Eureka;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by soomin on 2022/09/06
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int number = scanner.nextInt();
            Solution sol = new Solution();
            System.out.println(sol.solution(number));
        }
    }
}

class Solution {
    private static final int[] EUREKA = new int[1001];
    private static boolean flag = false;

    public int solution(int number) {
        initEurekaArray();
        flag = false;
        return isComposedThreeTriangulation(number);
    }

    private void initEurekaArray() {
        EUREKA[0] = 0;
        for (int i = 1; i < 1000; i++) {
            EUREKA[i] = EUREKA[i - 1] + i;
        }
    }

    private int isComposedThreeTriangulation(int number) {
        LinkedList<Integer> list = new LinkedList<>();
        reCombination(number, list, 1000, 3, 1);
        if (flag) {
            return 1;
        } else {
            return 0;
        }
    }

    private void reCombination(int number, LinkedList<Integer> list, int n, int r, int index) {
        if (EUREKA[index] >= number) {
            return;
        }
        if (r == 0) {
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            if (sum == number) {
                flag = true;
                return;
            }
            return;
        }
        if (index == n) {
            return;
        }
        list.add(EUREKA[index]);
        reCombination(number, list, n, r - 1, index);
        list.removeLast();
        reCombination(number, list, n, r, index + 1);
    }
}
