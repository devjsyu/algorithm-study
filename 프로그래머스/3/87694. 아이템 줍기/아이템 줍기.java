import java.util.*;

class Solution {
    // 상하좌우
    private static final int[] dx = {0, 0, -1, 1}; 
    private static final int[] dy = {1, -1, 0, 0}; 
    
    public int solution(int[][] rectangle, 
                        int characterX, int characterY, 
                        int itemX, int itemY) {
        // 겹치는 왜곡을 방지하기 위해 좌표를 2배씩 일괄 증가
        // 2차원 좌표평면을 표현하는 2차원 배열 초기화
        int[][] map = new int[101][101];
        
        // 모든 도형 전체를 1로 칠하기
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2; // 좌측 하단 x 좌표
            int y1 = rectangle[i][1] * 2; // 좌측 하단 y 좌표
            int x2 = rectangle[i][2] * 2; // 우측 상단 x 좌표
            int y2 = rectangle[i][3] * 2; // 우측 상단 y 좌표
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    map[x][y] = 1;                
                }
            }
        }
        
        // 모든 도형 내부를 0으로 재지정하기
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2; // 좌측 하단 x 좌표
            int y1 = rectangle[i][1] * 2; // 좌측 하단 y 좌표
            int x2 = rectangle[i][2] * 2; // 우측 상단 x 좌표
            int y2 = rectangle[i][3] * 2; // 우측 상단 y 좌표
            for (int x = x1 + 1; x <= x2 - 1; x++) {
                for (int y = y1 + 1; y <= y2 - 1; y++) {
                    map[x][y] = 0;                    
                }
            }
        }
        
        Queue<Coordinates> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[101][101];
        
        queue.offer(new Coordinates(characterX * 2, characterY * 2, 0));
        visited[characterX * 2][characterY * 2] = true;
        
        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            
            if (current.x == itemX * 2 && current.y == itemY * 2) {
                return current.distance / 2;
            }
            
            for (int d = 0; d < 4; d++) {
                int nextX = dx[d] + current.x;
                int nextY = dy[d] + current.y;
                
                if (isValid(nextX, nextY, map, visited)) {
                    Coordinates next = new Coordinates(nextX, nextY, current.distance + 1);
                    
                    queue.offer(next);
                    visited[nextX][nextY] = true;
                }    
            }
        }
        
        return 0;
    }
    
    static class Coordinates {
        int x;
        int y;
        int distance;
        
        public Coordinates(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    private boolean isValid(int x, int y,
                            int[][] map,
                            boolean[][] visited) {
        if (x < 0 || x > 100 || y < 0 || y > 100) return false;
        
        return !visited[x][y] && (map[x][y] == 1);
    }
}