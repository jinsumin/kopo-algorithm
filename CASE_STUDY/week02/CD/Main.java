package CASE_STUDY.week02.CD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/08/11
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int answer = 0;
        while (n != 0 && m != 0) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int number = Integer.parseInt(reader.readLine());
                set.add(number);
            }
            for (int i = 0; i < m; i++) {
                int number = Integer.parseInt(reader.readLine());
                if (set.contains(number)) {
                    answer++;
                }
            }
            System.out.println(answer);
            stringTokenizer = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());
            answer = 0;
        }
    }
}
