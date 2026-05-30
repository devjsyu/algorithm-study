class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // early exit
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        int[] answer = new int[m + n];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 != m || index2 != n) {
            if (index1 == m) {
                answer[index] = nums2[index2];
                index2++;
                index++;
                continue;
            }
            if (index2 == n) {
                answer[index] = nums1[index1];
                index1++;
                index++;
                continue;
            }

            if (nums1[index1] >= nums2[index2]) {
                answer[index] = nums2[index2];
                index2++;

            } else {
                answer[index] = nums1[index1];
                index1++;
            }
            index++;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = answer[i];
        }
    }
}