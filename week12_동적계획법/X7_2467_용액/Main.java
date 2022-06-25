package week12_동적계획법.X7_2467_용액;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] inputs = new long[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.solution(n, inputs);
    }
}

class Solution {

    public void solution(int n, long[] inputs) {
        long min = Long.MAX_VALUE;
        int leftTarget = 0, rightTarget = 0;
        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                long sum = Math.abs(inputs[i] + inputs[mid]);
                if (min > sum) {
                    min = sum;
                    leftTarget = i;
                    rightTarget = mid;
                }
                if (inputs[mid] >= -inputs[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        System.out.println(inputs[leftTarget] + " " + inputs[rightTarget]);
    }
}
