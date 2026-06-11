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

* **⚠️ 왜 비효율적/실패했는가? (Self-Feedback):**
    * Map<String, int[]>를 제대로 다루지 못 했다. `computeIfAbsent`를 이용했다면 더 간결하게 구현할 수 있었을 것이다.

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

### 🛠️ 내 코드에서 놓친 디테일 (Syntax / Edge Case)
* **💡 문법/라이브러리 피드백:**
    * Map을 이용할 때 Map.Entry를 적극적으로 사용하면 유용하겠구나.
    * `getOrDefault` ,`computeIfAbsent`를 이용하면 코드를 간결하게 만들 수 있다.

---

## 2. 🎯 한 줄 본질 (What)
* 이 문제는 결국 요구조건에 맞는 자료구조를 선택해서 Stream과 Comparator를 이용해 가공하는 것이다.
* `Stream을 통한 sorted와 limit`과 `Map의 항목별 집계`, `Map을 Map.Entry로 변환하여 정렬`하는 것을 이용하는 것이다.

---

