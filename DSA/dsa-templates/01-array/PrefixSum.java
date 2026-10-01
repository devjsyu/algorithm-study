import java.util.*;

/**
 * Definition:
 * prefix[i] = arr[0] ~ arr[i - 1]의 합
 *
 * Build:
 * prefix[i + 1] = prefix[i] + arr[i]
 *
 * Range Query:
 * sum(left, right)
 * = prefix[right + 1] - prefix[left]
 *
 * Complexity:
 * Build: O(N)
 * Query: O(1)
 * Space: O(N)
 *
 * Common mistakes:
 * - prefix와 arr의 인덱스를 혼동
 * - right + 1을 빼먹음
 * - int overflow
 */
public class PrefixSum {
    /**
     * prefix[i] = arr[0] ~ arr[i - 1]의 합
     *
     * arr: [a, b, c, d]
     * index: 0, 1, 2, 3
     *
     * prefix: [0, a, a + b, a + b + c, a + b + c +d]
     * index: 0, 1, 2, 3, 4
     */
    static long[] buildPrefixSum(int[] arr) {
        int n = arr.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        return prefix;
    }

    /**
     * arr[left ... right]의 합
     * left, right는 0-indexed이며 양 끝을 포함한다.
     *
     * sum(left, right)
     * = prefix[right + 1] - prefix[left]
     */
    static long rangeSum(long[] prefix, int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}