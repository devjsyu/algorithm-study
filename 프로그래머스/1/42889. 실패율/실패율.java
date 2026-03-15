import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] usersByStages = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            int stage = stages[i];
            usersByStages[stage]++;
        }
        int notPassed = 0;
        HashMap<Integer, Float> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (usersByStages[i] == 0) {
                map.put(i, (float) 0);
            } else {
                map.put(i, ((float) usersByStages[i]) / (stages.length - notPassed));
                notPassed += usersByStages[i];
            }
        }
        Set<Map.Entry<Integer, Float>> set = map.entrySet();
        ArrayList<Map.Entry<Integer, Float>> list = new ArrayList<>(set);
        list.sort(new Comparator<Map.Entry<Integer, Float>>() {
            @Override
            public int compare(Map.Entry<Integer, Float> t1, Map.Entry<Integer, Float> t2) {
                int result = Float.compare(t2.getValue(), t1.getValue());
                if (result == 0) {
                    return t1.getKey() - t2.getKey();
                } else {
                    return result;
                }
            }
        });
        return list.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}