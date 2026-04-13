import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고 받은 사람 : 신고 한 사람 목록
        HashMap<String, Set<String>> defendantToPlaintiffs = new HashMap<>();
        for (String log : report) {
            StringTokenizer st = new StringTokenizer(log);
            String plaintiff = st.nextToken();
            String defendant = st.nextToken();

            if (!defendantToPlaintiffs.containsKey(defendant)) {
                defendantToPlaintiffs.put(defendant, new HashSet<>());
            }

            defendantToPlaintiffs.get(defendant).add(plaintiff);
        }

        // 조건을 충족하는 경우 신고한 사람이 메일 받아야 할 개수 집계
        HashMap<String, Integer> userToMailCount = new HashMap<>();
        Set<Map.Entry<String, Set<String>>> entries = defendantToPlaintiffs.entrySet();
        for (Map.Entry<String, Set<String>> entry : entries) {
            if (entry.getValue().size() >= k) {
                for (String plaintiff : entry.getValue()) {
                    userToMailCount.put(plaintiff, userToMailCount.getOrDefault(plaintiff, 0) + 1);
                }
            }
        }

        // 출력
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = userToMailCount.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}