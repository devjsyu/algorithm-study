/**
Why Two Pointers?
- The brute force approach needs repeatedly scanning the same sequence with nested loops, which leads to O(N^2) time complexity.
- The certain condition of this problem(whether s[i] is matched with t[j]) lets narrowing the scope of searching safely without the possibility of missing the answer. 
- The two pointers approach, however, can turn it into the linear search, which is O(N) time complexity.
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int targetIndex = 0;
        int searchIndex = 0;

        while (targetIndex < n && searchIndex < m) {
            if (s.charAt(targetIndex) == t.charAt(searchIndex)) {
                targetIndex++;
            }
            searchIndex++;
        }

        return targetIndex == n; 
    }
}