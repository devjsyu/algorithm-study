import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int maxVisit = 0;

    public int solution(int k, int[][] dungeons) {
        List<Dungeon> dungeonList = new ArrayList<>();
        for (int[] dungeon : dungeons) {
            dungeonList.add(new Dungeon(dungeon[0], dungeon[1]));
        }

        boolean[] visited = new boolean[dungeonList.size()];
        Arrays.fill(visited, false);

        int currentStat = k;
        List<Dungeon> currentPath = new ArrayList<>();

        backtracking(currentStat, currentPath, dungeonList, visited);

        return maxVisit;
    }

    public record Dungeon(
            int minimalStatNeeded,
            int unitStatConsumed
    ) {}

    private void backtracking(int currentStat, List<Dungeon> currentPath, List<Dungeon> dungeonList, boolean[] visited) {
        if (!currentPath.isEmpty()) {
            Dungeon dungeonToGO = currentPath.get(currentPath.size() - 1);

            // 새로 추가한 던전을 가지 못하는 경우
            if (currentStat < dungeonToGO.minimalStatNeeded) {
                int visitCount = currentPath.size() - 1;
                if (visitCount > maxVisit) {
                    maxVisit = visitCount;
                }
                return;
            } else {
                // 새로 추가한 던전을 갈 수 있는 경우
                // 피로도 갱신
                currentStat -= dungeonToGO.unitStatConsumed;
            }

            if (currentPath.size() == dungeonList.size()) {
                maxVisit = dungeonList.size();
                return;
            }
        }

        for (int i = 0; i < dungeonList.size(); i++) {
            if (!visited[i]) {
                currentPath.add(dungeonList.get(i)); // branching
                visited[i] = true;
                backtracking(currentStat, currentPath, dungeonList, visited); // recursion
                currentPath.remove(currentPath.size() - 1); // popping
                visited[i] = false;
            }
        }
    }
}