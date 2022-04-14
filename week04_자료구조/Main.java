package week04_자료구조;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by soomin on 2022/04/13
 */

public class Main {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.poll();
        queue.poll();
        System.out.println(queue);
    }
}
