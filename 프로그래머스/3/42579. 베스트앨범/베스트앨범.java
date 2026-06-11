import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresToPlayCount = new HashMap<>();
        Map<String, List<int[]>> genresToPlayCountById = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genresToPlayCount.put(genres[i], genresToPlayCount.getOrDefault(genres[i], 0) + plays[i]);
            if (!genresToPlayCountById.containsKey(genres[i])) {
                genresToPlayCountById.put(genres[i], new ArrayList<>());
            }
            genresToPlayCountById.get(genres[i]).add(new int[]{i, plays[i]});
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(genresToPlayCount.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            genresToPlayCountById.get(entry.getKey()).stream().sorted(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0]; // 고유번호 오름차순 정렬
                    } else {
                        return o2[1] - o1[1]; // 재생횟수 내림차순 정렬
                    }
                }
            }).limit(2).forEach(o -> list.add(o[0]));
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}