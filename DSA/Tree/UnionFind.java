public class UnionFind {
    private int[] parent;

    // 초기화 : 처음에는 모두가 자기 자신을 1인 팀의 팀장으로 가진다
    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    // 내가 속한 그룹의 최고 팀장, 루트를 찾기
    public int find(int x) {
        // 내가 최고 팀장이라면 내 번호를 반환
        if (parent[x] == x) return x;

        // 경로 압축 : 팀장을 찾으러 올라가는 길에, 거쳐가는 모든 노드의 부모를 최고 팀장으로 바꿔버리기
        // 다음 번 탐색에 단 번에 팀장을 찾을 수 있음
        return parent[x] = find(parent[x]);
    }

    // 두 팀을 하나로 합치기
    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }
}