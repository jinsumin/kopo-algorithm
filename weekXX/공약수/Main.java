package weekXX.공약수;

import java.util.*;

/**
 * Created by soomin on 2022/08/05
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] inputs = new long[N];
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            inputs[i] = scanner.nextLong();
            if (inputs[i] < min) {
                min = inputs[i];
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(1).append("\n");
        for (int factor = 2; factor <= min; factor++) {
            boolean flag = true;
            for (int i = 1; i < N; i++) {
                if (inputs[i] % factor != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer.append(factor).append("\n");
            }
        }
        answer.deleteCharAt(answer.length() - 1);
        System.out.println(answer);
    }
}