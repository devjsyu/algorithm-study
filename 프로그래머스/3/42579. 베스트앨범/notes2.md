## 1. 🔍 어떻게 시도했는가? (How)

### ❌ [FAIL / SO-SO] 최초 접근 로직
* **🤔 생각한 흐름:**
    * 누적 재생횟수가 많은 장르 순
        * 많이 재생된 노래 Top 2
            * 재생 횟수가 동일하다면 고유 번호가 낮은 순
    * custom Comparator를 만들자?
    * Map<String, Integer> 항목별 집계
        * 값 기준으로 정렬하기
            * 키 순회하기
    * Map<String, List<int[][]>>
        * Stream
            * sort Lambda
                * (o1, o2 -> if (o1[1] == o2[1]) ... )
                    * limit 2
#### 비효율적 코드 예시
* 다시 풀었을 때 더 비효율적으로 풀었다!
* 무비판적으로 Stream API의 filter를 사용했다! 모든 장르에 대해 특정 장르를 필터링하여서 매번 O(N) 순회를 비효율적으로 했다!
```java
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

```

* **⚠️ 왜 비효율적/실패했는가? (Self-Feedback):**
    * Map<String, int[]>를 제대로 다루지 못 했다. `computeIfAbsent`를 이용했다면 더 간결하게 구현할 수 있었을 것이다.
    * 서로 다른 자료형을 함께 다루는 방법으로써, Record를 사용할 수 있었다!

### ✅ [SUCCESS] 정답/모범답안 로직
* **✨ 수정된 흐름:**
    * Comparator 대신 Lambda를 더 적극적으로 사용한다.

```java
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresToPlayCount = new HashMap<>();
        Map<String, List<int[]>> genresToPlayCountById = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genresToPlayCount.put(genres[i], genresToPlayCount.getOrDefault(genres[i], 0) + plays[i]);
            // computeIfAbsent를 활용해 Map 초기화 코드를 더 간결하게!
            genresToPlayCountById.computeIfAbsent(genres[i], k -> new ArrayList<>())
                                 .add(new int[]{i, plays[i]});
        }

        // 1. 장르별 총 재생 횟수 기준 내림차순 정렬
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(genresToPlayCount.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        List<Integer> answerList = new ArrayList<>();
        
        // 2. 각 장르 내부에서 베스트 곡 2개씩 뽑기
        for (Map.Entry<String, Integer> entry : entries) {
            genresToPlayCountById.get(entry.getKey()).stream()
                // 람다식을 활용해 다중 정렬 조건을 직관적으로 표현
                .sorted((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1])
                .limit(2)
                .forEach(o -> answerList.add(o[0]));
        }

        // 3. 결과 반환
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
```
#### Gemini 생성 모범답안 코드
```java
import java.util.*;

class Solution {
    // 고유번호(id)까지 포함하는 구조체 정의
    public record Song(int id, int plays) {}

    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생 횟수 집계
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 2. 장르별 곡 리스트 그룹화 (테이블 분리 효과)
        Map<String, List<Song>> songsByGenre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
            
            // 장르가 없으면 빈 리스트를 만들고 곡을 추가
            songsByGenre.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Song(i, play));
        }

        // 3. 총 재생 횟수 기준 장르 정렬
        List<String> sortedGenres = genrePlayCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(Map.Entry::getKey)
                .toList();

        // 4. 각 장르 내부에서 Top 2 추출
        List<Integer> result = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            List<Song> songs = songsByGenre.get(genre);
            
            // 해당 장르의 곡들만 가져와서 정렬하므로 매우 빠름!
            songs.stream()
                .sorted((s1, s2) -> {
                    if (s1.plays() == s2.plays()) {
                        return Integer.compare(s1.id(), s2.id()); // ID 오름차순
                    }
                    return Integer.compare(s2.plays(), s1.id()); // 재생수 내림차순
                })
                .limit(2)
                .map(Song::id)
                .forEach(result::add);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

### 🛠️ 내 코드에서 놓친 디테일 (Syntax / Edge Case)
* **💡 문법/라이브러리 피드백:**
    * Map을 이용할 때 Map.Entry를 적극적으로 사용하면 유용하겠구나.
    * `getOrDefault` ,`computeIfAbsent`를 이용하면 코드를 간결하게 만들 수 있다.
    * 바깥 반복문 내에서 Stream API에서 filter를 사용한다면 실질적으로 N^2 시간복잡도를 갖는 중첩반복문인데, Stream API라는 멋진 포장지에 가려서 못 봤다!

---

## 2. 🎯 한 줄 본질 (What)
* 이 문제는 결국 요구조건에 맞는 자료구조를 선택해서 Stream과 Comparator를 이용해 가공하는 것이다.
* `Stream을 통한 sorted와 limit`과 `Map의 항목별 집계`, `Map을 Map.Entry로 변환하여 정렬`하는 것을 이용하는 것이다.
* 전체에 대해 그룹핑 효과를 위해 필터링 후 정렬하지 말고, 각 자식 리스트로 그룹핑 후 정렬 해야 한다.

---

