import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int[][] sorted = Arrays.stream(data)
                .sorted((o1, o2) -> {
                    int colVariable1 = o1[col - 1];
                    int colVariable2 = o2[col - 1];
                    if (colVariable1 == colVariable2) {
                        int pk1 = o1[0];
                        int pk2 = o2[0];
                        return pk2 - pk1; // PK 내림차순 정렬
                    } else {
                        return colVariable1 - colVariable2; // 지정된 col 값 오름차순 정렬
                    }
                }).toArray(int[][]::new);

        List<Integer> list = new ArrayList<>();

        for (int i = row_begin; i <= row_end; i++) {
            int temp = 0;
            for (int value : sorted[i - 1]) {
                temp += value % i;
            }
            list.add(temp);
        }
        
        int answer = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            answer = answer ^ list.get(i);
        }
        
        return answer;
    }
}