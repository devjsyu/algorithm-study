## 1. 어떻게 시도했는가? (How)
- "[FAIL] 어떻게 풀려고 했는지 설명해보자"
  - 필요한 자료구조
  - ArrayList<Integer>[] tree (트리 구조)
      -  Integer는 index
  - HashMap<String, Integer> sellerToSales (필수 아닌 듯)
      - 판매원별 초기 매출액 계산할 때 사용
      - 10% 금액을 부모 노드(추천인)에게 전달
      - 10원 미만이거나 "-"에 도달할 때까지 반복
  - HashMap<String, Integer> nameToIndex (필수)
      - referral 계산할 때 사용
      - "-"는 "center"이자 0 인덱스
  - HashMap<String, Integer> nameToProfit
      - 최종 누적 합산된 value 출력
  - 조사할 때마다 nameToIndex 필수적으로 사용 
---
- 기존 시도가 왜 실패했을까?
  - 지나치게 복잡해서 제때 풀지 못했다.
  - 예제 풀이과정을 그대로 코드로 `일대일 번역`하고자 하는 행동이 효과적이지 않았다.
  - 모범답안은 더 간단하게 푼다. 모범답안의 포인트는 아래와 같다.
    - 주요 자료구조
      - HashMap<String, String> userToBoss
        - 회원별 추천인 매핑
        - 회원의 `부모`가 누구인지 검색하기 위해 사용한다.
      - HashMap<String, Integer> userToProfit
        - 회원별 이익 매핑
        - 회원의 이익을 집계하기 위해 사용한다.
    - 주요 로직
      - 아래 조건이 충족하는 한 계속 반복한다.
        - 10% 한 돈이 0보다 크다.
        - 보스가 "-"가 아니다.
      - 반복문 내에서 money와 currentUser를 다음 차수를 위해 갱신

## 2. 한 줄 본질 (What)
- "이 문제는 결국 `HashMap`으로 `Tree`처럼 `부모`를 검색하고, `반복문`과 주어진 조건(`비즈니스 로직`)을 통해 도출된 돈을 회원별로 `집계`해서 누적 합산된 이익을 구하는 거다."

## 3. 아차! 포인트 (Why)
- "내가 막혔던 이유는 `1:1 매칭 번역`에 집착해서 더 간단하고 `적합한 자료구조`를 놓쳐서였다." (딱 하나만!)

## 4. 다음에 보면? (Trigger)
- "`검색`, `집계` 패턴이 보이면 다음엔 `HashMap`부터 떠올리자."