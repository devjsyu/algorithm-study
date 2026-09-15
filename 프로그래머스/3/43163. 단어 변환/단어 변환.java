/**
Backtracking
조건을 만족하는 경우의 수 중 최소값 구하기

배열 순회하면서 target이 애초부터 없다면 즉시 조기 반환하기

boolean isValid(String input, String word)
배열 순회하면서 isValid 메서드 적용하여 갈 수 있는 정점인지 판별

각 경우의 수에 대해 단계 진행될 때마다 count 변수 누적 집계하기
모든 경우의 수 중 최솟값 반환하기
*/
import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 조기 반환
        boolean found = false;
        for (String word : words) {
            if (Objects.equals(word, target)) { // safe against NPE
                found = true;
                break;
            }
        }
        if (!found) return 0;
        
        // instance field initialization
        this.target = target;
        this.words = words;
        this.visited = new boolean[words.length];
        
        backtracking(begin, 0);
        
        return minCount;
    }
    
    private String target;
    private String[] words;
    private boolean[] visited;
    private int minCount = Integer.MAX_VALUE;
    
    private boolean isValid(String input, String word) {
        int count = 0;
        int length = input.length();
        
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == word.charAt(i)) count++;
        }
        
        return count == length - 1; // 한 글자 빼고 모두 동일한가?
    }
    
    private void backtracking(String current, int count) {
        // 종료 조건
        if (current.equals(target)) {
            minCount = Math.min(count, minCount);
            return;
        } 
        
        // 무한 재귀 호출 방어 로직
        boolean isAllVisited = true;
        for (boolean isVisited : visited) {
            if (!isVisited) {
                isAllVisited = false;
                break;                
            }
        }
        if (isAllVisited) return;
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isValid(current, words[i])) {
                visited[i] = true;
                backtracking(words[i], count + 1);                
                visited[i] = false;
            }
        }
    }
}