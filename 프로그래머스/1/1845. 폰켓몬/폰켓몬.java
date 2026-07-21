import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        // 포켓몬 종류 개수, N / 2 중 최소값이 선택 가능한 포켓몬 종류 개수의 최대값

        // 종류별 집계를 위한 자료구조 초기화
        Set<Integer> species = new HashSet<>();
        int maxSelectableCount = nums.length / 2;

        // nums 배열 순회를 통해 종류별 집계
        for (int speciesNum : nums) {
            species.add(speciesNum);
            
            // 포켓몬 종류 개수가 N / 2까지 집계되면 조기 반환 
            if (species.size() == maxSelectableCount) {
                return maxSelectableCount;
            }
        }

        return species.size();
    }
}