/**
DFS
조건을 만족하는 경로 중 알파벳 순서가 가장 앞서는 경로를 반환하기
커스텀 정렬과 PriorityQueue 이용하기
*/
import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.paths = new ArrayList<>();
        
        // 주어진 항공권 순회하면서 ICN 출발인 경우 각각 backtracking 실시
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                boolean[] visited = new boolean[tickets.length];
                List<String> path = new ArrayList<>();
                path.add("ICN");
                path.add(tickets[i][1]);
                visited[i] = true;

                backtracking(path, visited);
            }
        }
        
        PriorityQueue<Path> minHeap = new PriorityQueue<>((v1, v2) -> v1.pathString().compareTo(v2.pathString()));
        for (int i = 0; i < paths.size(); i++) {
            StringBuilder sb = new StringBuilder();
            List<String> path = paths.get(i);
            for (int j = 0; j < path.size(); j++) {
                sb.append(path.get(j));                
            }
            String pathString = sb.toString();
            minHeap.offer(new Path(pathString, i));                        
        }
        
        return paths.get(minHeap.poll().index()).toArray(String[]::new);
    }
    
    private String[][] tickets;
    private List<List<String>> paths;
    
    private void backtracking(List<String> path, boolean[] visited) {
        if (path.size() == tickets.length + 1) {
            paths.add(new ArrayList<>(path));            
            return;
        }
        
        String current = path.get(path.size() - 1);
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && current.equals(tickets[i][0])) {
                path.add(tickets[i][1]);
                visited[i] = true;
                backtracking(path, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }            
        }
    }
    
    public record Path(String pathString, int index) {}
}