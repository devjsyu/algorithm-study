import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(1, 1, maps.length, maps[0].length, maps);
    }
    
    // 상하좌우
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
        
    private int bfs(int startR, int startC, int r, int c, int[][] maps) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                visited[i][j] = -1; // 미방문일 경우 -1
            }
        }
        
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = 1; // 시작은 1칸
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentR = current[0];
            int currentC = current[1];
            
            // 갈 수 있는 경우의 수 순회
            for (int d = 0; d < 4; d++) {
                int nextR = currentR + dr[d];
                int nextC = currentC + dc[d];
                                
                // 범위 벗어난 경우 필터링
                if (nextR < 1 || nextR > r || nextC < 1 || nextC > c) {
                    continue;
                }
                
                // 이미 방문한 경우 필터링
                if (visited[nextR][nextC] != -1) continue;

                // 갈 수 없는 경우 필터링
                if (maps[nextR - 1][nextC - 1] == 0) {
                    continue;
                }
                
                // 방문 배열 원소에 지나가야 하는 칸의 개수 지정
                visited[nextR][nextC] = visited[currentR][currentC] + 1;
                queue.offer(new int[]{nextR, nextC});
            }
        }
        
        // 마지막 칸에 도달할 수 없어서 미방문일 경우
        if (visited[r][c] == -1) {
            return -1;
        } else {
            return visited[r][c]; // 지나가야 하는 칸의 개수
        }
    }
}