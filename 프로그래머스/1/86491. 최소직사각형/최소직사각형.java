class Solution {
    public int solution(int[][] sizes) {
        int maxH = -1;
        int maxW = -1;
        
        for (int i = 0; i < sizes.length; i++) {
            int h = sizes[i][0];
            int w = sizes[i][1];

            // h < w 경우 바꿔치기
            if (h < w) {
                int temp = h;
                h = w;
                w = temp;
            }

            // 각각 h, w에서 최대값 구하기
            if (h > maxH) {
                maxH = h;
            }
            
            if (w > maxW) {
                maxW = w;
            }
        }
        
        return maxH * maxW;
    }
}