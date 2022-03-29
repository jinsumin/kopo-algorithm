package week03_정렬.H_두_용액;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by soomin on 2022/03/26
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i ++) {
            inputs[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.solution(n, inputs);
    }
}

class Solution {

    public void solution(int n, int[] inputs) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(inputs);
        System.out.println(Arrays.toString(inputs));
        int leftPivot = 0;
        int rightPivot = n - 1;
        while (leftPivot != rightPivot) {
            int sum = inputs[leftPivot] + inputs[rightPivot];
            System.out.println("sum : " + sum);
            if (min < sum) {
                break;
            }
            if (inputs[leftPivot + 1] - inputs[leftPivot] < inputs[rightPivot] - inputs[rightPivot - 1]) {
                leftPivot++;
            } else {
                rightPivot--;
            }
            min = sum;
            System.out.println("left : " + leftPivot + "right : " + rightPivot);
        }
        System.out.println(leftPivot);
        System.out.println(rightPivot);
        System.out.println(inputs[leftPivot] + " " + inputs[rightPivot]);
    }
}
