class Solution {
    public int minimumRecolors(String blocks, int k) {
        // initial window
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                count++;
            }
        }
        int min = count;

        // iterate the fixed-sized window
        for (int right = k; right < blocks.length(); right++) {
            // entering
            if (blocks.charAt(right) == 'W') {
                count++;
            }

            // leaving
            if (blocks.charAt(right - k) == 'W') {
                count--;
            }

            // update
            min = Math.min(count, min);
        }

        return min;
    }
}