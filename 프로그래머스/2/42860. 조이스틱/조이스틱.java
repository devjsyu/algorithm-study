class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1; // 기본 좌우 이동 횟수 (순서대로 오른쪽 이동)

        for (int i = 0; i < len; i++) {
            // 1. 알파벳 변경 상/하 최소 횟수 계산
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 2. 연속된 'A' 구간 찾기
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 3. 좌우 이동 최소 횟수 갱신
            // (1) 0 -> i -> 0 -> next (순방향 후 역방향)
            // (2) 0 -> next -> 0 -> i (역방향 후 순방향)
            int route1 = i * 2 + (len - next);
            int route2 = (len - next) * 2 + i;
            
            move = Math.min(move, Math.min(route1, route2));
        }

        return answer + move;
    }
}