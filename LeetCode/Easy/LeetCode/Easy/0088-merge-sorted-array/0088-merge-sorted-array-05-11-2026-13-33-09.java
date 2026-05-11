import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 엣지 케이스 조기 종료
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        ArrayDeque<Integer> queue1 = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            queue1.add(nums1[i]);
        }
        
        ArrayDeque<Integer> queue2 = new ArrayDeque<>();
        Collections.addAll(queue2, Arrays.stream(nums2).boxed().toArray(Integer[]::new));

        ArrayList<Integer> list = new ArrayList<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue1.isEmpty()) {
                list.add(queue2.poll());
            } else if (queue2.isEmpty()) {
                list.add(queue1.poll());
            } else {
                if (queue1.peekFirst() < queue2.peekFirst()) {
                    list.add(queue1.poll());
                } else {
                    list.add(queue2.poll());
                }
            }
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = list.get(i);
        }
    }
}