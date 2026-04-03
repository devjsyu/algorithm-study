import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }
    public static String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Map.Entry<String, String>> list = new ArrayList<>();
        HashMap<String, String> idToNameMap = new HashMap<>();
        for (String s : record) {
            StringTokenizer st = new StringTokenizer(s);
            String status = st.nextToken();
            String uid = st.nextToken();
            String nickname = "";
            if (st.hasMoreTokens()) {
                nickname = st.nextToken();
            }

            if (!idToNameMap.containsKey(uid)) {
                idToNameMap.put(uid, nickname);
            }

            switch (status) {
                case "Enter":
                    if (!idToNameMap.get(uid).equals(nickname)) {
                        idToNameMap.put(uid, nickname);
                    }
                    list.add(Map.entry(uid, "님이 들어왔습니다."));
                    break;
                case "Leave":
                    list.add(Map.entry(uid, "님이 나갔습니다."));
                    break;
                case "Change":
                    idToNameMap.put(uid, nickname);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : list) {
            sb.append(idToNameMap.get(entry.getKey())).append(entry.getValue());
            answer.add(sb.toString());
            sb.setLength(0);
        }

        return answer.toArray(String[]::new);
    }
}