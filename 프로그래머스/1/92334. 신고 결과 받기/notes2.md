## 1. 🔍 어떻게 시도했는가? (How)

### ❌ [FAIL / SO-SO] 최초 접근 로직
* **🤔 생각한 흐름:**
    * 생각난 자료구조 HashMap과 HashSet
        * HashMap<String, HashSet<String>> reportedToReporter
        * HashMap<String, Integer> reporterToMailCount
    * 각 신고받은 유저별로 신고한 유저를 입력 받기
        * 이때, 중복을 허용하지 않기 때문에 HashSet 자료구조 사용
    * 각 신고받은 유저에 대해 아래와 같이 순회
        * 신고한 유저 수를 집계하여 k보다 크거나 같은지 비교
        * 만약 그렇다면 각 신고한 유저를 Key로 삼아 Value로써 이메일 개수를 +1 증가시킴
    * id_list를 순회하면서 각 신고한 유저 Key에 대한 Value를 담은 배열 만들어 반환하기
    * 고려해야 하는 Edge case
        * 유저인데 신고 받은 적이 없다?
            * ~~null로 해도 괜찮을까?~~
            * getOrDefault를 사용하자.

* **⚠️ 왜 비효율적/실패했는가? (Self-Feedback):**
    * `reporterToMailCount`를 굳이 사용할 필요 없다. `id_list`를 최대한 활용하면 Map과 getOrDefault 없이 정답을 반환할 수 있었다.

### ✅ [SUCCESS] 정답/모범답안 로직
* **✨ 수정된 흐름:**
```java
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 1. 각 유저별 id_list에서의 인덱스 위치를 미리 저장 (마지막 배열 담기 최적화)
        Map<String, Integer> idIndexMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idIndexMap.put(id_list[i], i);
        }

        // 2. 신고당한 사람 -> 신고한 사람들의 집합(Set)
        Map<String, Set<String>> reportedToReporters = new HashMap<>();
        
        for (String r : report) {
            // split 대신 indexOf와 substring을 사용하여 성능 최적화
            int blankIndex = r.indexOf(' ');
            String reporter = r.substring(0, blankIndex);
            String reported = r.substring(blankIndex + 1);

            // computeIfAbsent로 깔끔하게 처리
            reportedToReporters.computeIfAbsent(reported, x -> new HashSet<>()).add(reporter);
        }

        // 3. 정지 유저를 판별하고 바로 answer 배열에 메일 개수 누적
        int[] answer = new int[id_list.length];
        
        for (Set<String> reporters : reportedToReporters.values()) {
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    // 메일 카운트 Map을 거치지 않고, 인덱스 맵을 통해 answer 배열에 바로 누적
                    answer[idIndexMap.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}
```

### 🛠️ 내 코드에서 놓친 디테일 (Syntax / Edge Case)
* **💡 문법/라이브러리 피드백:**
    * String.split() 대신 String.indexOf()와 substring() 활용할 수 있다. split 메서드는 내부적으로 정규표현식을 사용하기 때문에 메모리 사용량이 상대적으로 많고 더 느리다.
    * Map<String, Integer> reporterToMailCount과 getOrDefault를 굳이 사용하지 않을 수 있었다.
    * `computeIfAbsent`를 사용해서 코드를 간결하게 만들 수 있었다.

---

## 2. 🎯 한 줄 본질 (What)
* N:M 관계를 1:N 관계로 변환하고 적합한 기준을 설정하는 것이다. `신고 한 사람`이 아니라 `신고 받은 사람` 기준으로 묶는 것이 핵심이다.
* 이 문제 풀이 아이디어의 핵심은 관점의 전환이다. 신고한 사람 중심이 아니라 신고 받은 사람을 기준으로 신고 한 사람들을 그룹화(역방향 매핑)하는 것이다. 신고 받은 사람 (Key) 중심의 1:N 관계로 재정의할 수 있다. 구현 측면에서는 Map을 활용해서 신고 받은 사람별로 그룹화 하고, Set을 활용해 동일 유저의 중복 신고를 자동으로 제거한 것이 핵심이다.

---

## 3. 💥 아차! 포인트 (Why)
* 내가 풀이 과정에서 막히거나 오판했던 점:
    * 신고 받은 적이 없는 유저를 집계에서 누락했다.

---

## 4. ⚡ 다음에 보면? (Trigger)
* 자료구조 선택 기준
    * organizing values by key? → Map
    * duplication not allowed? → Set
* 조건을 만족했는지 판단하는 `기준(Target)`과 최종적으로 정답을 출력해야 하는 `대상(Output)`이 서로 다르다?
    * `신고 받은 사람`의 누적 횟수가 k번 이상인가?
    * `신고 한 사람`이 받을 메일의 개수는 몇 개인가?
    * 기준은 `신고 받은 사람`인데 출력은 `신고 한 사람`이므로, 데이터를 `신고 받은 사람` 중심으로 뒤집어서 계산한 뒤 다시 `신고 한 사람`에게 뿌려줘야 한다.
* 다대다 관계가 보이면 1:N를 만드는 것이 편리하다. 어떤 것을 기준으로 축을 고정해야 할 것인가?
    * 기준을 잘못 잡으면 매우 비효율적이다.
    * 손님을 기준으로 상품을 묶어버리면, 특정 상품이 몇 개 팔렸는지 확인하기 위해 모든 손님의 장바구니를 뒤져야 한다!
* `A가 B를 선택했다`는 문장이 나온다면, 거꾸로 `B 입장에서 나를 선택한 A를 모은다`로 생각해볼 수 있다.