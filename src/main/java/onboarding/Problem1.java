package onboarding;

import java.util.*;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        //난수 생성(1~400)
        Random rand = new Random();

        int pageNum = 0;
        /*pobi = new ArrayList<>(2); // ArrayList size 설정
        crong = new ArrayList<>(2);*/

        /*while(pobi.isEmpty()){
            pageNum = rand.nextInt(401);
            //예외 처리: 시작면이나 마지막면 나오면 책 다시 펼치기
            if (pageNum == 0 || pageNum == 400) {
                continue;
            } else {
                if ((pageNum % 2) == 0) {
                    pobi.add(0, pageNum - 1);
                    pobi.add(1, pageNum);
                } else {
                    pobi.add(0, pageNum);
                    pobi.add(1, pageNum + 1);
                }
                for (Integer i : pobi) {
                    System.out.println("pobi's page = " + i);
                }
            }
        }

        while(crong.isEmpty()){
            pageNum = rand.nextInt(401);
            //예외 처리: 시작면이나 마지막면 나오면 책 다시 펼치기
            if (pageNum == 0 || pageNum == 400) {
                continue;
            } else {
                if ((pageNum % 2) == 0) {
                    crong.add(0, pageNum - 1);
                    crong.add(1, pageNum);
                } else {
                    crong.add(0, pageNum);
                    crong.add(1, pageNum + 1);
                }
                for (Integer i : crong) {
                    System.out.println("crong's page = " + i);
                }

            }
        }*/

        boolean pobiPageCheck = true;
        boolean crongPageCheck = true;

        for(Integer page : pobi){
            System.out.println("pobi's page = " + page);
        }
        for(Integer page : crong){
            System.out.println("crong's page = " + page);
        }
        if ((pobi.get(1) - pobi.get(0)) != 1){
            pobiPageCheck = false;
        }
        if ((crong.get(1) - crong.get(0)) != 1){
            pobiPageCheck = false;
        }

        if (pobi.size() != 2 || crong.size() != 2) {
            return 0;
        }

        if(!(pobiPageCheck && crongPageCheck)){
            System.out.println("pobiPageCheck = " + pobiPageCheck);
            System.out.println("crongPageCheck = " + crongPageCheck);
            answer = -1;
            System.out.println("Check answer = " + answer);
        } else {

            int pobiMaxNumber = getPobiMaxNumber(pobi);
            int crongMaxNumber = getCrongMaxNumber(crong);

            System.out.println();
            System.out.println("crongMaxNumber = " + crongMaxNumber);
            System.out.println("pobiMaxNumber = " + pobiMaxNumber);

            if (pobiMaxNumber > crongMaxNumber) {
                answer = 1;
            } else if (pobiMaxNumber < crongMaxNumber) {
                answer = 2;
            } else if (pobiMaxNumber == crongMaxNumber) {
                answer = 0;
            }
            System.out.println("answer = " + answer);
            System.out.println();
        }
        //왼쪽페이지(홀수) 숫자를 각자리 숫자로 쪼개기

        // 각자리 숫자의 합 또는 곱 최대값 찾기

        //오른쪽페이지(짝수) 숫자를 각자리 숫자로 쪼개기

        // 각자리 숫자의 합 또는 곱 최대값 찾기

        //왼쪽 페이지 최대값과 오른쪽페이지 최대값 비교 후 최종 최대값 선정

        //포비와 크롱 각각에 대해 최종 최대값 선정

        //각 값을 비교 후 결과 출력(1, 0, -1)



        //왼쪽이 작은 홀수, 오른쪽이 큰홀수

        //pobi crong 의 길이는 2

        return answer;
    }

    private static int getCrongMaxNumber(List<Integer> crong) {
        int crongMaxNumber = 0;
        for(Integer crongPage : crong){
            int crongTemp = crongPage;
            int crongNumber = 0;
            int crongMultiplyNum = 1;
            while(crongTemp != 0){
                crongNumber += crongTemp % 10;
                crongTemp /= 10;
            }
            System.out.println("crongSumNumber = " + crongNumber);
            crongMaxNumber = max(crongMaxNumber, crongNumber);
//            System.out.println("crongMaxNumber = " + crongMaxNumber);
//            numCnt = pobiPage.toString().length();

            crongTemp = crongPage;
            while(crongTemp != 0) {
                crongMultiplyNum *= crongTemp % 10;
                crongTemp /= 10;
            }
            System.out.println("crongMultiplyNumber = " + crongMultiplyNum);
            crongMaxNumber = max(crongMaxNumber, crongMultiplyNum);
            System.out.println("crongMaxNumber = " + crongMaxNumber);
        }
        return crongMaxNumber;
    }

    private static int getPobiMaxNumber(List<Integer> pobi) {
        int pobiMaxNumber = 0;
        for(Integer pobiPage : pobi){
            int pobiTemp = pobiPage;
            int pobiNumber = 0;
            int pobiMultiplyNum = 1;
            while(pobiTemp != 0){
                pobiNumber += pobiTemp % 10;
                pobiTemp /= 10;
            }
            System.out.println("pobiSumNumber = " + pobiNumber);
            pobiMaxNumber = max(pobiMaxNumber, pobiNumber);
//            System.out.println("pobiMaxNumber = " + pobiMaxNumber);

            pobiTemp = pobiPage;
            while(pobiTemp != 0) {
                pobiMultiplyNum *= pobiTemp % 10;
                pobiTemp /= 10;
            }
            System.out.println("pobiMultiplyNum = " + pobiMultiplyNum);
            pobiMaxNumber = max(pobiMaxNumber, pobiMultiplyNum);
            System.out.println("pobiMaxNumber = " + pobiMaxNumber);
        }
        return pobiMaxNumber;
    }
}