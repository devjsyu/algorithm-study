import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    // 프로세스 정보를 저장할 클래스 (원래 위치와 중요도)
    static class Process {
        int index;      // 원래 위치
        int priority;   // 중요도

        Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new ArrayDeque<>();

        // 1. 큐에 모든 프로세스(원래 위치, 중요도)를 순서대로 넣음
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }

        // 2. 중요도를 오름차순으로 정렬하여 가장 높은 중요도를 추적
        Arrays.sort(priorities);
        int maxIndex = priorities.length - 1; // 가장 큰 중요도의 인덱스

        int executionOrder = 0; // 실행 순서 카운터

        // 3. 큐가 빌 때까지 프로세스 실행 여부 판단
        while (!queue.isEmpty()) {
            Process current = queue.poll();

            // 현재 프로세스가 남은 프로세스 중 가장 높은 중요도를 가지고 있는 경우
            if (current.priority == priorities[maxIndex]) {
                executionOrder++; // 실행 완료
                maxIndex--;       // 다음으로 높은 중요도로 갱신

                // 내가 찾고자 하는 위치의 프로세스라면 순서 반환
                if (current.index == location) {
                    return executionOrder;
                }
            } else {
                // 더 높은 중요도를 가진 프로세스가 있다면 다시 큐의 맨 뒤로 넣음
                queue.offer(current);
            }
        }

        return executionOrder;
    }
}