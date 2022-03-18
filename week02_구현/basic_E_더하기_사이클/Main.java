package week02_구현.basic_E_더하기_사이클;

import java.util.Scanner;

/**
 * Created by soomin on 2022/03/18
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    public int solution(int input) {
        int answer = 0;
        int nextNumber = input;
        do {
            answer++;
            int sum = (nextNumber / 10) + nextNumber % 10;
            nextNumber = ((nextNumber % 10) * 10) + (sum % 10);
        } while (input != nextNumber);
        return answer;
    }
}
