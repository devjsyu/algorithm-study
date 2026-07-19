import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
    // 준비
        // 장르별 집계를 위한 자료구조 초기화
        Map<String, Integer> genreToPlayCount = new HashMap<>();

        Map<Integer, GenreToPlayCount> idToGenreAndPlayCount = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            idToGenreAndPlayCount.put(i, new GenreToPlayCount(genres[i], plays[i]));
        }
        Set<Map.Entry<Integer, GenreToPlayCount>> idToGenreAndPlayCountEntrySet = idToGenreAndPlayCount.entrySet();

        // 정답 담을 리스트 초기화
        List<Integer> answer = new ArrayList<>();


    // 1차 정렬 : 많이 재생된 장르 순
        // 장르별 집계
        for (int i = 0; i < genres.length; i++) {
            genreToPlayCount.put(genres[i], genreToPlayCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 많이 재생된 장르 순 정렬
        List<String> genreByPopularityOrdered = genreToPlayCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(Map.Entry::getKey)
                .toList();

    // 2차 정렬 : 재생횟수, 고유번호 순 정렬
        // 장르 순회
        for (int i = 0; i < genreByPopularityOrdered.size(); i++) {
            int index = i;
            idToGenreAndPlayCountEntrySet.stream()
                    // 장르별 처리
                    .filter(o -> o.getValue().genre.equals(genreByPopularityOrdered.get(index)))
                    // 정렬 조건 만족하는 custom comparator 선언
                    .sorted((o1, o2) -> {
                        // 재생횟수가 같은 경우 고유번호 오름차순 정렬
                        if (o1.getValue().playerCount.equals(o2.getValue().playerCount)) {
                            return o1.getKey().compareTo(o2.getKey());
                        } else {
                            // 재생횟수 내림차순 정렬
                            return o2.getValue().playerCount.compareTo(o1.getValue().playerCount);
                        }
                    })
                    // 필요한 정보만 필터링 가공
                    .map(Map.Entry::getKey)
                    // Top 2
                    .limit(2)
                    // 정답 리스트에 추가
                    .forEach(answer::add);
        }

        // 정답 반환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public record GenreToPlayCount(String genre, Integer playerCount) {}
}