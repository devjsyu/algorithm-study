/**
BFS
the typical `graph traversal algorithm` problem

grid 문제에서 내가 그래프를 따로 만들 필요가 없구나!
어차피 grid 자체가 그래프구나!

template for grid problem : private static final dr, dc 

startNode

adjacentNodes

filtering
isOffGrid? isVisited? isMatched?
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        
        Queue<int[]> queue = new ArrayDeque<>();
        int tr = image.length; // tr for total row
        int tc = image[0].length; // tc for total column
        boolean[][] visited = new boolean[tr][tc];
        
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        image[sr][sc] = color;

        // BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            // 4방향 인접 순회
            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d]; // nr for next row
                int nc = current[1] + dc[d]; // nc for next column

                // 탐색 가능 여부 필터링
                // isOffGrid?
                if (nr < 0 || nr >= tr || nc < 0 || nc >= tc) continue;

                // isVisited?
                if (visited[nr][nc]) continue;

                // isMatched?
                if (image[nr][nc] != startColor) continue;

                // 필터링 통과된 요소 처리
                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
                image[nr][nc] = color;
            }
        }

        return image;
    }

    // 상하좌우 delta
    private static final int[] dr = {-1, 1, 0, 0}; // dr for delta row
    private static final int[] dc = {0, 0, -1, 1}; // dc for delta column
}