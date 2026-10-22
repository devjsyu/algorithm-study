- Subproblem
    - dp[i] = s[0, i)를 wordDict의 단어들로 완전히 분할할 수 있는지 여부
    - Prefix DP
  

- Recurrence
    - dp[i] = OR(dp[j] && wordDict.contains(s[j:i]))
    - 0 <= j < i
    - 하나 이상의 유효한 분할 위치 j가 존재하면 true
  

- Topological Order
    - for i : 1, ..., n
        - for j : 0, ..., i - 1
  

- Base Case
    - dp[0] = true
  

- Original Problem
    - dp[n]
  

- Time Complexity
    - O(N^3) for Java substring + HashSet implementation
  

- Key Insight
    - Prefix DP
    - 마지막 분할 위치 j를 기준으로 문제를 분할(segmentation)한다.
    - 유효한 prefix dp[j] 뒤에 사전의 단어를 붙일 수 있다면 dp[i] = true