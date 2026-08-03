import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 정답 변수 초기화
        int answer = -1;

        // Queue 자료구조 초기화
        Queue<Process> processes = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            // Process 객체 초기화 및 Queue에 추가
            processes.offer(new Process(i, priorities[i]));
        }

        // 우선순위 정렬
        Arrays.sort(priorities); // 오름차순
        int order = 0; // 역순으로 순회하기 때문에 순서 정보 담을 변수 필요

        // 가장 높은 우선순위인지 여부 검사하면서 순회
        for (int i = priorities.length - 1; i >= 0; i--) {
            int maxPriority = priorities[i];
            // 가장 높은 우선순위가 나올 때까지 대기 큐 마지막 순서로 넣는 작업 반복
            while (!processes.isEmpty() && maxPriority != processes.peek().priority) {
                Process undoneProcess = processes.poll();
                processes.offer(undoneProcess);
            }

            // 가장 높은 우선순위와 일치할 경우 대기 큐에서 꺼내기
            Process doneProcess = processes.poll();

            // 순서 업데이트
            order++;

            // 조기 종료
            if (doneProcess != null && doneProcess.index == location) {
                return order;
            }
        }
        return order;
    }

    // index와 priority를 필드로 갖는 Process record 클래스 정의
    public record Process(
            int index,
            int priority
    ) {}
}