package week12_동적계획법.X5_10816_숫자카드2;

import java.util.*;

/**
 * Created by soomin on 2022/06/23
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] ownedCards = new int[m];
        for (int i = 0; i < m; i++) {
            ownedCards[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.solution(n, m, cards, ownedCards);
    }
}

class Solution {
    public void solution(int n, int m, int[] cards, int[] ownedCards) {
        StringBuilder answer = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(ownedCards[i], 0);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(cards[i])) {
                map.replace(cards[i], map.get(cards[i]) + 1);
            }
        }
        for (int i = 0; i < m; i++) {
            answer.append(map.get(ownedCards[i])).append(" ");
        }
        System.out.println(answer);
    }
}
