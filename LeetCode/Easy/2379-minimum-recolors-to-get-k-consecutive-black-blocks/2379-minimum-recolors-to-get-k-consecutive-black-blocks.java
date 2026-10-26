// Fixed-size Sliding Window
class Solution {
    public int minimumRecolors(String blocks, int k) {
        // build the window
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                count++;
            }
        }

        int min = count;

        // slide the window
        for (int i = k; i < blocks.length(); i++) {
            // outgoing
            if (blocks.charAt(i) == 'W') {
                count++;
            }

            // incoming
            if (blocks.charAt(i - k) == 'W') {
                count--;
            }

            if (count < min) {
                min = count;
            }
        }

        return min;
    }
}