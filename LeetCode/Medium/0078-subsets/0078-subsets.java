class Solution {
    private List<List<Integer>> answer = new ArrayList<>();
    private int[] nums;
    private int length;
    private boolean[] visited;
    
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        List<Integer> state = new ArrayList<>();

        backtracking(0, state);

        return answer;
    }

    private void backtracking(int start, List<Integer> state) {
        answer.add(new ArrayList<>(state));
        
        if (state.size() == length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            state.add(nums[i]);
            backtracking(i + 1, state);
            state.remove(state.size() - 1);
        }
    }
}