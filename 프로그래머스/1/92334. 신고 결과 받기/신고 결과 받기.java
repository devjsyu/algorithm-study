import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportedToReporters = new HashMap<>();
        Map<String, Integer> reporterToMailCount = new HashMap<>();

        for (int i = 0; i < report.length; i++) {
            String[] split = report[i].split(" ");
            String reporter = split[0];
            String reported = split[1];

            // 신고 받은 유저가 처음 등장할 경우 Map에 Key 추가
            if (!reportedToReporters.containsKey(reported)) {
                reportedToReporters.put(reported, new HashSet<>());
            }
            // 신고 받은 유저 Key에 대한 값으로써 Set에 신고 한 사람 추가
            reportedToReporters.get(reported).add(reporter); // Set이기 때문에 신고가 중복되도 무관
        }

        // reportedToReporter 순회하면서 신고한 사람 수를 k와 비교
        reportedToReporters.forEach((reported, reporters) -> {
            // 신고 받은 사람이 정지 기준 초과로 인해 정지 받게 되는 경우
            if (reporters.size() >= k) {
                // 각 신고자에게 받을 메일 개수 1씩 추가 집계
                reporters.forEach((reporter) -> {
                    reporterToMailCount.put(reporter, reporterToMailCount.getOrDefault(reporter, 0) + 1);
                });
            }
        });

        // 신고자별 메일 받을 개수를 배열에 담기
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reporterToMailCount.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}