### key takeaway
- `incoming`, `outgoing`으로 나누어 생각하자.
```java
sum -= nums[i - k]; // incoming
sum += nums[i];     // outgoing
```
- `max` 초기화는 window 초기화 이후 한다.

### my code
```java
/**
Why Fixed-size Sliding Window?
고정 크기 k의 연속 구간을 반복해서 계산하기 때문이다!
매번 구간 전체를 다시 계산하지 않고 이전 window에서 나가는 값을 빼고 새로 들어오는 값을 더해 다음 window의 값을 O(1)에 갱신할 수 있다. 따라서 전체를 O(N^2)이 아니라 O(N)에 처리할 수 있다.
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        
        // build the first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        long max = sum;

        // slide the window
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k]; // outgoing
            sum += nums[i];     // incoming
            max = Math.max(max, sum);
        }

        return (double) max / k;
    }
}
```