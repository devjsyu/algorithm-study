import java.util.*;

class Solution {
    private String word;
    private boolean[][] visited;
    private Map<Cell, List<Cell>> map;
    private List<Cell> firstWordList;

    public boolean exist(char[][] board, String word) {
        // 조기 반환 : word의 시작 문자가 있는지 탐색
        boolean existFirstWord = false;
        firstWordList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    existFirstWord = true;
                    firstWordList.add(new Cell(i, j, board[i][j]));
                }
            }
        }
        if (!existFirstWord) return false;

        int n = board.length;
        int m = board[0].length;

        // 셀 방문 여부 저장할 boolean[][] 초기화
        visited = new boolean[n][m];

        // 2차원 배열을 그래프로 변환하기 위해 각 셀마다 연결된 셀 탐색
        map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 기준 셀 기준 상하좌우 셀 중 유효한 것을 기준 셀에 대해 key-value 매핑하기
                List<Cell> cells = new ArrayList<>();
                if (0 <= i - 1) {
                    cells.add(new Cell(i - 1, j, board[i - 1][j]));
                }
                if (i + 1 < n) {
                    cells.add(new Cell(i + 1, j, board[i + 1][j]));
                }
                if (0 <= j - 1) {
                    cells.add(new Cell(i, j - 1, board[i][j - 1]));
                }
                if (j + 1 < m) {
                    cells.add(new Cell(i, j + 1, board[i][j + 1]));
                }
                map.put(new Cell(i, j, board[i][j]), cells);
            }
        }

        this.word = word;
        return backtracking(new ArrayList<>());
    }

    // 백트래킹
    private boolean backtracking(List<Cell> path) {
        // 종료 조건 : 글자수 충족 여부
        assert path != null;
        if (path.size() == word.length()) {
            return true;
        }

        List<Cell> cells;
        char wordToSearch;

        if (path.isEmpty()) {
            // 첫번째 셀 후보 목록
            cells = firstWordList;
            wordToSearch = word.charAt(0);
        } else {
            // path 가장 마지막 요소
            Cell currentLastCell = path.get(path.size() - 1);

            // 해당 셀에서 갈 수 있는 셀 목록
            cells = map.get(currentLastCell);

            // 찾을 요소
            wordToSearch = word.charAt(path.size());
        }

        for (Cell cell : cells) {
            int i = cell.n;
            int j = cell.m;
            // 찾고자 하는 문자와 일치하고 방문한 적이 없다면
            if (cell.value == wordToSearch && !visited[i][j]) {
                path.add(cell);
                visited[i][j] = true;
                // 하위 탐색에서 찾았다면 즉시 true 반환 (조기 종료)
                if (backtracking(path)) {
                    return true;
                }
                // 원복
                path.remove(path.size() - 1);
                visited[i][j] = false;
            }
        }

        // 가능한 모든 경로를 확인했으나 찾지 못한 경우
        return false;
    }

    public record Cell(
            int n,
            int m,
            char value
    ) {}
} 