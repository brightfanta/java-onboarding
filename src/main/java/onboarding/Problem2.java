package onboarding;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {
    public static String solution(String cryptogram) {

        /**
         * 문자입력 받기(길이가 1~1000/알파벳 소문자로만 구성)
         * length 1001부터는 예외처리 해버린다.
         * try-catch 예외처리 한다.
         *
         * 문자열로 반환
         * 반복하면서 연속되는 숫자 삭제
         * 연속하는 숫자 없을 경우 최종 결과 출력
         */
        boolean flag = true;


        do {
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if(cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    System.out.println("cryptogram before substring = " + cryptogram);
                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);
                    System.out.println("cryptogram after substring = " + cryptogram);
                    break;
                }
                if (i == cryptogram.length() - 2) {
                    flag = false;
                    break;
                }
            }

        } while (cryptogram.length() != 0 && flag);

        System.out.println("final cryptogram = " + cryptogram);
        System.out.println();

        String answer = cryptogram;
        return answer;
    }
}
