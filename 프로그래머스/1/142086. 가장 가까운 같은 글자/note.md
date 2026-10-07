### feedback

- Java의 `char`는 정수형이며, 산술 연산 시 `int`로 승격된다.
    - `c - 'a'`를 이용하면 소문자 `c`를 0~25 범위의 인덱스로 변환할 수 있다.  
    

- Naive approach: 
  - 이전 위치를 반복 탐색 → $O(N^2)$
  

- Optimized approach: 
  - 배열을 lookup table로 사용하여 각 문자의 last seen index를 $O(1)$에 조회 → $O(N)$
  - 입력 문자 종류가 **_고정_**되어 있으므로 lookup table의 auxiliary space는 $O(1)$.