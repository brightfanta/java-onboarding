package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        /*List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );*/

        //배열 선언
        List<String> nickname = new ArrayList<>();
        List<String> email_address = new ArrayList<>();
        List<String> error = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        //List에서 nickname, email 추출
        for (int i = 0; i < forms.size(); i++) {
            email_address.add(forms.get(i).get(0));
            nickname.add(forms.get(i).get(1));
        }
        //제한사항 확인
        List<String> check = restrictionCheck(forms, nickname, email_address, error);
        if (check != null) return check;

        for (int i = 0; i < forms.size(); i++) {
            String nicknameDuplicateCriteria = forms.get(i).get(1);
            for (int j = 1; j < nicknameDuplicateCriteria.getBytes().length - 3; j += 3) {
                String criteria = substringByBytes(nicknameDuplicateCriteria, j, j + 6);
                for (int k = 0; k < forms.size(); k++) {
                    String nicknameDuplicateTemp = forms.get(k).get(1);
                    if (nicknameDuplicateCriteria.equals(nicknameDuplicateTemp)) {
                        continue;
                    }
                    boolean containCheck = nicknameDuplicateTemp.contains(criteria);
                    if (containCheck) {
                        answer.add(forms.get(k).get(0));
                    }
                }
            }
        }

        answer = answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);
        String testName1 = forms.get(0).get(1);
        String testName2 = forms.get(1).get(1);


        System.out.println("testName1 = " + testName1);//제이엠
        System.out.println("testName2 = " + testName2);//제이슨


        System.out.println(substringByBytes(testName1, 3,6));
        System.out.println(substringByBytes(testName2, 3,6));
        System.out.println(substringByBytes(testName1, 3,6).equals(substringByBytes(testName2, 3,6)));


        System.out.println(testName1.substring(0,2));
        System.out.println((testName2.substring(0,2)));
        System.out.println(testName1.substring(0,2).equals(testName2.substring(0,2)));

        for (int i = -1; i <= testName1.getBytes().length; i++) {
            String subStr = substringByBytes(testName1, -1, i);
            System.out.println("subStr(-1 ~ " + i + ") = " + subStr);
        }


        /*System.out.println("0-2 : " + testName1.substring(0,2));//제이
        System.out.println("0-1 : " + testName1.substring(0,1));//제
        System.out.println("1-2 : " + testName1.substring(1,2));//이
        System.out.println("2-3 : " + testName1.substring(2,3));//엠
        System.out.println("1-3 : " + testName1.substring(1,3));//이엠
        System.out.println(testName1.length());*/



        return answer;
    }

    private static List<String> restrictionCheck(List<List<String>> forms, List<String> nickname, List<String> email_address, List<String> error) {
        // 닉네임 제한사항(글자수, 입력 언어) 검사
        for (String n : nickname) {
            System.out.println("n = " + n);
            if (n.length() < 1 || n.length() > 20) {
                error.add("닉네임 글자수 제한");
                return error;
            }
            boolean a = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", n);
            if (!a) {
                error.add("닉네임 언어(한글) 제한");
                return error;
            }
        }
        //이메일 제한사항(글자수, 형식) 검사
        for (String e : email_address) {
            if (e.length() < 11 || e.length() > 20) {
                error.add("이메일 글자수 제한");
                return error;
            }
            /*boolean a = Pattern.matches("@email.com", e);
            if (!a) {
                error.add("이메일 형식 제한");
                return error;
            }*/
        }

        //크루 제한사항(인원 수) 검사
        if (forms.size() < 1 || forms.size() > 10_000) {
            error.add("크루 인원 수 제한");
            return error;
        }
        return null;
    }

    public static String substringByBytes(String str, int beginBytes, int endBytes) {
        if (str == null || str.length() == 0) {
            return "";
        }

        if (beginBytes < 0) {
            beginBytes = 0;
        }

        if (endBytes < 1) {
            return "";
        }

        int len = str.length();

        int beginIndex = -1;
        int endIndex = 0;

        int curBytes = 0;
        String ch = null;
        for (int i = 0; i < len; i++) {
            ch = str.substring(i, i + 1);
            curBytes += ch.getBytes().length;

            if (beginIndex == -1 && curBytes >= beginBytes) {
                beginIndex = i;
            }

            if (curBytes > endBytes) {
                break;
            } else {
                endIndex = i + 1;
            }
        }
        return str.substring(beginIndex, endIndex);
    }


}
