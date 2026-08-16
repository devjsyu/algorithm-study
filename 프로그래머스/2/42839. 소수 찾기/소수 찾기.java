import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private boolean[] isPrime;
    private Set<Integer> possibleCombinations = new HashSet<>();
    private List<String> possibleChoices = new ArrayList<>();
    private int maxLength = -1;
    private boolean[] used;

    public int solution(String numbers) {
        // 주어진 문자열로부터 도출할 수 있는 최대 숫자 구하기
        String[] arr = numbers.split("");
        System.out.println("unsorted : " + Arrays.toString(arr));
        Arrays.sort(arr, (a, b) -> b.compareTo(a));
        System.out.println("sorted : " + Arrays.toString(arr));
        int max = Integer.parseInt(String.join("", arr));
        System.out.println("The possible max number is " + max + "\n------------------");
        
        // [에라토스테네스의 체]를 통해 주어진 범위(0 ~ 최대 숫자) 내의 모든 소수 구하기
        this.isPrime = new boolean[max + 1];
        Arrays.fill(this.isPrime, true);
        this.isPrime = sieveOfEratothenes(this.isPrime, max);

        // 주어진 문자열로부터 도출할 수 있는 모든 조합 구하기
        for (String num : arr) {
            this.possibleChoices.add(num);
        }
        this.maxLength = numbers.length();
        List<String> state = new ArrayList<>();
        this.used = new boolean[possibleChoices.size()];
        backtracking(state);

        // 각 조합이 소수인지 여부 집계하기
        System.out.println("----------------------\n이제 소수인지 여부를 확인해보겠습니다!\n---------------------------");
        int count = 0;
        int sizeOfSet = possibleCombinations.size();
        System.out.println("현재 Set에는 몇 개? : " + sizeOfSet);
        for (Integer combination : possibleCombinations) {
            System.out.println(combination + "은 소수일까요?");

            if (isPrime[combination]) {
                System.out.println(combination + "은 소수입니다!");
                count++;
            }
        }

        return count;
    }

    private boolean[] sieveOfEratothenes(boolean[] isPrime, int max) {
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= max; p++) {
            for (int i = p * p; i <= max; i += p) {
                isPrime[i] = false;
            }
        }

        return isPrime;
    }

    private void backtracking(List<String> state) {
        if (state != null && !state.isEmpty()) {
            String combinationString = String.join("", new ArrayList<>(state));
            int combination = Integer.parseInt(combinationString);
            possibleCombinations.add(combination);
            
            // bounding function
            if (state.size() == maxLength) {
                return;
            }
        }

        // building the tree
        for (int i = 0; i < possibleChoices.size(); i++) {
            if (used[i]) {
                continue;
            }

            state.add(possibleChoices.get(i)); // making the branch
            used[i] = true;
            backtracking(state); // using the recursion
            state.remove(state.size() - 1); // going back by popping
            used[i] = false;
        }
    }
}