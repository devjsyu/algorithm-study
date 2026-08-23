import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        // 최소 힙을 사용하여 우선순위 큐 생성
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        // 주어진 스코빌 지수를 힙에 추가
        for (int s : scoville) {
            heap.add(s);
        }
        
        int answer = 0;
        
        // 힙에서 가장 작은 원소가 K 이상이 될 때까지 반복
        while (heap.peek() < K) {
            // 섞을 원소가 2개 이상 있어야 섞기 가능
            if (heap.size() < 2) {
                return -1;  // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없음
            }
            
            // 가장 맵지 않은 음식과 두 번째로 맵지 않은 음식을 꺼냄
            int first = heap.poll();
            int second = heap.poll();
            
            // 새로운 스코빌 지수 계산 후 힙에 추가
            int newScoville = first + (second * 2);
            heap.add(newScoville);
            
            // 섞은 횟수 증가
            answer++;
        }
        
        return answer;
    }
}
