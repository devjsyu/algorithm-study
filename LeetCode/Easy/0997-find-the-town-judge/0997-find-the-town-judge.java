/**
directed graph
BFS
everyone else outward one
one outward nobody
특정 노드에 도착한 노드의 개수: 0
특정 노드로부터 출발하는 노드의 개수: 전체 개수 - 1
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        this.trustGraph = new ArrayList[n + 1];
        this.beingTrustedGraph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            trustGraph[i] = new ArrayList<>();
            beingTrustedGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < trust.length; i++) {
            addEdge(trust[i][0], trust[i][1]);
        }

        for (int i = 1; i <= n; i++) {
            if (trustGraph[i].size() == 0 && beingTrustedGraph[i].size() == n - 1) {
                return i;
            } 
        }

        return -1;
    }

    private List<Integer>[] trustGraph;
    private List<Integer>[] beingTrustedGraph;

    private void addEdge(int source, int destination) {
        trustGraph[source].add(destination);
        beingTrustedGraph[destination].add(source);
    }
}