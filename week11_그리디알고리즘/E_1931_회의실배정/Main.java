package week11_그리디알고리즘.E_1931_회의실배정;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by soomin on 2022/06/21
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, starts, ends));
    }
}

class Solution {

    public int solution(int n, int[] starts, int[] ends) {
        int answer = 1;
        ArrayList<Meeting> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Meeting meeting = new Meeting();
            meeting.start = starts[i];
            meeting.end = ends[i];
            arrayList.add(meeting);
        }
        arrayList.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.end > o2.end) {
                    return 1;
                } else if (o1.end == o2.end) {
                    return Integer.compare(o1.start, o2.start);
                } else {
                    return -1;
                }
            }
        });
        Stack<Meeting> stack = new Stack<>();
        stack.push(arrayList.get(0));
        for (int i = 1; i < n; i++) {
            if (stack.peek().end <= arrayList.get(i).start) {
                answer++;
                stack.push(arrayList.get(i));
            }
        }
        return answer;
    }
}

class Meeting {
    public int start;
    public int end;
}