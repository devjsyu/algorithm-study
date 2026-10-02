import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char prevChar = words[0].charAt(0);
        int num = -1;
        int count = -1;
        
        for (int i = 0; i < words.length; i++) {
            // 탈락 케이스 1 : 앞 단어와 중복
            // 탈락 케이스 2 : 앞 단어의 마지막 문자와 불일치
            if (!set.add(words[i]) || prevChar != words[i].charAt(0)) {
                // 가장 먼저 탈락하는 사람의 번호
                num = i % n + 1;
                
                // 탈락자의 탈락 당시 총 시도 횟수
                count = i / n + 1;
                
                return new int[]{num, count};
            } 
            
            prevChar = words[i].charAt(words[i].length() - 1);
        }
        
        
        return new int[]{0, 0};
    }
}