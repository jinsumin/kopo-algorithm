package week12_동적계획법.X17_14003_가장긴증가하는부분수열5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/06/28
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] inputs = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, inputs));
    }
}

class Solution {

    public StringBuilder solution(int n, int[] inputs) {
        StringBuilder answer = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            if (list.get(list.size() - 1) < inputs[i]) {
                list.add(inputs[i]);
                indexes[i] = list.size() - 1;
            }
            else {
                int left = 1;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) < inputs[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, inputs[i]);
                indexes[i] = right;
            }
        }
        answer.append(list.size() - 1).append("\n");
        int index = list.size() - 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (indexes[i] == index) {
                index--;
                stack.push(inputs[i]);
            }
        }
        while (!stack.empty()) {
            answer.append(stack.pop()).append(" ");
        }
        return answer;
    }
}
