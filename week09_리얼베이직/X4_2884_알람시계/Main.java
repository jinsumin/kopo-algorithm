package week09_리얼베이직.X4_2884_알람시계;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        Solution solution = new Solution();
        solution.solution(hour, minute);
    }
}

class Solution {
    public void solution(int hour, int minute) {
        int newHour = hour;
        int newMinute = minute - 45;
        if (newMinute < 0) {
            newMinute += 60;
            newHour -= 1;
        }
        if (newHour < 0) {
            newHour += 24;
        }
        System.out.println(newHour + " " + newMinute);
    }
}
