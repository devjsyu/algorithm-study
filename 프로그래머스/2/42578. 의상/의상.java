import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        // (각 카테고리 개수 + 1)끼리의 곱에서 1 차감하기
        Map<String, Integer> clothPartToCount = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            // 카테고리별 집계
            String clothPart = clothes[i][1];
            String clothName = clothes[i][0];
            clothPartToCount.put(clothPart, clothPartToCount.getOrDefault(clothPart, 0) + 1);
        }

        int answer = 1;
        for (Integer count : clothPartToCount.values()) {
            answer *= (count + 1); // 각 카테고리 개수 + 1의 값끼리 곱하기
        }
        answer = answer - 1; // 1 차감하기

        return answer;
    }
}