import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        // 최소 힙 (최소값을 얻기 위한 큐)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 최대 힙 (최대값을 얻기 위한 큐)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);
            
            if (command.equals("I")) {
                // 숫자를 삽입하는 경우
                minHeap.offer(number);
                maxHeap.offer(number);
            } else if (command.equals("D")) {
                if (minHeap.isEmpty()) {
                    // 큐가 비어있으면 삭제 명령 무시
                    continue;
                }
                
                if (number == 1) {
                    // 최댓값을 삭제
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else if (number == -1) {
                    // 최솟값을 삭제
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }
        
        if (minHeap.isEmpty()) {
            // 큐가 비어있는 경우 [0, 0] 반환
            return new int[] {0, 0};
        } else {
            // 큐가 비어있지 않은 경우 [최댓값, 최솟값] 반환
            return new int[] {maxHeap.peek(), minHeap.peek()};
        }
    }
}
