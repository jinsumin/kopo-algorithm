package COS_Pro.DAY06.prob02;

import java.util.*;

/**
 * Created by soomin on 2022/09/07
 */
public class Main {
    public int solution(int K, String[] words) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                temp.append(words[i]);
                System.out.println(temp);
                answer++;
            }
            if (temp.length() + words[i].length() <= K) {
                temp.append(words[i]).append("_");
            } else {
                System.out.println(temp);
                temp = new StringBuilder();
                temp.append(words[i]).append("_");
                answer++;
            }
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int K = 10;
        String[] words = {new String("nice"), new String("happy"), new String("hello"), new String("world"), new String("hi"), new String("t")};
        int ret = sol.solution(K, words);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소의 반환 값은 " + ret + " 입니다.");
    }
}