### analysis
- Pattern: contiguous subarrays/substrings of fixed size `k`
- Naive: recompute each window from scratch -> $O(N*K)$, worst case $O(N^2)$
- Fixed-size Sliding Window: reuse the previous window state -> $O(N)$
- Auxiliary Space: $O(1)$

### key idea
- Adjacent fixed-size windows overlap except for two elements:
  - remove the outgoing element's contribution
  - add the incoming element's contribution
- This reduces each window update from $O(K)$ to $O(1)$.

### pseudo code
```java
// build the first window state
// initialize answer

// slide the window
    // add incoming element
    // remove outgoing element
    // update answer
```