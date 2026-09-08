import java.util.*;

public class BinarySearch {
    // ==========================================
    // 1. Classical Binary Search (전형적인 이분 탐색)
    // ==========================================
    /**
     * 정확히 일치하는 target의 인덱스를 찾음 (중복이 없을 때 주로 사용)
     * 찾으면 인덱스 반환, 없으면 -1 반환
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1; // 닫힌 구간 [left, right]

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // 즉시 반환
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // 미발견
    }

    // ==========================================
    // 2. Bound Pattern (경계 탐색)
    // ==========================================
    /**
     * Lower Bound: target 이상(>=)인 첫 번째 인덱스
     */
    public static int loswerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length; // 반열린 구간 [left, right)

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * Upper Bound: target 초과(>)인 첫 번째 인덱스
     */
    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 특정 원소의 개수 (O(log N))
     */
    public static int countFrequency(int[] arr, int target) {
        return upperBound(arr, target) - lowerBound(arr, target);
    }

    // ==========================================
    // 3. Parametric Search (매개변수 탐색)
    // ==========================================
    /**
     * 조건을 만족하는 "최댓값" 찾기 (예: 랜선 자르기, 나무 자르기)
     * 패턴: [O, O, O, O, X, X] 중 마지막 O의 위치
     *
     * @param minVal 가능한 최소 길이/값
     * @param maxVal 가능한 최대 길이/값
     * @param target 목표 조건 수치
     */
    public static long parametricSearchMax(long minVal, long maxVal, long target, int[] items) {
        long left = minVal;
        long right = maxVal;
        long result = 0; // 조건을 만족한 최적해 보관용

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (check(mid, target, items)) {
                result = mid; // 조건을 만족하므로 일단 정답 후보로 저장
                left = mid + 1; // 더 큰 값(오른쪽)도 가능한지 탐색
            } else {
                right = mid - 1; // 조건을 불만족하므로 더 작은 값(왼쪽)으로 탐색
            }
        }

        return result;
    }

    /**
     * 조건을 만족하는 "최솟값" 찾기 (예: 공유기 설치, 입국심사)
     * 패턴: [X, X, O, O, O, O] 중 첫 번째 O의 위치
     */
    public static long parametricSearchMin(long minVal, long maxVal, long target, int[] items) {
        long left = minVal;
        long right = maxVal;
        long result = maxVal;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (check(mid, target, items)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    // 매개변수 탐색의 결정 함수 (문제 조건에 맞게 오버라이딩/구현)
    private static boolean check(long mid, long target, int[] items) {
        return true;
    }
}