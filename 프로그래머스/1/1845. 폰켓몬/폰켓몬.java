import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new));
        int n = nums.length;
        
        return Math.min(set.size(), n / 2);
    }
}