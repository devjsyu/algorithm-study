## 1. 어떻게 시도했는가? (How)
- **"[FAIL] 어떻게 풀려고 했는지 설명해보자"**
- key : value
    - "muzi" : Set<String>
    - 신고자 : 신고 받은 사람 목록
    - HashMap<String, Set<String>> reportedUsersByUser
- key : value
    - "frodo" : Integer
    - 유저 : 신고 당한 횟수
    - HashMap<String, Integer> reportCountByUser
- 신고 당한 횟수가 k보다 크거나 같다면?
- 각 인덱스별 받아야 할 메일 개수를 담은 배열
    - primitive data type variable 최종 갱신
    - int[] answer

- 이중반복문 없이 Hash를 통해서 O(1) 또는 O(N)을 달성 가능한가?

- id_list를 이용하여 reportedUsersByUser, reportCountByUser 초기화?
- report.length 순회하면서 reportedUsersByUser key-value put
- id_list 순회하면서 ...
----
- `신고자 : 신고 받은 사람 목록`이 아니라 `신고 받은 사람 : 신고한 사람 목록`을 했어야 했다.
- 왜 그랬어야 했는가?
- 그래야 `신고 받은 사람`을 순회할 때, 단순히 `신고한 사람 목록`의 size와 k 비교하기만 하면 조건 달성 여부를 바로 알 수 있다.
- 원래 내 방식대로라면, 더 복잡하다. 엉뚱한 연관관계 방향으로 문제를 접근했다.
- 왜냐? 단순히 문장에서 보이는 순서대로 접근했기 때문이다. 
- `신고자 : 신고 받은 사람 목록`도 말이 되고, `신고 받은 사람 : 신고한 사람 목록`도 말이 되기 때문에 잘못된 걸 바로 알아차리지 못했다.

## 2. 한 줄 본질 (What)
- "이 문제는 결국 올바른 연관관계 방향을 갖고 `HashMap`으로 집계값을 구하는 거다."

## 3. 아차! 포인트 (Why)
- "내가 막혔던 이유는 `올바른 연관관계 방향`을 놓쳐서였다." (딱 하나만!)

## 4. 다음에 보면? (Trigger)
- "`N:1`이든, `1:N`이든 문제 조건에 적합한 `연관관계`를 우선해서 key-value를 설정한다."