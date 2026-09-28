### feedback
- 메서드 A가 메서드 B를 호출했을 때, 메서드 A의 single-CPU 점유시간, 즉, exclusive time은 메서드 B의 exclusive time이 차감되어야 한다.
- stack.peek()의 의미: 콜스택 속 남아있는, 가장 위의 메서드
- 메서드 id를 인덱스로 하는 exclusive time 배열을 계속 갱신