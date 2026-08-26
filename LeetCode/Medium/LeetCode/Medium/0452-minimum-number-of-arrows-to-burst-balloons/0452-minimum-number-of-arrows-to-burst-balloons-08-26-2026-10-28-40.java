class Solution {
    public int findMinArrowShots(int[][] points) {
        // 최대한 겹치지 않아야 중복 파괴되지 않는다
        // X의 end 좌표 기준으로 오름차순 정렬
        Arrays.sort(points, (x1, x2) -> {
            return Integer.compare(x1[1], x2[1]);
        });

        int count = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }

        return count;
    }
}