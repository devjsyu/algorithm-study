class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // 자료구조 초기화
        Deque<Integer> indexes = new ArrayDeque<>();
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);

        for (int i = 0; i < nums.length * 2; i++) {
            while (!indexes.isEmpty() && nums[indexes.peek()] < nums[i % nums.length]) {
                int popped = indexes.pop();
                answer[popped] = nums[i % nums.length];
            }
            if (i < nums.length) {
                indexes.push(i % nums.length);
            }
        }

        return answer;
    }
}