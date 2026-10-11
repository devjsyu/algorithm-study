class Solution {
    public void reverseString(char[] s) {
        int half = s.length / 2;

        int left = 0;
        int right = s.length - 1;
        for (int i = 0; i < half; i++) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}