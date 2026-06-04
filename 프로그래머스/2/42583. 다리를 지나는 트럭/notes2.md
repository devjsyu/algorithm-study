## 1. 🔍 어떻게 시도했는가? (How)

### ❌ [FAIL / SO-SO] 최초 접근 로직
* **🤔 생각한 흐름:**
    * 완료 List, 다리 Queue, 대기 Queue
    * while (완료_List size != total_trucks || !대기_Queue.isEmpty)
        * dequeue
            * 다리_weights -= dequeueOutput
            * if (dequeueOutput != 0) 완료_List.add(dequeueOutput)
        * enqueue
            * if (weight >= 다리_weights + peek)
                * 다리_Queue.enqueue(대기_Queue.dequeue)
                * 다리_weights += poll
            * else
                * 다리_Queue.enqueue(0)
        * timePassed++
    * timePassed 반환

* **⚠️ 왜 비효율적/실패했는가? (Self-Feedback):**
    * 시간/공간복잡도를 미세하게 더 개선할 수 있었다.
        * 기존 배열에 변수 하나만 관리하면 충분했는데 굳이 `waitingQueue` Deque를 사용해서 offer 하는 시간과 메모리를 지출하였다.
        * `truckCount` 변수를 차감하는 식으로 관리하면 충분했는데 굳이 `trucksPassed` List를 사용해서 메모리를 불필요하게 낭비했다.
    * 단순히 변수 하나만 더 관리하면 되는 건데, 불필요한 자료구조를 도입했다. 공책에 메모한 그림 그대로 구현해서 문제 풀이를 헷갈리지 않게 진행할 수 있었지만 시간/공간복잡도 관점에서는 최선은 아니었다.


### ✅ [SUCCESS] 정답/모범답안 로직
* **✨ 수정된 흐름:**
```java
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int timePassed = 0;
        int weightsOnBridge = 0;
        int truckIndex = 0; // waitingQueue 대신 사용할 배열 인덱스 pointer

        // 다리 상태를 나타내는 큐 (0으로 초기화하지 않고 진행하는 방법도 있지만, 초보자에겐 이 방식이 직관적입니다)
        Deque<Integer> bridgeQueue = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.offer(0);
        }

        // 다리 위에 트럭이 남아있거나, 아직 다리에 진입하지 않은 트럭이 있다면 계속 반복
        while (weightsOnBridge > 0 || truckIndex < truck_weights.length) {
            timePassed++;

            // 1. 다리에서 나가는 트럭 처리
            int passed = bridgeQueue.poll();
            weightsOnBridge -= passed; // 0이 빠지든 트럭이 빠지든 그냥 빼주면 됩니다 (if문 제거로 깔끔하게)

            // 2. 다리에 들어오는 트럭 처리
            if (truckIndex < truck_weights.length) {
                // 다음 트럭이 올라갈 수 있는지 확인
                if (weightsOnBridge + truck_weights[truckIndex] <= weight) {
                    int nextTruck = truck_weights[truckIndex++];
                    bridgeQueue.offer(nextTruck);
                    weightsOnBridge += nextTruck;
                } else {
                    // 못 올라오면 빈 공간(0) 삽입
                    bridgeQueue.offer(0);
                }
            }
        }

        return timePassed;
    }
}
```
## 2. 🎯 한 줄 본질 (What)
* 이 문제는 결국 `Queue`를 활용해서 `주어진 조건을 만족할 때까지 반복하는 로직을 구현`하는 문제다.

---
