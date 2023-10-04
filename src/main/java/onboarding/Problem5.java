package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem5 {
    public static List<Integer> solution(int money) {
        /**
         * 금액권에 해당하는 금액으로 나누고 몫 저장, 나머지 저장
         * 나머지를 다음 순서 금액권으로 나누고 몫, 나머지 저장
         * 나머지 == 0 일 때까지 반복 후 배열 만들어 출력
         * 나머지는 계속 갱신, 몫은 리스트 순서별로 입력 받기
         */
        //50000, 10000, 5000, 1000, 500, 100, 10, 1

        if (money < 1 || money > 1_000_000) {
            return null;
        }

        List<Integer> bills = new ArrayList<>();
        bills.add(50000);
        bills.add(10000);
        bills.add(5000);
        bills.add(1000);
        bills.add(500);
        bills.add(100);
        bills.add(50);
        bills.add(10);
        bills.add(1);

        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>(); // new 로 빈 객체를 생성해주어야 변경 method 사용 가능함!!
//        Scanner sc = new Scanner(System.in);

        /*do {
            money = sc.nextInt();
        } while(money < 1 || money > 1_000_000);*/

        int divide = 0;
        int dividend = 0;

        for (int i = 0; i < bills.size(); i++) {
            if(i == 0){
                divide = money / bills.get(i);
                dividend = money % bills.get(i);
            }
            else{
                divide = dividend / bills.get(i);
                dividend = dividend % bills.get(i);
            }
            answer.add(divide);
        }

        return answer;
    }
}
