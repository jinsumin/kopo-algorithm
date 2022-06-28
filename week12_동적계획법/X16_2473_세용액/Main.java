package week12_동적계획법.X16_2473_세용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/06/27
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] inputs = new long[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Long.parseLong(st.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, inputs));
    }
}

class Solution {
    public long max = Long.MAX_VALUE;

    public StringBuilder solution(int n, long[] inputs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(inputs);
        long[] picked = new long[3];
        for (int i = 0; i < n - 2; i++) {
            twoPointerSort(inputs, i, picked);
        }
        Arrays.sort(picked);
        for (int i = 0; i < 3; i++) {
            sb.append(picked[i]).append(" ");
        }
        return sb;
    }

    private void twoPointerSort(long[] inputs, int index, long[] picked) {
        int left = index + 1;
        int right = inputs.length - 1;
        while (left < right) {
            long sum = inputs[left] + inputs[right] + inputs[index];
            if (Math.abs(sum) < max) {
                picked[0] = inputs[left];
                picked[1] = inputs[right];
                picked[2] = inputs[index];
                max = Math.abs(sum);
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}
