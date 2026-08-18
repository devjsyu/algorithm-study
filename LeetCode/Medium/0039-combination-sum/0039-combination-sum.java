class Solution {
    private List<List<Integer>> combinations = new ArrayList<>();
    private int target;
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        List<Integer> state = new ArrayList<>();
        int sum = 0;
        backtracking(state, 0, 0);

        return combinations;        
    }

    private void backtracking(List<Integer> state, int sum, int lastIndex) {
        // 종료 조건 : target과 일치
        if (!state.isEmpty() && sum == target) {
            combinations.add(new ArrayList<>(state)); // Deep copy
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            // 해당 원소를 추가했을 때 target보다 작거나 같은지
            if (lastIndex <= i && sum + candidates[i] <= target) {
                state.add(candidates[i]);
                int temp = lastIndex;
                lastIndex = i;
                sum += candidates[i];
                backtracking(state, sum, lastIndex);
                
                // pop
                state.remove(state.size() - 1);
                sum -= candidates[i]; 
                lastIndex = temp;
            }
        }
    }
}