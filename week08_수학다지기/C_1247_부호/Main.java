package week08_수학다지기.C_1247_부호;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        for (int i = 0; i < 3; i++ ) {
            int n = scanner.nextInt();
            BigInteger[] bigIntegers = new BigInteger[n];
            for (int j = 0; j < n; j++ ) {
                bigIntegers[j] = new BigInteger(scanner.next());
            }
            solution.solution(n, bigIntegers);
        }
    }
}

class Solution {
    public void solution(int n, BigInteger[] bigIntegers) {
        BigInteger sumOfBigIntegers = new BigInteger("0");
        for (int i = 0; i < n; i++) {
            sumOfBigIntegers = sumOfBigIntegers.add(bigIntegers[i]);
        }
        if (sumOfBigIntegers.compareTo(BigInteger.valueOf(0)) > 0) {
            System.out.println("+");
        } else if (sumOfBigIntegers.compareTo(BigInteger.valueOf(0)) == 0) {
            System.out.println("0");
        } else {
            System.out.println("-");
        }
    }
}
