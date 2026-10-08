/**
문제해결 순서
1. 뒤에서부터 순회하면서 StringBuilder에 추가하기
2. '-'는 무시하고 넘어가기
3. k만큼 읽으면 StringBuilder에 '-' 추가하기
4. 순회 이후 StringBuilder의 reverse 메서드 사용하여 뒤집고 대문자로 변환 후 문자열로 반환하기
 */
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int scanned = 0;
        for (int i = s.length() - 1; i >= 0; i--) {         
            char c = s.charAt(i);
            
            if (c == '-') continue;

            if (scanned > 0 && scanned % k == 0) {
                sb.append('-');
            } 

            sb.append(Character.toUpperCase(c));
            scanned++;
        }

        return sb.reverse().toString();
    }
}