package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        /**
         * key값만 별도 반환
         * forms 범위는 1~10,000
         * for문 돌려가면서 forms에 대한 입력값 검증 실시
         * key의 입력 오른쪽 9개가 email.com인지 확인 / email.com 아닐 경우  form에서 삭제함.
         * key의 입력 문자열 길이 10이하일 경우 삭제
         * key의 입력 문자열 길이 20이상일 경우 삭제
         * value는 한글 only 아닐 경우 forms 에서 삭제
         * value 문자열 전체길이 0일경우 삭제
         * value 문자열 전체길이 20이상일 경우 삭제
         * forms 입력값 검증 완료
         * forms 입력 개수를 length로 반환
         * 입력 forms 각각에 대해 문자열 개수 반환 후 i = 0; i < (문자열 길이 - 1) 조건으로 하여
         * 중복검사를 위한 2글자 추출 후 검사용 문자열에 저장 / 각 value 별 중복검사 실시
         *
         * 중복 이메일 result에 add
         * for문 돌려서 입력 개수만큼(length) 중복 검사 실시
         * 전체 forms에 대해 중복검사 완료 후 result 리스트/배열에서 중복제거 및 오름차순 정렬
         * result = 중복제거(result)
         * result = 오름차순(result)
         * result 출력
         *
         * 두글자 이상이면 두글자만 해당해도 전체 해당이잖아
         * 그럼 세글자부터는 조회할 필요가 없지
         *
         */

        List<String> answer = List.of("answer");
        return answer;
    }
}
