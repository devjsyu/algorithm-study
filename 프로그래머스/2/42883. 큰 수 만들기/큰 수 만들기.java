/**
점점 커지는 양상이라면? 일단 k가 허락하는 한, 계속 없애기, 다음 것이 더 작다면 없애기 중단하기
점점 줄어드는 양상이라면? 그러다가 새로 더 큰 게 나왔다면? k가 허락하는 한, 계속 없애기
확정되었다면, 다음 것부터 다시 시작하기

// Monotonic Stack
// 초기화
// top과 새로 들어온 값 비교하기
    // 새로 들어온 값이 더 크다?
        // while
            // k가 허락하는 한 없애기
            // stack.pop
        // stack.push
    // 새로 들어온 값이 더 작다?
        // stack.push
*/
class Solution {
    public String solution(String number, int k) {
        // 바로 정답으로 반환할 수 있도록 StringBuilder를 Stack처럼 사용하기
        StringBuilder sb = new StringBuilder();
        sb.append(number.charAt(0));
        
        // number 문자열 순회하는 과정 중 제거한 숫자가 k가 될 때 중단
        int removed = 0;
        for (int i = 1; i < number.length(); i++) {
            char current = number.charAt(i);
            char top = sb.charAt(sb.length() - 1);
            
            if (top < current) {
                while (removed < k && top < current) {
                    removed++;
                    sb.deleteCharAt(sb.length() - 1);
                    
                    if (sb.length() == 0) break;
                    top = sb.charAt(sb.length() - 1);
                }
                sb.append(current);
            } else {
                sb.append(current);
            }            
        }
        
        // 제거한 수가 아직 k에 못 미칠 경우
        int rest = k - removed;
        int length = sb.length();
        sb = sb.delete(length - rest, length);
        
        String answer = sb.toString();
        return answer;
    }
}