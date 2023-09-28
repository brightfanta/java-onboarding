package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        /**
         * 1부터 number 까지 369 박수의 합
         * number 는 1~10,000의 자연수
         * 반복문 실행(0~number)
         * 해당 순서의 수를 문자열로 바꿈
         * List 저장
         * i, j.length 사용하여 각자리 숫자 중 369 찾고
         * 369가 있을 경우, cnt++
         * cnt 최종값 answer 입력
         */

        int answer = 0;

        int cnt369 = 0;

        /*while(number < 0 || number > 10_000){
            number = 13;
        }*/

        for(int i = 0; i <= number; i++){
            System.out.println("i = " + i);

            if(i < 10){
                if(i == 3 || i == 6 || i == 9){
                    cnt369++;
                    System.out.println("cnt369 = " + cnt369);
                }
            } else {
                int calNum = i;
                while(calNum > 0) {
                    if(calNum % 10 == 3 || calNum % 10 == 6 || calNum % 10== 9){
                        cnt369++;
                        System.out.println("cnt369 = " + cnt369);
                    }
                    calNum /= 10;
                }
            }
        }
        System.out.println("final cnt369 = " + cnt369);
        System.out.println();
        answer = cnt369;
        return answer;
    }
}
