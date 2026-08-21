import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // g, s 배열 오름차순 정렬하기
        Arrays.sort(g);
        Arrays.sort(s);

        // 오름차순으로 정렬된 모든 쿠키 순회하기
        int j = 0;
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (j >= g.length) break;
            
            // 만족하는 경우
            if (s[i] >= g[j]) {
                j++;
                count++;
            } 
        }

        return count;
    }
}