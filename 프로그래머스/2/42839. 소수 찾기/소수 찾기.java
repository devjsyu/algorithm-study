import java.util.*;

class Solution {
    public int solution(String numbers) {
        // 주어진 문자열로부터 도출할 수 있는 모든 조합 구하기
        Set<Integer> possibleCombinations = new HashSet<>();
        String currentPath = "";
        boolean[] used = new boolean[numbers.length()];
        backtracking(possibleCombinations, numbers, used, currentPath);

        // 각 조합이 소수인지 여부 집계하기
        int count = 0;
        for (Integer combination : possibleCombinations) {
            if (isPrime(combination)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private void backtracking(Set<Integer> possibleCombinations, String numbers, boolean[] used, String currentPath) {
        if (!currentPath.isEmpty()) {
            int combination = Integer.parseInt(currentPath);
            possibleCombinations.add(combination);
            
            // bounding function
            if (currentPath.length() == numbers.length()) {
                return;
            }
        }

        // building the tree
        for (int i = 0; i < numbers.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                backtracking(possibleCombinations, numbers, used, currentPath + numbers.charAt(i)); // using the recursion
                used[i] = false;                
            }
        }
    }
}