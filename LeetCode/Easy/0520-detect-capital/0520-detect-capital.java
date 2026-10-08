/**
case 1: 1, 2 모두 대문자        -> 나머지 모두 대문자
case 2: 1만 대문자              -> 나머지 모두 소문자
case 3: 모두 대문자 아님         -> 나머지 모두 소문자
case 4: 나머지                  -> 즉시 false 반환
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        // early exit
        if (word.length() < 2) return true;

        // case 1
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            // 나머지 모두 대문자
            for (int i = 2; i < word.length(); i++) {
                if (!Character.isUpperCase(word.charAt(i))) return false;
            }
        // case 2 & case 3
        } else if (Character.isLowerCase(word.charAt(1))) {
            // 나머지 모두 소문자
            for (int i = 2; i < word.length(); i++) {
                if (!Character.isLowerCase(word.charAt(i))) return false;
            }
        } else {
            return false;
        }

        return true;
    }
}