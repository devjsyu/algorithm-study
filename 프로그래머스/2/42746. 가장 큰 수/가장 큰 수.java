import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        // 숫자들을 문자열로 변환하여 조합 비교 후 내림차순 정렬, 하나로 합침
        String answer = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.joining());

        // "000..."과 같이 0으로만 이루어진 경우 "0" 반환
        if (answer.startsWith("0")) {
            return "0";
        }

        return answer;
    }
}