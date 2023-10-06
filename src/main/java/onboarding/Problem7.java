package onboarding;

import java.util.*;
import java.util.stream.Collectors;

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

        List<String> friend = new ArrayList<>();
        List<String> friendAbility = new ArrayList<>();
        HashMap<String, Integer> recordList = new HashMap<>();
        List<String> visitorsCnt = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        int record = 0;

        //친구 추리기
        for (List<String> relation : friends) {
            for (int i = 0; i < relation.size(); i++) {
                if (relation.get(i).equals(user)) {
                    for(String r : relation) {
                        if (!(r.equals(user))) {
                            friend.add(r);
                        }
                    }
                }
            }
        }
        //친구가능성 추리기
        for (List<String> relation : friends) {
            for (String r : relation) {
                for (String f : friend) {
                    if (r.equals(f)) {
                        for(String r2 : relation) {
                            if (!(r2.equals(f) || r2.equals(user))) {
                                friendAbility.add(r2);
                            }
                        }
                    }
                }
            }
        }

        //친구가능성 점수 계산
        for (String fA : friendAbility) {
            record = 10;
            if (recordList.containsKey(fA)) {
                record = recordList.get(fA);
                record += 10;
                recordList.remove(fA);
                recordList.put(fA, record);
            }
            recordList.put(fA, record);
        }

        //방문객 점수 계산
        for (String v : visitors) {
            record = 1;
            if (recordList.containsKey(v)) {
                record = recordList.get(v);
                record += 1;
                recordList.remove(v);
                recordList.put(v, record);
            }
            recordList.put(v, record);
        }
        for (int i = 0; i < recordList.size(); i++) {
            for (String f : friend) {
                if (recordList.containsKey(f)) {
                    recordList.remove(f);
                }
            }
        }

        //점수 오름차순 정렬
        List<Map.Entry<String, Integer>> entries =
                recordList.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toList());

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(recordList.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println("Key: " + entry.getKey() + ", "
                    + "Value: " + entry.getValue());
            answer.add((String) entry.getKey());

        }
        return answer;
    }
}
