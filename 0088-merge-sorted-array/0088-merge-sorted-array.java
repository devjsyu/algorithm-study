class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // early exit
        if (n == 0) {
            return;
        }

        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int[] answer = new int[m + n];
        int answerIndex = 0;
        int nums1Index = 0;
        int nums2Index = 0;

        // nums1과 nums2 요소 비교 후 삽입
        while (nums1Index < m  && nums2Index < n) {
            answer[answerIndex++] = nums1[nums1Index] < nums2[nums2Index] ? nums1[nums1Index++] : nums2[nums2Index++]; // 후위연산자와 삼항연산자 사용
        }

        // 나머지 일괄 삽입
        // 조건식 분기 없이 필터링
        while (nums1Index < m) {
            answer[answerIndex++] = nums1[nums1Index++];
        }
        
        while (nums2Index < n) {
            answer[answerIndex++] = nums2[nums2Index++];
        }

        // answer 배열의 원소로 기존 nums1 배열에 교체하기 
        for (int i = 0; i < answer.length; i++) {
            nums1[i] = answer[i];
        }
    }
}