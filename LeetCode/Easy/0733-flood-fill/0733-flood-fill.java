/**
Grid BFS
- 시작점의 최초 color 값 변수 저장
- 상하좌우 탐색하면서 큐에 삽입
- 시작점의 최초 color 값과 동일한 경우 신규 color 값으로 업데이트
 */
import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];

        int oldColor = image[sr][sc];

        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int cr = curr[0];
            int cc = curr[1];

            if (image[cr][cc] == oldColor) {
                image[cr][cc] = color;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cr + DR[d];
                int nc = cc + DC[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                if (image[nr][nc] != oldColor) {
                    continue;
                }

                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return image;
    }

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};
}