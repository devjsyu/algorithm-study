// BFS
// 인접 검사 : 4방향에 대해 범위? 방문? 필터링
// 방문 여부와 이미지 픽셀 값을 동시에 저장하는 2차원 배열
// 방문해서 이미지 픽셀 값 업데이트 하면 해당 원소 직접 업데이트
// BFS 후 2차원 배열 전체 순회하면서 미방문이라면 기존 2차원 배열의 원소값 덮어씌우기 
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startValue = image[sr][sc];

        if (startValue == color) return image;
        
        Queue<Coordinates> queue = new ArrayDeque<>();

        queue.offer(new Coordinates(sr, sc));
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nextR = current.r() + dr[d];
                int nextC = current.c() + dc[d];

                if (nextR < 0 || nextR >= image.length || nextC < 0 || nextC >= image[0].length) {
                    continue;
                }

                if (image[nextR][nextC] != startValue) {
                    continue;
                } 

                queue.offer(new Coordinates(nextR, nextC));
                image[nextR][nextC] = color;
            }
        }

        return image;
    }

    // 상하좌우
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public record Coordinates(int r, int c) {}
}