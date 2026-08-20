class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length();

        for (int i = 0; i < len; i++) {
            char current = number.charAt(i);

            // 스택의 top이 현재 문자보다 작고 k가 남아있다면 제거
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) < current && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(current);
        }

        // k가 남아있는 경우 뒤에서 남은 k만큼 제거 (예: "7777", k=2 -> "77")
        return sb.substring(0, sb.length() - k);
    }
}