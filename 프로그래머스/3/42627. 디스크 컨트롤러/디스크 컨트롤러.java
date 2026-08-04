import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. Work 객체 생성 및 정렬
        List<Work> works = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            works.add(new Work(i, jobs[i][0], jobs[i][1]));
        }
        
        // 요청시간 순 정렬 (요청시간이 같으면 index 순)
        List<Work> worksOrdered = works.stream()
                .sorted((w1, w2) -> {
                    if (w1.requestedAt != w2.requestedAt) {
                        return Integer.compare(w1.requestedAt, w2.requestedAt);
                    }
                    return Integer.compare(w1.index, w2.index);
                })
                .toList();

        int done = 0;
        int[] turnarounds = new int[jobs.length];
        int currentTime = 0;

        int worksIdx = 0; // worksOrdered 리스트를 순회할 인덱스
        int turnaroundIdx = 0;

        // PriorityQueue는 반복문 밖에서 1번만 생성하여 계속 재사용 (소요시간 -> 요청시간 -> index 순)
        PriorityQueue<Work> waiting = new PriorityQueue<>((w1, w2) -> {
            if (w1.duration != w2.duration) {
                return Integer.compare(w1.duration, w2.duration);
            } else if (w1.requestedAt != w2.requestedAt) {
                return Integer.compare(w1.requestedAt, w2.requestedAt);
            } else {
                return Integer.compare(w1.index, w2.index);
            }
        });

        // 주어진 작업을 모두 완료할 때까지 반복
        while (done < jobs.length) {

            // 2. [수정] 현재 시점(currentTime) 이하로 도착한 모든 작업을 대기열(waiting)에 누적 투입
            while (worksIdx < jobs.length && worksOrdered.get(worksIdx).requestedAt <= currentTime) {
                waiting.offer(worksOrdered.get(worksIdx));
                worksIdx++;
            }

            // 3. [수정] 대기열이 비어있는 경우 (CPU Idle 상태) 처리
            if (waiting.isEmpty()) {
                // 아직 처리 안 된 다음 작업의 요청 시간으로 현재 시간을 점프
                currentTime = worksOrdered.get(worksIdx).requestedAt;
                continue; // 시간을 업데이트했으므로 다시 while문 처음으로 돌아가 대기열에 추가
            }

            // 4. 대기열에서 가장 우선순위가 높은 작업 처리
            Work currentWork = waiting.poll();
            done++;

            // 시간 업데이트 및 turnaround 계산
            currentTime += currentWork.duration;
            int turnaround = currentTime - currentWork.requestedAt;
            
            turnarounds[turnaroundIdx++] = turnaround;
        }

        // 5. 평균 turnaround 시간 계산
        int sum = 0;
        for (int turnaround : turnarounds) {
            sum += turnaround;
        }

        return sum / turnarounds.length;
    }

    // 임의의 record 구조 유지
    public record Work(
            int index,
            int requestedAt,
            int duration
    ) {}
}