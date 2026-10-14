class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            // 현재 위치에서 끝나는 부분 배열의 후보
            int a = x;
            int b = maxProduct * x;
            int c = minProduct * x;

            // 이전 상태를 이용해 두 상태를 동시에 갱신
            maxProduct = Math.max(a, Math.max(b, c));
            minProduct = Math.min(a, Math.min(b, c));

            // 전체 최대 곱 갱신
            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}