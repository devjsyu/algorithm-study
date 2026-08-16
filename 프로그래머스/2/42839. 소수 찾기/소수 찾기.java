import java.util.*;

class Solution {
    public int solution(String numbers) {
        // 주어진 문자열로부터 도출할 수 있는 모든 조합 구하기
        Set<Integer> possibleCombinations = new HashSet<>();
        String[] possibleChoices = numbers.split("");
        String currentPath = "";
        boolean[] used = new boolean[possibleChoices.length];
        backtracking(possibleCombinations, possibleChoices, used, currentPath);

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

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private void backtracking(Set<Integer> possibleCombinations, String[] possibleChoices, boolean[] used, String currentPath) {
        if (currentPath != null && !currentPath.isEmpty()) {
            int combination = Integer.parseInt(currentPath);
            possibleCombinations.add(combination);
            
            // bounding function
            if (currentPath.length() == possibleChoices.length) {
                return;
            }
        }

        // building the tree
        for (int i = 0; i < possibleChoices.length; i++) {
            if (!used[i]) {
                used[i] = true;
                backtracking(possibleCombinations, possibleChoices, used, currentPath + possibleChoices[i]); // using the recursion
                used[i] = false;                
            }
        }
    }
}