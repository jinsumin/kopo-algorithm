package week04_자료구조.A_단어순서_뒤집기;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/04/13
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] inputs = new String[n];
        for (int i = 0; i < n; i ++) {
            inputs[i] = scanner.nextLine();
        }
        Solution solution = new Solution();
        solution.solution(n, inputs);
    }
}

class Solution {
    public void solution(int n, String[] inputs) {
        for (int i = 0; i < n; i ++){
            Stack<String> stack = new Stack<>();
            StringTokenizer st = new StringTokenizer(inputs[i], " ");
            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }
            System.out.print("Case #" + (i + 1) + ": ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
    }
}
