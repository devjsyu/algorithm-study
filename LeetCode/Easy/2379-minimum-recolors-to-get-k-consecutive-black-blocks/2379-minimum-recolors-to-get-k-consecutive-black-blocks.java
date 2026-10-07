/**
Fixed-size Sliding Window
 */
class Solution {
    public int minimumRecolors(String blocks, int k) {
        // build the first window
        int recolorCount = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                recolorCount++;
            }
        }

        int min = recolorCount;

        // slide the window
        for (int i = k; i < blocks.length(); i++) {
            // incoming
            if (blocks.charAt(i) == 'W') {
                recolorCount++;
            }
            
            // outcoming
            if (blocks.charAt(i - k) == 'W') {
                recolorCount--;
            }

            min = Math.min(min, recolorCount);
        }

        return min;
    }
}