package week08_수학다지기.D_1252_이진수덧셈;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputA = scanner.next();
        String inputB = scanner.next();
        Solution solution = new Solution();
        System.out.println(solution.solution(inputA, inputB));
    }
}

class Solution {
    public String solution(String inputA, String inputB) {
        BigInteger bigA = new BigInteger(inputA, 2);
        BigInteger bigB = new BigInteger(inputB, 2);
        return addWithBit(bigA, bigB).toString(2);
    }

    private BigInteger addWithBit(BigInteger bigA, BigInteger bigB) {
        if(Objects.equals(bigB, BigInteger.ZERO)) {
            return bigA;
        }
        BigInteger sum = bigA.xor(bigB);
        BigInteger carry = bigA.and(bigB).shiftLeft(1);
        return addWithBit(sum, carry);
    }
}
