package week12_동적계획법.X19_1208_부분수열의합;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/06/29
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] inputs = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, s, inputs));
    }
}

class Solution {
    private long count = 0;

    public long solution(int n, int s, int[] inputs) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        makeSum(inputs, leftList, 0, 0, n / 2);
        makeSum(inputs, rightList, 0, n / 2, n);
        Collections.sort(leftList);
        Collections.sort(rightList);
        solve(leftList, rightList, s);
        if (s == 0) {
            return count - 1;
        }
        return count;
    }

    private void makeSum(int[] inputs, List<Integer> list, int sum, int start, int end) {
        if (start == end) {
            list.add(sum);
            return;
        }
        makeSum(inputs, list, sum, start + 1, end);
        makeSum(inputs, list, sum + inputs[start], start + 1, end);
    }

    private void solve(List<Integer> leftList, List<Integer> rightList, int s) {
        int leftPointer = 0;
        int rightPointer = rightList.size() - 1;
        while (leftPointer != leftList.size() && rightPointer >= 0) {
            int leftValue = leftList.get(leftPointer);
            int rightValue = rightList.get(rightPointer);
            if (leftValue + rightValue == s) {
                long leftCount = 0;
                while (leftPointer < leftList.size() && leftList.get(leftPointer) == leftValue) {
                    leftCount++;
                    leftPointer++;
                }
                long rightCount = 0;
                while (rightPointer >= 0 && rightList.get(rightPointer) == rightValue) {
                    rightCount++;
                    rightPointer--;
                }
                count += (leftCount * rightCount);
            }
            if (leftValue + rightValue > s) {
                rightPointer--;
            }
            if (leftValue + rightValue < s) {
                leftPointer++;
            }
        }
    }
}
