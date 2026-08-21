import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // g, s 배열 오름차순 정렬하기
        Arrays.sort(g);
        Arrays.sort(s);

        // Two Pointer 사용하여 O(N) 시간복잡도로 순회하기
        int contentChildren = 0;
        int cookieIndex = 0;
        while (cookieIndex < s.length && contentChildren < g.length) {
            if (s[cookieIndex] >= g[contentChildren]) {
                contentChildren++;
            }
            cookieIndex++;
        }

        return contentChildren;
    }
}