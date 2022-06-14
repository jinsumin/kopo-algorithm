package week10_정렬과자료구조.G_10866_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created by soomin on 2022/06/14
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] commands = new String[n];
        for (int i = 0; i < n; i++) {
            commands[i] = bufferedReader.readLine();
        }
        Solution solution = new Solution();
        solution.solution(n, commands);
    }
}

class Solution {

    public void solution(int n, String[] commands) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] command = commands[i].split(" ");
            switch (command[0]) {
                case "push_front":
                    int element = Integer.parseInt(command[1]);
                    list.offerFirst(element);
                    break;
                case "push_back":
                    element = Integer.parseInt(command[1]);
                    list.offerLast(element);
                    break;
                case "pop_front":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.pollFirst());
                    }
                    break;
                case "pop_back":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.pollLast());
                    }
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "empty":
                    if (list.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.peekFirst());
                    }
                    break;
                case "back":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.peekLast());
                    }
                    break;
            }
        }
    }
}
