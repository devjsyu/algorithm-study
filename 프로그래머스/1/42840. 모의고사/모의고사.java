import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        // 1번 수포자 패턴: 12345
        // 2번 수포자 패턴: 21232425
        // 3번 수포자 패턴: 3311224455

        // 수포자 패턴을 배열에 담아 초기화
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        List<int[]> temp = new ArrayList<>();

        // 정답 배열 순회하면서 찍기가 맞는 경우 집계
        int count = 0;
        int max = 0;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < answers.length; i++) {
                int length = pattern[j].length;
                if (answers[i] == pattern[j][i % length]) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
            }
            temp.add(new int[]{j + 1, count});
            count = 0;
        }

        // 가장 많이 맞춘 사람 반환하되, 동점자라면 오름차순 정렬
        int finalMax = max;
        return temp.stream().filter(j -> j[1] == finalMax).map(j -> j[0]).mapToInt(Integer::intValue).sorted().toArray();
    }
}