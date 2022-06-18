package week10_정렬과자료구조.XX;

/**
 * Created by soomin on 2022/06/16
 */
//package Day10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = sc.nextInt();
            }
            int mog = arr[2] / arr[0];
            int mod = arr[2] % arr[0];

            String mog1 = mog + "";
            int mog2 = mog + 1;

            if (mod == 0) {
                if (mog < 10) {
                    System.out.println((arr[0] + ",0" + mog));
                } else {
                    System.out.println((arr[0] + "," +mog1));
                }
            } else {
                if (mog < 10) {
                    System.out.println((mod + ",0" + mog2));
                } else {
                    System.out.println((mod + "," + mog2));
                }
            }
        }
    }
}
