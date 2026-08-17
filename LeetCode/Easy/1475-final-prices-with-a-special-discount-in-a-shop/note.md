## ✅ [SUCCESS] 정답/모범답안 로직
### 🧠 내 코드
```java
class Solution {
    public int[] finalPrices(int[] prices) {
        // 직전 요소와 비교한다는 점에서 Stack 착안
        // Stack에 아직 결정되지 않은 요소의 index만 넣기
        // 조건이 만족할 경우(이후 나오는 요소의 가격이 더 작을 경우) 
        // 해당 요소는 결정되었으니 stack으로부터 pop
        // 해당 요소의 index에 대해 정답배열 원소 결정
        // 해당 요소의 pop 이후 이전 요소가 top이 되고 또 다시 조사하는 요소와 비교
        // 조건이 만족하지 않을 때까지 pop 반복하면서 정답배열 원소 결정
        // 조건이 더 이상 만족하지 않으면 조사하는 요소를 stack에 push
        // 배열 모두 순회했는데도 아직 stack에 남아있는 요소는 모두 조건 미충족

        // Stack 자료 구조 초기화
        Deque<Integer> stack = new ArrayDeque<>();

        // 정답 배열 초기화
        int[] finalPrices = new int[prices.length];

        // 주어진 배열 순회
        for (int i = 0; i < prices.length; i++) {
            // 조건 만족하는 경우
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                // 정답 배열의 해당 인덱스의 원소 값 결정
                int popped = stack.pop();
                finalPrices[popped] = prices[popped] - prices[i];
            }
 
            stack.push(i);
        }

        // Stack에 남아있는 원소 순회하며 정답 배열의 나머지 원소 값 결정
        while (!stack.isEmpty()) {
            int popped = stack.pop();
            finalPrices[popped] = prices[popped];
        }

        return finalPrices;
    }
}
```
### 🤔 생각 흐름:
* 중첩반복문을 통해 일일이 비교하면 O(N^2) 시간복잡도일 수밖에 없다!
* 배열 임의접근이 가능하고, 원소 간 구분을 위해 스택에 들어갈 원소를 가격이 아닌 인덱스로 관리하자.
* stack에 아직 정해지지 않는 인덱스를 넣고, 새로운 원소와 가격을 비교하자.
* 조건이 만족한다면 정답 배열의 해당 인덱스에 대해 원소 값을 결정한다!
* 조건이 만족하지 않을 때까지 계속 반복한다.
* 주어진 배열 순회가 끝났음에도 아직 stack에 남아있는 원소는 조건이 만족하지 못하는 것들이다.

---

## 🎯 한 줄 본질
* **_왜 Stack인가?_**
    * 더 정확히 말하자면, `Monotonic Stack`
        * 스택 내부의 원소들이 항상 단조 증가(오름차순) 또는 단조 감소(내림차순) 상태를 유지하도록 관리한다.
        * 최소한의 비교 횟수만으로 필터링 할 수 있다.
            * _조건을 만족한 요소는 즉시 pop 하기 때문에 각 원소당 최대 삽입 1번, 삭제 1번만 발생하여 O(N^2) 탐색 비용을 O(N)으로 줄일 수 있다._
    * Comparing the most recent element (LIFO) → stack
        * the most recent? → '아직 해결되지 않고 대기 중인 요소들 중 가장 최근 것'
    * 아직 조건을 만족하지 않아서 보류, 대기 하는 원소를 담아둘 수 있다.


