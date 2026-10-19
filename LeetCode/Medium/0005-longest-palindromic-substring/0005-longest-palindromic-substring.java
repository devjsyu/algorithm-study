class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        int max = 1;
        int[] index = {0, 0};
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalindrome[i + 1][j - 1]);

                if (isPalindrome[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    index = new int[]{i, j};
                }
            }
        }

        return s.substring(index[0], index[1] + 1);
    }
}