import java.util.ArrayList;
import java.util.List;

class Solution {
    private String candidates = "AEIOU";
    private List<String> combinations = new ArrayList<>();
    
    public int solution(String word) {
        String currentPath = "";
        backtracking(currentPath);
        
        return combinations.indexOf(word) + 1;
    }

    private void backtracking(String currentPath) {
        if (!currentPath.isEmpty()) {
            combinations.add(currentPath);
            if (currentPath.length() == 5) {
                return;
            }
        }
        
        for (int i = 0; i < 5; i++) {
            String temp = currentPath;
            currentPath = currentPath + candidates.charAt(i);
            backtracking(currentPath);
            currentPath = temp;
        }
    }
}