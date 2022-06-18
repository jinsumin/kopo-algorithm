package week11_그리디알고리즘.X5_16953_AB;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/18
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long inputA = scanner.nextInt();
        long inputB = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(inputA, inputB));
    }
}

class Solution {
    public int solution(long inputA, long inputB) {
        int answer = 1;
        while (inputA != inputB) {
            if (inputA > inputB) {
                return -1;
            }
            String str = String.valueOf(inputB);
            if (str.charAt(str.length() - 1) != '1' && inputB % 2 != 0) {
                return -1;
            }
            if (inputB % 2 == 0) {
                inputB /= 2;
            } else {
                str = str.substring(0, str.length() - 1);
                inputB = Long.parseLong(str);
            }
            answer++;
        }
        return answer;
    }
}
