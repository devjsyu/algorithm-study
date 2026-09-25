// 배열 인덱스에 찾고자 하는 숫자를 매핑하고, 배열 원소를 빈도수로 매핑한다
// 시간복잡도 O(2N), 공간복잡도 O(N)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] frequency = new int[nums.length + 1]; // 1-index

        for (int num : nums) {
            frequency[num]++;
        }

        int duplicated = 0;
        int missing = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (frequency[i] == 2) {
                duplicated = i;
            } else if (frequency[i] == 0) {
                missing = i;
            }
        }

        return new int[]{duplicated, missing};
    }
}