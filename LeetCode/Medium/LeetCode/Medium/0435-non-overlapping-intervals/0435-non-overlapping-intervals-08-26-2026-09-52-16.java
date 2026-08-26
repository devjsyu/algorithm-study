import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // end 기준 오름차순 정렬
        Arrays.sort(intervals, (i1, i2) -> {
            return i1[1] - i2[1];    
        });

        System.out.println(Arrays.deepToString(intervals));

        int count = 1;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
                count++;
            } 
        }

        return intervals.length - count;
    }
}