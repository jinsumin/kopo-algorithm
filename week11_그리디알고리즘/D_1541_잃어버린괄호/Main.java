package week11_그리디알고리즘.D_1541_잃어버린괄호;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/06/21
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    public int solution(String input) {
        int answer = 0;
        StringTokenizer polynomials = new StringTokenizer(input, "-");
        StringTokenizer firstPolynomials = new StringTokenizer(polynomials.nextToken(), "+");
        while (firstPolynomials.hasMoreTokens()) {
            answer += Integer.parseInt(firstPolynomials.nextToken());
        }
        while (polynomials.hasMoreTokens()) {
            StringTokenizer nextPolynomials = new StringTokenizer(polynomials.nextToken(), "+");
            int temp = 0;
            while (nextPolynomials.hasMoreTokens()) {
                temp += Integer.parseInt(nextPolynomials.nextToken());
            }
            answer -= temp;
        }
        return answer;
    }
}
