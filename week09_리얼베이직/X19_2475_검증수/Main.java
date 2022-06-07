package week09_리얼베이직.X19_2475_검증수;

/**
 * Created by soomin on 2022/06/07
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int[] inputs = new int[5];
        for (int i = 0; i < 5; i++) {
            inputs[i] = scanner.nextInt();
        }
        System.out.println(solution.solution(inputs));
    }
}

class Solution {
    public int solution(int[] inputs) {
        int answer = 0;
        for (int input : inputs) {
            answer += Math.pow(input, 2);
        }
        return answer % 10;
    }
}
