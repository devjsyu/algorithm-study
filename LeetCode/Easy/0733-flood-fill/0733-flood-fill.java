class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return bfs(image, sr, sc, color);
    }

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    private int[][] bfs(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        int originalColor = image[sr][sc];
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + DR[d];
                int nc = current[1] + DC[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                if (image[nr][nc] != originalColor) {
                    continue;
                }

                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
                image[nr][nc] = color;
            }
        }

        return image;
    }
}