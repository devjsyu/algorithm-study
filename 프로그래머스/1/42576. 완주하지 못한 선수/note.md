## ✅ [SUCCESS] 정답/모범답안 로직
### ✨ Pseudo code:
```
// 이름별 집계를 위한 자료구조 초기화
// participant 배열 순회하면서 이름별 집계
// completion 배열 순회하면서 이름별 집계에서 해당 이름 차감
// 유일하게 남아있는 이름 반환 (전체 순회하되, 조기 반환)
```

### 💡 문법/라이브러리 피드백:
* `keySet()`보다 `entrySet()`이 더 효율적이다.
    * `keySet()`은 key에 대한 value를 찾기 위해 전체 Map을 매번 loop를 거쳐야 하는 반면, `entrySet()`은 key-value가 이미 짝으로 함께 저장되어 있기 때문이다.
    * 각 key에 대한 value를 찾기 위해 매번 loop를 거쳐야 할 뿐만 아니라, re-hashing, bucket searching, tree traversal을 해야 할 수도 있다.<br></br>
* `getOrDefault`의 의의
    * verbose `if-else` statement 생략하고 한 줄로 표현 가능
    * NullPointerException 예방 가능<br></br>
* `computeIfPresent`의 의의
    * verbose `if-else` statement 생략하고 한 줄로 표현 가능
    * 가독성 좋은 람다식<br></br>
* Map.computeIfPresent 메서드는 람다식의 결과물로 null을 반환하면 해당 키를 Map에서 자동으로 삭제(remove) 해준다.


---

## 🎯 한 줄 본질
* 이 문제는 결국 `HashMap의 핵심 원리`를 활용해서 `문제풀이 로직을 구현`하는 문제다.
    * 카테고리별 빈도수 집계? **_HashMap!_**
        * 문자열을 Hash를 통해 O(1) 시간복잡도로 찾을 수 있다!
        * lookup/insert 평균 시간복잡도는 O(1)이다!

---

## 💡 핵심 인사이트
### 💥 아차! 포인트 (내가 막히거나 오판했던 점):
* Map에서 value로 유일하게 1를 갖는 key를 어떻게 찾을 수 있을까?
    * 3번 순회 하지 않고 2번째 순회에서 `.remove`를 사용해서 3번째 순회 없이 유일하게 남은 키-값을 반환한다? `.remove`의 overhead cost를 간과했다. 동적으로 맵 구조를 변경/재해싱한다.
    * 차라리 순회를 하되, 조기 반환을 하는 게 더 효율적이다!

---

## 🚀 앞으로의 행동 지침
### ⚡ 다음에 이 유형을 만나면 확인할 체크리스트:
* [ ] *카테고리별 빈도수 집계? HashMap!*
