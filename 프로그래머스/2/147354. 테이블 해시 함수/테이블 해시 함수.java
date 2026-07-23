import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
                    if (o1[col - 1] == o2[col - 1]) {
                        return Integer.compare(o2[0], o1[0]); // PK 내림차순 정렬
                    }
                    return Integer.compare(o1[col - 1], o2[col - 1]); // 지정된 col 값 오름차순 정렬
                });

        int answer = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int temp = 0;
            for (int value : data[i - 1]) {
                temp += value % i;
            }
            answer ^= temp;
        }

        return answer;
    }
}