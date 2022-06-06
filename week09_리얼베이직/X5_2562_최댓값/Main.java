package week09_리얼베이직.X5_2562_최댓값;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[9];
        for (int i = 0; i < 9; i++ ){
            scores[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.solution(scores);
    }
}

class Solution {
    public void solution(int[] scores) {
        int maxScore = 0;
        int indexOfMaxScore = 0;
        for (int i = 0; i < 9; i++ ) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                indexOfMaxScore = i + 1;
            }
        }
        System.out.println(maxScore);
        System.out.println(indexOfMaxScore);
    }
}
