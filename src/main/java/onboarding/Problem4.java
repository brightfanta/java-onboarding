package onboarding;

public class Problem4 {
    public static String solution(String word) {
        
        
        //Character ASCII코드 숫자 갖는 사항 활용
        //대문자 소문자 입력
        //(출력 알파벳 코드) = (Z or z의 알파벳 코드 - (해당 알파벳 코드 - (A or a의 알파벳 코드))
        //nextLine으로 입력 받기
        //알파벳일 경우에만 변환! 개행문자는 무시

        String answer = "";
        char temp = ' ';

        if (word.length() < 1 || word.length() > 1_000) {
            return "";
        }

        for (int i = 0; i < word.length(); i++) {
            if((int)word.charAt(i) >= 65 && (int)word.charAt(i) <= 90){
//                temp = word.charAt(i);
                temp = (char) (90 - ((int) word.charAt(i) - 65));
                word = word.substring(0, i) + temp + word.substring(i + 1);
            }

            if((int)word.charAt(i) >= 97 && (int)word.charAt(i) <= 122){
//                temp = word.charAt(i);
                temp = (char) (122 - ((int) word.charAt(i) - 97));
                word = word.substring(0, i) + temp + word.substring(i + 1);
            }
        }
        answer = word;

        return answer;
    }
}
