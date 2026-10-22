/**
Opposite Direction Two Pointers
=> 주어진 배열이 이미 정렬되어 있기 때문에 배열 양 끝 경계를 각각 이동하여 최댓값을 새로운 배열 공간에 배열의 끝부터 크기가 큰 순서대로 저장한다.
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {
            if (nums[left] > nums[right]) {
                answer[index] = nums[left];
                left++;
            } else {
                answer[index] = nums[right];
                right--;
            }
            index--;
        }

        return answer;
    }
}