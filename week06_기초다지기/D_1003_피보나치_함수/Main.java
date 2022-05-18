package week06_기초다지기.D_1003_피보나치_함수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        Solution solution = new Solution();
        for (int i = 0; i < testCase; i++) {
            int input = scanner.nextInt();
            solution.solution(input);
        }
    }
}

class Solution {
    public void solution(int input) {
        int[] memoOfZero = new int[41];
        int[] memoOfOne = new int[41];
        memoOfZero[0] = 1;
        memoOfZero[1] = 0;
        memoOfZero[2] = 1;
        memoOfZero[3] = 1;
        memoOfOne[0] = 0;
        memoOfOne[1] = 1;
        memoOfOne[2] = 1;
        memoOfOne[3] = 2;
        for (int i = 4; i <= input; i++) {
            memoOfZero[i] = memoOfZero[i - 1] + memoOfZero[i - 2];
            memoOfOne[i] = memoOfOne[i - 1] + memoOfOne[i - 2];
        }
        System.out.println(memoOfZero[input] + " " + memoOfOne[input]);
    }
}
