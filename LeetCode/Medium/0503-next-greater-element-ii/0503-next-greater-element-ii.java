class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // 자료구조 초기화
        Deque<Integer> indexes = new ArrayDeque<>();
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1); // 기본값 -1로 초기화

        // 원형 배열을 처리하기 위해 기존 배열 길이의 2배만큼 순회
        for (int i = 0; i < nums.length * 2; i++) {
            while (!indexes.isEmpty() && nums[indexes.peek()] < nums[i % nums.length]) {
                int popped = indexes.pop();
                answer[popped] = nums[i % nums.length];
            }
            // 첫 번째 바퀴(0 ~ n-1)일 때만 스택에 인덱스를 삽입
            // (두 번째 바퀴는 기존 원소들의 짝을 찾아주기 위한 탐색용)
            if (i < nums.length) {
                indexes.push(i % nums.length);
            }
        }

        return answer;
    }
}