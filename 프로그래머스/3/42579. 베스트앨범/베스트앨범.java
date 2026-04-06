import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playByGenre = new HashMap<>();
        HashMap<String, List<int[]>> idAndPlayByGenre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!playByGenre.containsKey(genre)) {
                playByGenre.put(genre, 0);
                idAndPlayByGenre.put(genre, new ArrayList<>());
            }
            playByGenre.put(genre, playByGenre.get(genre) + play);
            idAndPlayByGenre.get(genre).add(new int[]{play, i});
        }

        ArrayList<Integer> answer = new ArrayList<>();
        Stream<Map.Entry<String, Integer>> sorted = playByGenre.entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        sorted.forEach(entry -> {
            Stream<int[]> sortedSongs = idAndPlayByGenre.get(entry.getKey()).stream().sorted((o1, o2) -> Integer.compare(o2[0], o1[0])).limit(2);
            sortedSongs.forEach(song -> answer.add(song[1]));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}