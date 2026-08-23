class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int mIndex = m;
        int nIndex = n;
        int i = 0;
        while (m > 0 && n > 0) {
            if (nums1[mIndex - m] <= nums2[nIndex - n]) {
                arr[i] = nums1[mIndex - m];
                m--;
                i++;
            } else {
                arr[i] = nums2[nIndex - n];
                n--;
                i++;
            }
        }
        while (m == 0 && n > 0) {
            arr[i] = nums2[nIndex - n];
            n--;
            i++;    
        }
        while (m > 0 && n == 0) {
            arr[i] = nums1[mIndex - m];
            m--;
            i++;
        }
        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = arr[j];
        }
    }
}