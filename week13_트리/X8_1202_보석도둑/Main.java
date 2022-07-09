package week13_트리.X8_1202_보석도둑;

import java.io.*;
import java.util.*;

/**
 * Created by soomin on 2022/07/08
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Jewel> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arrayList.add(new Jewel(m, v));
        }
        arrayList.sort((o1, o2) -> o1.m - o2.m);
        int[] weights = new int[k];
        for (int i = 0; i < k; i++) {
            weights[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(weights);
        long answer = 0;
        int listIndex = 0;
        PriorityQueue<Jewel> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
        for (int i = 0; i < k; i++) {
            while (listIndex < n && arrayList.get(listIndex).m <= weights[i]) {
                Jewel currentJewel = arrayList.get(listIndex++);
                priorityQueue.add(new Jewel(currentJewel.m, currentJewel.v));
            }
            if (!priorityQueue.isEmpty()) {
                answer += priorityQueue.poll().v;
            }
        }
        System.out.println(answer);
    }

    public static class Jewel {
        int m, v;

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
