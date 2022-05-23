package week07_문자열다지기.A_1152_단어의개수;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        word = word.trim();
        StringTokenizer words = new StringTokenizer(word, " ");
        System.out.println(words.countTokens());
    }
}
