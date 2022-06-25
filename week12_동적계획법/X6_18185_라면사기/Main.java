package week12_동적계획법.X6_18185_라면사기;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] factories = new int[n + 2];
        for (int i = 0; i < n; i++) {
            factories[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, factories));
    }
}

class Solution {
    public int solution(int n, int[] factories) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (factories[i + 1] > factories[i + 2]) {
                int case2 = Math.min(factories[i], factories[i + 1] - factories[i + 2]);
                answer += case2 * 5;
                factories[i] -= case2;
                factories[i + 1] -= case2;
                int case3 = Math.min(factories[i], Math.min(factories[i + 1], factories[i + 2]));
                answer += case3 * 7;
                factories[i] -= case3;
                factories[i + 1] -= case3;
                factories[i + 2] -= case3;
            } else {
                int case3 = Math.min(factories[i], Math.min(factories[i + 1], factories[i + 2]));
                answer += case3 * 7;
                factories[i] -= case3;
                factories[i + 1] -= case3;
                factories[i + 2] -= case3;
                int case2 = Math.min(factories[i], factories[i + 1]);
                answer += case2 * 5;
                factories[i] -= case2;
                factories[i + 1] -= case2;
            }
            int case1 = factories[i];
            answer += case1 * 3;
        }
        return answer;
    }
}
