package week09_리얼베이직.X11_15686_치킨배달;

// package chicken_delivery_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by SOOMIN on 2020-04-11.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j ++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map, m));
    }
}

class Solution {
    private static final int CHICKEN_HOUSE = 2;
    private static final int HOME = 1;
    private static final int EMPTY = 0;

    private ArrayList<Integer> arrayList = new ArrayList<>();
    private LinkedList<Home> listOfHome = new LinkedList<>();
    private LinkedList<ChickenHouse> listOfChickenHouse = new LinkedList<>();

    private static class Home {
        int r, c;
        public Home(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static class ChickenHouse {
        int r, c;
        boolean selected = false;
        public ChickenHouse(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] map, int m) {
        for (int i = 0; i < map.length; i ++) {
            for (int j = 0; j < map[0].length; j ++) {
                if (map[i][j] == HOME) {
                    listOfHome.add(new Home(i, j));
                } else if(map[i][j] == CHICKEN_HOUSE) {
                    listOfChickenHouse.add(new ChickenHouse(i, j));
                }
            }
        }
        selectChickenHouse(0, m);
        Collections.sort(arrayList);
        return arrayList.get(0);
    }

    private void selectChickenHouse(int start, int r) {
        if(r == 0) {
            calculateMinChickenDistance();
        } else {
            for(int i = start; i < listOfChickenHouse.size(); i ++) {
                listOfChickenHouse.get(i).selected = true;
                selectChickenHouse(i + 1, r - 1);
                listOfChickenHouse.get(i).selected = false;
            }
        }
    }

    private void calculateMinChickenDistance() {
        int result = 0;
        for (int i = 0; i < listOfHome.size(); i ++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < listOfChickenHouse.size(); j ++) {
                if (listOfChickenHouse.get(j).selected) {
                    int newMin = chickenDistance(listOfHome.get(i), listOfChickenHouse.get(j));
                    if (newMin < min) {
                        min = newMin;
                    }
                }
            }
            result += min;
        }
        arrayList.add(result);
    }

    private int chickenDistance(Home home, ChickenHouse chickenHouse) {
        return Math.abs(home.r - chickenHouse.r) + Math.abs(home.c - chickenHouse.c);
    }
}
