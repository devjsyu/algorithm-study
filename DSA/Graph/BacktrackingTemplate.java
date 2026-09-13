import java.util.*;

class BacktrackingTemplate {
    static void dfs(int depth) {
        // 종료 조건
        if (depth == targetDepth) {
            // 정답 처리
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            // 선택
            visited[i] = true;

            dfs(depth + 1);

            // 선택 취소
            visited[i] = false;
        }
    }
}