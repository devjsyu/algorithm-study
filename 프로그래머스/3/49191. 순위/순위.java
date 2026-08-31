import java.util.*;

/*
승패 관계를 방향이 있는 그래프로 모델링하고,
탐색을 통해 관계가 명확한 노드의 수를 세기
 */
class Solution {
    public int solution(int n, int[][] results) {
        // 전체 인접 리스트 초기화
        List<List<Integer>> winGraph = new ArrayList<>();
        List<List<Integer>> loseGraph = new ArrayList<>();

        // 각 노드에 대한 인접 리스트 초기화
        for (int i = 0; i <= n; i++) {
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }

        // 모든 경기 결과 순회하면서 전체 인접 리스트 업데이트
        for (int[] r : results) {
            winGraph.get(r[0]).add(r[1]);
            loseGraph.get(r[1]).add(r[0]);
        }

        // 모든 노드에 대해 순회
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            // 각 노드별 이긴 횟수 집계
            int winCount = bfs(i, winGraph, n);
            // 각 노드별 진 횟수 집계
            int loseCount = bfs(i, loseGraph, n);

            // 이긴 횟수와 진 횟수의 합이 n - 1이 되는 경우를 집계
            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private int bfs(int start, List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++; // 이기거나 진 횟수 업데이트
                    queue.offer(next);
                }
            }
        }

        return count;
    }
}