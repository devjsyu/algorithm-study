// Fixed-size Sliding Window
class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int count = 0;

        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
        }

        int max = count;

        for (int right = k; right < s.length(); right++) {
            // outgoing
            if (set.contains(s.charAt(right))) {
                count++;
            }

            // incoming
            if (set.contains(s.charAt(right - k))) {
                count--;
            }

            if (max < count) {
                max = count;
            }
        }

        return max;
    }
}