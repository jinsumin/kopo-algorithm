package week03_정렬.H_두_용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/03/26
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] inputs = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i ++) {
            inputs[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Solution solution = new Solution();
        solution.solution(n, inputs);
    }
}

class Solution {

    public void solution(int n, int[] inputs) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(inputs);
        int leftPivot = 0;
        int rightPivot = n - 1;
        int leftTarget = 0, rightTarget = 0;
        while (leftPivot < rightPivot) {
            int sum = inputs[leftPivot] + inputs[rightPivot];
            if (Math.abs(sum) < min) {
                leftTarget = inputs[leftPivot];
                rightTarget = inputs[rightPivot];
                min = Math.abs(sum);
            }
            if (sum < 0) {
                leftPivot++;
            } else {
                rightPivot--;
            }
        }
        System.out.println(leftTarget + " " + rightTarget);
    }
}
