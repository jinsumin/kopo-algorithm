package week09_리얼베이직.X_1019_책페이지;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int end = sc.nextInt();
        Solution solution = new Solution();
        solution.solution(end);
    }
}

class Solution {
    public void solution(int end) {
        int digit = 1;
        int start = 1;
        int[] cnt = new int[10];
        while (start <= end) {
            while (start % 10 != 0 && start <= end) {
                count(cnt, start, digit);
                start++;
            }
            while (end % 10 != 9 && start <= end) {
                count(cnt, end, digit);
                end--;
            }
            if (start > end) break;
            start /= 10;
            end /= 10;
            for (int i = 0; i < 10; ++i) {
                cnt[i] += (end - start + 1) * digit;
            }
            digit *= 10;
        }
        for (long i : cnt) {
            System.out.print(i + " ");
        }
    }

    private void count(int[] cnt, int num, int digit) {
        while (num > 0) {
            cnt[num % 10] += digit;
            num /= 10;
        }
    }
}
