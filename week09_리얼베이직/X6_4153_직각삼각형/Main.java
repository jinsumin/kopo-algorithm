package week09_리얼베이직.X6_4153_직각삼각형;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        String input = scanner.nextLine();
        while (!input.equals("0 0 0")){
            solution.solution(input);
            input = scanner.nextLine();
        }
    }
}

class Solution {
    public void solution(String input) {
        String[] inputs = input.split(" ");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(String length : inputs) {
            arrayList.add((int) Math.pow(Integer.parseInt(length), 2));
        }
        arrayList.sort(Collections.reverseOrder());
        if (arrayList.get(0) == arrayList.get(1) + arrayList.get(2)) {
            System.out.println("right");
        } else {
            System.out.println("wrong");
        }
    }
}
