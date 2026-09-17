// 빈도수 집계를 위해 HashMap 사용
// 여러 데이터를 record 클래스로 묶어서 관리하기
// Grouping By Genre
// 커스텀 정렬 id, count
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 총 재생횟수 기준 장르 정렬하기
        Map<String, Integer> genreToCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreToCount.put(genres[i], genreToCount.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> genreOrdered = genreToCount.keySet().stream()
            .sorted((k1, k2) -> genreToCount.get(k2) - genreToCount.get(k1))
            .toList();
        
        Map<String, List<Song>> genreToSong = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreToSong.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < genreOrdered.size(); i++) {
            genreToSong.get(genreOrdered.get(i)).stream().sorted((s1, s2) -> {
                if (s1.count() == s2.count()) {
                    return s1.id() - s2.id();
                } else {
                    return s2.count() - s1.count();
                }
            }).limit(2).forEach(s -> answer.add(s.id()));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public record Song(int id, int count) {}
}