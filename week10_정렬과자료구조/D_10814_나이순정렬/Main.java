package week10_정렬과자료구조.D_10814_나이순정렬;

import java.util.Scanner;

/**
 * Created by soomin on 2022/06/14
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] peoples = new String[n][2];
        for (int i = 0; i < n; i++) {
            peoples[i][0] = scanner.next();
            peoples[i][1] = scanner.next();
        }
        Solution solution = new Solution();
        solution.solution(n, peoples);
    }
}

class Solution {

    public void solution(int n, String[][] peoples) {
        StringBuilder[] memo = new StringBuilder[201];
        for (int i = 1; i < 201; i++) {
            memo[i] = new StringBuilder();
        }
        for (int i = 0; i < n; i++) {
            memo[Integer.parseInt(peoples[i][0])].append(peoples[i][1]).append(",");
        }
        for (int i = 1; i < 201; i++) {
            if (!String.valueOf(memo[i]).equals("")) {
                String[] result = String.valueOf(memo[i]).split(",");
                for (String s : result) {
                    System.out.println(i + " " + s);
                }
            }
        }
    }
}
