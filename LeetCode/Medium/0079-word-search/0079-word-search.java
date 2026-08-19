import java.util.*;

class Solution {
    private String word;
    private boolean[][] visited;
    private Map<Cell, List<Cell>> map;
    private List<Cell> firstWordList;
    private List<List<Cell>> list = new ArrayList<>();

    public boolean exist(char[][] board, String word) {
        /*
        m, n 2종류가 있는데, 어떻게 선택지를 만들지?
        현재 셀 기준 오로지 인접 셀만 선택가능한 것으로 어떻게 제한할 수 있지?

        2차원 배열을 그래프 형태로 바꿀 수 있나?
        DFS, backtracking보다는 BFS가 더 적합하지 않을까?

        root node를 만들 수가 있을까?

        m, n 인덱스를 필드로 갖는 임의의 클래스를 만들고, 2차원 배열을 모두 순회해서 key-value 매핑하기?
        */

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
        backtracking(new ArrayList<>());

        for (List<Cell> path : list) {
            String search = "";
            for (Cell cell : path) {
                search += String.valueOf(cell.value);
            }
            if (search.equals(word)) {
                return true;
            }
        }

        return false;
    }

    // 백트래킹
    // 종료 조건 : 글자수 충족 여부
    // 조합에 추가하기
    // 재귀 :
    // 기존 셀 기준 오로지 인접 셀만 선택가능한 조합으로 제한하기
    // 원복
    private void backtracking(List<Cell> path) {
        assert path != null;

        if (path.size() == word.length()) {
            list.add(new ArrayList<>(path));
            return;
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
                backtracking(path);
                path.remove(path.size() - 1);
                visited[i][j] = false;
            }
        }
    }

    public record Cell(
            int n,
            int m,
            char value
    ) {}
} 