package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // user는 기이가 1이앗 30이하인 문자열 -> 예외 처리
        //friends는 길이가 1 이상 10,000이하인 리스트/배열
        //friends의 각 요소는 길이가 2인 리스트/배열로 [아이디A, 아이디B] 순으로 듦 - A, B는 친구 / 아이디는 길이가 1이상 30이하인 문자열 -> 예외처리
        //visitor는 길이가 0이상 10,000이하인 리스트/배열 -> 선언
        //사용자 앙디는 알파벳 소문자로만 이루어짐 -> 예외 처리
        //동일한 친구 관계가 중복해서 주어지지 않는다. 동일할 경우 삭제
        //추천할 친구가 없는 경우 result는 null
        //user 가 있는 요소를 먼저 찾아 별도 저장
        //마지막에 result에서 제외시킴
        //first, second 사용
        //user가 i, j 사용해서 user 찾기 찾은 유저는 별도 List에 저장
        // if else if 문 사용해서 user 위치에 따라 함께 친구 아이디 추출
        //user 제외하고 friends iter 실시
        //length
        //friends랑 visitor 합쳐서 list<String, Integer>(key, value) 만들기 & 중복 제거 value 0으로 초기화
        //list<String, Integer>의 Integer에 요소별 누적합 / visitors 있으면 +1 / friends의 조건 만족시 +10

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
