package week09_리얼베이직.X8_2407_조합;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(n, m));
    }
}

class Solution {
    public BigInteger solution(int n, int m) {
        BigInteger[][] bigIntegers = new BigInteger[101][101];
        setCombination(bigIntegers, n);
        return bigIntegers[n][m];
    }

    private void setCombination(BigInteger[][] bigIntegers, int n){
        for(int i=1;i<=n;i++){
            for(int j=0;j<=i;j++){
                if(j == 0 || j==i)
                    bigIntegers[i][j] = new BigInteger("1");
                else
                    bigIntegers[i][j] = bigIntegers[i-1][j-1].add(bigIntegers[i-1][j]);
            }
        }
    }
}
