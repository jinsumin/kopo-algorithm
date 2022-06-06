package week09_리얼베이직.X2_1546_평균;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i ++) {
            scores[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, scores));
    }
}

class Solution {
    public double solution(int n, double[] scores) {
        double max = findMax(n, scores);
        manufactureScores(n, scores, max);
        return getAverage(n, scores);
    }

    private double getAverage(int n, double[] scores) {
        double sum = 0;
        for (int i = 0; i < n; i ++) {
            sum += scores[i];
        }
        return sum / n;
    }

    private void manufactureScores(int n, double[] scores, double max) {
        for (int i = 0; i < n; i ++) {
            scores[i] = scores[i] / max * 100;
        }
    }

    private double findMax(int n, double[] scores) {
        double max = 0;
        for (int i = 0; i < n; i++ ) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }
}
