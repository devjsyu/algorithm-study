import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        // 초기 좌표
        int[] coordinate = {0, 0};

        // 루트 저장할 자료구조 초기화
        // 중복 제거를 위해 HashSet 사용
        HashSet<String> routes = new HashSet<>();
        
        // 명령어
        HashMap<Character, int[]> command = new HashMap<>();
        command.put('U', new int[]{0, 1});
        command.put('D', new int[]{0, -1});
        command.put('R', new int[]{1, 0});
        command.put('L', new int[]{-1, 0});
        
        // 순회
        for (char c : dirs.toCharArray()) {
            int[] coordinateMove = command.get(c);
            int tempX = coordinate[0] + coordinateMove[0];
            int tempY = coordinate[1] + coordinateMove[1];

            // 지정 범위 벗어나면 필터링
            if (tempX < -5 || tempY < -5 || tempX > 5 || tempY > 5) {
                continue;
            }
            
            // 방향 구분 없이 일괄 저장
            routes.add(coordinate[0] + ", " + coordinate[1] + " - " + tempX + ", " + tempY);
            routes.add(tempX + ", " + tempY + " - " +  coordinate[0] + ", " + coordinate[1]);

            // 좌표 갱신
            coordinate[0] = tempX;
            coordinate[1] = tempY;
        }
        
        // 최종 집계
        int answer = routes.size() / 2;

        return answer;
    }
}