## note
### Analysis
1. Boyer Moore's majority vote algorithm
   - Time Complexity $O(N)$ Space Complexity $O(1)$
2. counting with HashMap and iterate the values and return the max
    - Time Complexity $O(N)$ Space Complexity $O(N)$
3. sort the array and return the middle
   - Time Complexity $O(NlogN)$ Space Complexity $O(1)$


### How I solved
**Boyer Moore's majority vote algorithm**
> Suppose you are in an election and won strictly more than half of the total votes (> 50%). 
> If you pair up and eliminate one of your votes with every vote cast for any other candidate, 
> you are mathematically guaranteed to have at least one vote remaining.
1. Initialize:
    - candidate = null (or arbitrary)
    - count = 0

2. 1st Pass (Find Candidate):
    - For each element in array:
        * If count == 0:
          set candidate = current element, count = 1
        * Else if current element == candidate:
          count++
        * Else:
          count--

3. 2nd Pass (Verification - optional if majority is guaranteed):
    - Count actual occurrences of candidate in the array
    - If occurrences > array.length / 2, return candidate
    - Otherwise, return "no majority element"


### Key Takeaway
> **정보 압축의 극한: 상태 저장 비용의 파괴 ($O(1)$ 공간 복잡도)**
> 
> **보이어-무어의 발상 전환**: "모든 빈도를 알 필요는 없다. 서로 다른 둘을 1:1로 지워버려도 최종 과반수는 무조건 살아남는다"는 상쇄 원리를 통해, 오직 candidate(후보 1개)와 count(정수 1개)라는 2개의 변수만으로 문제를 해결합니다.
> 
> **스트리밍 데이터(Streaming Data) 처리의 이론적 토대**
> 
> **무한한 데이터의 처리**: 실시간으로 끝없이 쏟아지는 네트워크 트래픽 분석, 로그 모니터링, 검색어 트렌드 등에서는 데이터의 전체 크기($N$)를 미리 알 수 없고, 메모리에 전체를 담는 것 자체가 불가능합니다.
> 
> **One-Pass 처리**: 데이터를 뒤로 되돌아가지 않고 단 한 번만 스캔(Single Pass, $O(N)$ 시간)하면서 실시간으로 유력 후보를 추적할 수 있는 스트리밍 알고리즘의 초기 기념비적 모델입니다.
> 
> 
> _보이어-무어 알고리즘은 "문제를 해결하기 위해 필요한 최소한의 정보가 무엇인가?"라는 질문에 완벽한 해답을 제시한 알고리즘입니다. 전체를 다 기록하지 않고 '차이(상쇄)'만 기록함으로써 시간과 공간을 모두 최적화한 알고리즘 설계의 정수입니다._

## code
```java
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}
```