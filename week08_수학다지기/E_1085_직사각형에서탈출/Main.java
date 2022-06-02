package week08_수학다지기.E_1085_직사각형에서탈출;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(x, y, w, h));
    }
}

class Solution {
    public int solution(int x, int y, int w, int h) {
        return Math.min(Math.min(Math.min(w - x, h - y), x), y);
    }
}
