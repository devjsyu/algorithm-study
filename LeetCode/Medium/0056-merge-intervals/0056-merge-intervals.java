class Solution {
    public int[][] merge(int[][] intervals) {
        // intervals[0] 기준 오름차순 정렬
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        // 정답 담을 리스트 초기화
        List<Interval> list = new ArrayList<>();

        // 변수 초기화
        int min = -1;
        int max = -1;

        for (int i = 0; i < intervals.length; i++) {
            // 1. 겹치지 않는 상황
            // 최초로 입력하는 경우
            if (min == -1 && max == -1) {
                min = intervals[i][0];
                max = intervals[i][1];
            } else if (intervals[i][0] > max) {
                // 기존 max보다 현재 원소의 start가 클 경우
                // 기존 원소를 정답 리스트에 추가
                list.add(new Interval(min, max));
                // 변수 초기화
                min = intervals[i][0];
                max = intervals[i][1];
            } else if (intervals[i][1] <= max) {
                // 2. 겹치는 상황
                // 현재 원소의 end보다 기존 max가 클 경우
                continue;
            } else if (intervals[i][0] <= max) {
                // 현재 원소의 start보다 기존 max가 클 경우
                max = intervals[i][1];
            } 
        }

        if (min != -1 && max != -1) {
            // 기존 원소를 정답 리스트에 추가
            list.add(new Interval(min, max));
        }

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            Interval interval = list.get(i);
            answer[i][0] = interval.start;
            answer[i][1] = interval.end;
        }

        return answer;
    }

    public record Interval(int start, int end) {}
}