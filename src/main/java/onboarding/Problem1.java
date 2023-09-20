package onboarding;

import java.util.*;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        //난수 생성(1~400)
        Random rand = new Random();

        int pageNum = 0;
        pobi = new ArrayList<>(2); // ArrayList size 설정
        crong = new ArrayList<>(2);


//        List<List<Integer>> characters = new ArrayList<>();
//        characters.add(pobi);
//        characters.add(crong);

        while(pobi.isEmpty()){
            pageNum = rand.nextInt(401);
            //예외 처리: 시작면이나 마지막면 나오면 책 다시 펼치기
            if (pageNum == 0 || pageNum == 400) {
                continue;
            } else {

                if ((pageNum % 2) == 0) {
                    pobi.add(1, pageNum);
                    pobi.add(0, pageNum - 1);
                } else {
                    pobi.add(0, pageNum);
                    pobi.add(1, pageNum + 1);
                }
                for (Integer i : pobi) {
                    System.out.println("i = " + i);
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
                    System.out.println("i = " + i);
                }

            }
        }
        /*List<Integer> pobiCompareNumber = new ArrayList<>(4);
        List<Integer> crongCompareNumber = new ArrayList<>(4);*/

        Integer pobiMaxNumber = 0;
        int pobiNumber = 0;
        int pobiMultiplyNum = 1;
        for(Integer pobiPage : pobi){
            while(pobiPage != 0){
                pobiNumber += pobiPage % 10;
                pobiPage /= 10;
                System.out.println("pobiNumber = " + pobiNumber);
            }

            max(pobiMaxNumber, pobiNumber);
//            numCnt = pobiPage.toString().length();
            while(pobiPage != 0) {
                pobiMultiplyNum *= pobiPage % 10;
                pobiPage /= 10;
            }
            max(pobiMaxNumber, pobiNumber);
        }


        Integer crongMaxNumber = 0;
        int crongNumber = 0;
        int crongMultiplyNum = 1;
        for(Integer crongPage : crong){
            while(crongPage != 0){
                crongNumber += crongPage % 10;
                crongPage /= 10;
            }
            max(crongMaxNumber, crongNumber);
//            numCnt = pobiPage.toString().length();
            while(crongPage != 0) {
                crongMultiplyNum *= crongPage % 10;
                crongPage /= 10;
            }
            max(crongMaxNumber, crongNumber);
        }

        if(pobiMaxNumber > crongMaxNumber){
            answer = 1;
        } else if (pobiMaxNumber < crongMaxNumber) {
            answer = 2;
        } else if(pobiMaxNumber == crongMaxNumber) {
            answer = 0;
        } else {
            answer = -1;
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
}