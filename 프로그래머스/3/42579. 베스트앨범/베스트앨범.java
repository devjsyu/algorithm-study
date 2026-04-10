import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreToPlaytime = new HashMap<>();
        HashMap<String, List<int[]>> genreToIdAndPlaytime = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            if (!genreToPlaytime.containsKey(genres[i])) {
                genreToPlaytime.put(genres[i], 0);
                genreToIdAndPlaytime.put(genres[i], new ArrayList<>());
            }
            genreToPlaytime.put(genres[i], genreToPlaytime.get(genres[i]) + plays[i]);
            genreToIdAndPlaytime.get(genres[i]).add(new int[]{i, plays[i]});
        }

        Stream<Map.Entry<String, Integer>> sorted = genreToPlaytime
                .entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        sorted.forEach(o -> genreToIdAndPlaytime.get(o.getKey()).stream().sorted((o1, o2) -> Integer.compare(o2[1], o1[1])).limit(2).forEach(element -> answer.add(element[0])));

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}