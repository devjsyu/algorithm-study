import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        // 우선순위 큐 초기화
        PriorityQueue<Work> works = new PriorityQueue<>((w1, w2) -> {
            // 커스텀 정렬 기준
            if (w1.processingTime == w2.processingTime) {
                return w1.index - w2.index;
            } else {
                return w1.processingTime - w2.processingTime;
            }
        });

        List<Work> list = new ArrayList<>();

        for (int i = 0; i < tasks.length; i++) {
            Work work = new Work(i, tasks[i][0], tasks[i][1]);
            list.add(work);
        }

        List<Work> temp = list.stream().sorted((w1, w2) -> w1.enqueueTime - w2.enqueueTime).toList();
        List<Work> ordered = new ArrayList<>(temp);

        int[] arr = new int[tasks.length];

        int i = 0;
        int j = 0;
        int count = 0;
        int currentTime = 0;

        while (count < tasks.length) {
            // 대기열 넣기
            while (i < tasks.length && currentTime >= ordered.get(i).enqueueTime) {
                Work work = ordered.get(i);
                works.offer(work);
                i++;
            }
            
            // 대기열 뽑기
            if (!works.isEmpty()) {
                Work work = works.poll();
                arr[j] = work.index;
                j++;
                currentTime += work.processingTime;
                count++;
            } else {
                currentTime = ordered.get(i).enqueueTime;
            }
        }
        return arr;
    }

    public record Work(int index, int enqueueTime, int processingTime) {}
}