package week03_정렬.A_일곱_난쟁이;

import java.util.*;

/**
 * Created by soomin on 2022/03/25
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] inputs = new Integer[9];
        for (int i = 0; i < 9; i ++) {
            inputs[i] = scanner.nextInt();
        }
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(inputs));
        Solution2 solution = new Solution2();
        // solution.solution(inputs);
        solution.solution(arrayList);
    }
}

class Solution {
    public void solution(int[] inputs) {
        int sumOfHeight = 100;
        int sumOfInputs = Arrays.stream(inputs).sum();
        int targetA, targetB;
        int length = inputs.length;
        Arrays.sort(inputs);
        for (int i = 0; i < length - 1; i ++) {
            targetA = inputs[i];
            for (int j = i + 1; j < length; j ++) {
                targetB = inputs[j];
                if (sumOfInputs - (targetA + targetB) == sumOfHeight) {
                    printAnswer(inputs, targetA, targetB);
                    return;
                }
            }
        }
    }

    private void printAnswer(int[] inputs, int targetA, int targetB) {
        for (int input : inputs) {
            if (input != targetA && input != targetB) {
                System.out.println(input);
            }
        }
    }
}

class Solution2 {
    public void solution(ArrayList<Integer> arrayList) {
        Collections.sort(arrayList);
        boolean[] selected = new boolean[9];
        combination(arrayList, selected, 0, 9, 7);
    }

    private void combination(ArrayList<Integer> arrayList, boolean[] selected, int startIndex, int n, int r) {
        if (r == 0) {
            if (sumOfHeight(arrayList, selected) == 100) {
                printArrayList(arrayList, selected);
                System.exit(0);
            }
        }
        for (int i = startIndex; i < n; i ++) {
            selected[i] = true;
            combination(arrayList, selected, i + 1, n, r - 1);
            selected[i] = false;
        }
    }

    private int sumOfHeight(ArrayList<Integer> arrayList, boolean[] selected) {
        int sum = 0;
        for (int i = 0; i < 9; i ++) {
            if (selected[i]) {
                sum += arrayList.get(i);
            }
        }
        return sum;
    }

    private void printArrayList(ArrayList<Integer> arrayList, boolean[] selected) {
        for (int i = 0; i < 9; i ++) {
            if (selected[i]) {
                System.out.println(arrayList.get(i));
            }
        }
    }
}
