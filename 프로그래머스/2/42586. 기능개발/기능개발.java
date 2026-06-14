import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // Two Pointers : 현재 그룹의 가장 앞선 요소와 현재 검사하는 요소
        int left = 0;
        int right = left + 1;

        int[] daysLeftForCompletion = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            // 완성 소요 일수 계산
            daysLeftForCompletion[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }

        List<Integer> list = new ArrayList<>();
        int count = 1;

        while (right < progresses.length) {
            // 가장 앞선 요소의 소요 일수보다 큰 경우가 나올 때까지 배포 개수 누적
            if (daysLeftForCompletion[left] >= daysLeftForCompletion[right]) {
                count++;
                right++;
            } else {
                left = right;
                right++;
                list.add(count);
                count = 1;
            }
        }

        list.add(count); // 마지막 그룹까지 집계
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}