import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 이름별 집계를 위한 자료구조 초기화
        HashMap<String, Integer> nameByCount = new HashMap<>();

        // participant 배열 순회하면서 이름별 집계
        for (String name : participant) {
            // 빈도수 집계
            nameByCount.put(name, nameByCount.getOrDefault(name, 0) + 1); // getOrDefault 메서드 사용: null 체크 생략 및 NullPointerException 예방
        }

        // completion 배열 순회하면서 이름별 집계에서 해당 이름 차감
        for (String name : completion) {
            // 차감
            nameByCount.computeIfPresent(name, (k, v) -> v - 1);
        }
        
        // 유일하게 남아있는 이름 반환
        for (Map.Entry<String, Integer> entry : nameByCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
}