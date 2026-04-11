import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Set<String>> reportedUser = new HashMap<>();
        HashMap<String, Integer> reportCount = new HashMap<>();
        int[] answer = new int[id_list.length];

        for (String log : report) {
            StringTokenizer st = new StringTokenizer(log);
            String userReported = st.nextToken();
            String userBeingReported = st.nextToken();

            if (!reportedUser.containsKey(userBeingReported)) {
                reportedUser.put(userBeingReported, new HashSet<>());
            }

            reportedUser.get(userBeingReported).add(userReported);
        }

        for (Map.Entry<String, Set<String>> entry : reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String userReported : entry.getValue()) {
                    reportCount.put(userReported, reportCount.getOrDefault(userReported, 0) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reportCount.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}