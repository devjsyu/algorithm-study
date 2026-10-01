class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if ("aeiou".contains(String.valueOf(s.charAt(i)))) {
                count++;
            }
        }
        int max = count;

        for (int right = k; right < s.length(); right++) {
            if ("aeiou".contains(String.valueOf(s.charAt(right)))) {
                count++;
            }

            if ("aeiou".contains(String.valueOf(s.charAt(right - k)))) {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}