package week12_동적계획법.X2_12015_가장긴증가하는부분수열2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by soomin on 2022/06/23
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, input));
    }
}

class Solution {
    public int solution(int n, int[] input) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int value = input[i];
            if (value > list.get(list.size() - 1)) list.add(value);
            else {
                int left = 0;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= value) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                list.set(right, value);
            }
        }
        return list.size() - 1;
    }
}
