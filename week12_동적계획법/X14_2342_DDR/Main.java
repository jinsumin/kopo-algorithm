package week12_동적계획법.X14_2342_DDR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by soomin on 2022/06/27
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(reader.readLine());
        while (true) {
            int direction = Integer.parseInt(st.nextToken());
            if (direction == 0) {
                break;
            }
            list.add(direction);
        }
        int[][][] dp = new int[list.size()][5][5];
        System.out.println(solution(list, dp, 0, 0, 0));
    }

    public static int solution(List<Integer> list, int[][][] dp, int index, int left, int right) {
        if (index == list.size()) {
            return 0;
        }
        if (dp[index][left][right] != 0) {
            return dp[index][left][right];
        }
        int leftFoot = solution(list, dp, index + 1, list.get(index), right) + getPosition(left, list.get(index));
        int rightFoot = solution(list, dp, index + 1, left, list.get(index)) + getPosition(right, list.get(index));
        dp[index][left][right] = Math.min(leftFoot, rightFoot);
        return dp[index][left][right];
    }

    public static int getPosition(int a, int b) {
        if (a == 0) {
            return 2;
        } else if (a == b) {
            return 1;
        } else if (Math.abs(a - b) == 2) {
            return 4;
        } else {
            return 3;
        }
    }
}
