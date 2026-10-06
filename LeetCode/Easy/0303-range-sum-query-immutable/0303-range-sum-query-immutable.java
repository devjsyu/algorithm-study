/**
Why Prefix Sum?
특정 구간의 합을 반복적으로 구한다면, 각 인덱스별 누적 합을 미리 구해두고, 끝 인덱스의 값과 시작 인덱스의 값 간의 차감을 통해 반복 연산을 줄일 수 있다.
 */
class NumArray {
    private int[] nums;
    private int[] prefix;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        this.prefix = new int[nums.length + 1];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefix[right] - prefix[left] + nums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */