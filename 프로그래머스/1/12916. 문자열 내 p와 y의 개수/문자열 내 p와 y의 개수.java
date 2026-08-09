class Solution {
    boolean solution(String s) {
        String lowercased = s.toLowerCase();
        
        int countP = 0;
        int countY = 0;
        
        for (int i = 0; i < lowercased.length(); i++) {
            char character = lowercased.charAt(i);
            switch (character) {
                case 'p':
                    countP++;
                    break;
                case 'y':
                    countY++;
                    break;
            }
        }
        
        boolean answer = countP == countY ? true : false;

        return answer;
    }
}