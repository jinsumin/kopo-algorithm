package week13_트리.X2_2568_전깃줄2;

import java.io.*;
import java.util.*;

/**
 * Created by soomin on 2022/07/01
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] linkedLines = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            linkedLines[i][0] = Integer.parseInt(st.nextToken());
            linkedLines[i][1] = Integer.parseInt(st.nextToken());
        }
        Solution solution = new Solution();
        solution.solution(n, linkedLines);
    }
}

class Solution {
    private int[] memo;

    public void solution(int n, int[][] linkedLines) {
        memo = new int[n];
        List<Integer> list = new ArrayList<>();
        list.add(-10000);
        Arrays.sort(linkedLines, Comparator.comparingInt(a -> a[0]));
        System.out.println(binarySearch(n, linkedLines, list));
        System.out.println(removedLines(n, linkedLines, list));
    }

    private int binarySearch(int n, int[][] linkedLines, List<Integer> list) {
        for (int i = 0; i < n; i++) {
            if(list.get(list.size() - 1) < linkedLines[i][1]) {
                list.add(linkedLines[i][1]);
                memo[i] = list.size() - 1;
            } else {
                int left = 1;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) < linkedLines[i][1]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, linkedLines[i][1]);
                memo[i] = right;
            }
        }
        return n - (list.size() - 1);
    }

    private StringBuilder removedLines(int n, int[][] linkedLines, List<Integer> list) {
        StringBuilder answer = new StringBuilder();
        int index = list.size() - 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (memo[i] == index) {
                index--;
            } else {
                stack.push(linkedLines[i][0]);
            }
        }
        while (!stack.isEmpty()) {
            answer.append(stack.pop()).append('\n');
        }
        return answer;
    }
}
