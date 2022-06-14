package week10_정렬과자료구조.E_11650_좌표정렬하기;

import java.util.*;

/**
 * Created by soomin on 2022/06/14
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] coordinates = new int[n][2];
        for (int i = 0; i < n; i++) {
            coordinates[i][0] = scanner.nextInt();
            coordinates[i][1] = scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.solution(n, coordinates);
    }
}

class Solution {
    public void solution(int n, int[][] coordinates) {
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            list.add(coordinates[i]);
        }
        list.sort((coordinate1, coordinate2) -> {
            if (coordinate1[0] > coordinate2[0]) {
                return 1;
            } else if (coordinate1[0] == coordinate2[0]) {
                return Integer.compare(coordinate1[1], coordinate2[1]);
            } else {
                return -1;
            }
        });
        printList(list);
    }

    private void printList(List<int[]> list) {
        for (int[] ints : list) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
