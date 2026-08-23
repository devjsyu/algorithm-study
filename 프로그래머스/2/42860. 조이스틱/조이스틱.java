class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;

        for (int i = 0; i < len; i++) {
            // 상하 이동 최소 계산 : 알파벳 변경에 필요한 최소값
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1); // ASCII 차감된 값 비교

            // 연속된 A 구간 찾기
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 좌우 이동 최소 횟수 갱신
            // 오른쪽으로 i까지 갔다가 유턴해서 뒤부터 방문
            int route1 = (i * 2) + (len - next);

            // 왼쪽으로 먼저 갔다가 유턴해서 i까지 방문
            int route2 = (len - next) * 2 + i;
            
            move = Math.min(move, Math.min(route1, route2));
        }
        
        return answer + move;
    }
}