## ✅ [SUCCESS] 정답/모범답안 로직
### 🧠 내 코드
```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Monotonic Stack
        // 아직 조건 충족 여부가 결정되지 않은 원소를 stack에 담아 대기한다
        // 대기하는 원소 중 가장 최신 원소와 조사 대상 원소를 비교한다
        // 조건을 만족하면 해당 대기 원소를 pop하고, 아니라면 조사 대상 원소를 push 한다
        // O(N^2) 탐색하는 대신, 각 원소는 최소 pop, push 1번만 연산만 하면 된다
        // 정답 배열의 원소는 기존 배열의 인덱스를 기반으로 계산해서 값을 결정한다

        // 정답 배열 초기화
        int[] answer = new int[temperatures.length];

        // Stack 자료구조 초기화
        Deque<Integer> elementsNotDeterminedYet = new ArrayDeque<>();

        // 주어진 배열 순회
        for (int i = 0; i < temperatures.length; i++) {
            // 조건 만족하는 경우 (대기 중인 원소 인덱스에 대한 온도보다 조사 대상 인덱스에 대한 온도가 더 높을 때) 
            while (!elementsNotDeterminedYet.isEmpty() && 
            temperatures[elementsNotDeterminedYet.peek()] < temperatures[i]) {
                int popped = elementsNotDeterminedYet.pop();
                answer[popped] = i - popped;
            }
            elementsNotDeterminedYet.push(i);
        }

        return answer;
    }
}
```

---

## 🎯 한 줄 본질
* `nested-loop`을 사용하는 O(N^2) 대신, `Monotonic Stack`을 사용하여 O(N) 시간복잡도로 탐색하기
    * **LIFO**: "대기 중인 원소 중 가장 최근 원소"와 "조사 대상 원소"를 비교하기
    * 아직 결정되지 않아 보류 중인 원소를 스택에 담아두기
    * 스택을 단조 증가(오름차순) 상태를 유지하도록 관리
    * 각 원소에 대해 최대 한 번 push, pop 연산 발생

---

## 🧠 Monotonic Stack을 비유로 이해하기
* 역대 경제신문 1면을 쌓아올리자.
* 가장 오래된 신문이 가장 마지막에 깔려있고, 가장 최신 날짜 신문이 가장 위에 놓여있다.
* 이 신문 스택의 관리 규칙 : 경제신문 1면 속 코스피 숫자가 단조 증가해야 한다.
* 오늘자 신문이 도착하면 일단 스택 가장 위에 있는 최신 신문과 비교한다.
* 오늘자 신문의 코스피보다 스택 가장 위의 신문 코스피가 더 높다? 스택 가장 위의 신문을 빼버린다!
* 스택 가장 위의 신문의 코스피가 오늘자 신문의 코스피보다 더 낮은 게 나올 때까지 반복한다.
* (서브프라임모기지 대폭락 날짜가 나올 때까지 반복한다.)
* 신문 스택의 "단조 증가" 규칙을 비로소 만족하면 그제서야 오늘자 신문을 스택에 올려둔다.
* 이 경제신문 스택의 남아있는 것들은 IMF, 닷컴버블, 서브프라임모기지 등이 있다.
* 대폭락한 신문만 남았지만, 그래도 희망적으로 조금씩 코스피가 커져가는 걸 볼 수 있다.
