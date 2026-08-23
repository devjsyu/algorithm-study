class Solution {
    public int[] solution(int brown, int yellow) {

        int total = brown + yellow;
        int w = 0;
        int h = 3;
        while (true) {
            if (total % h == 0) {
                w = total / h;
            }
            if ((w - 2) * (h - 2) == yellow) {
                break;
            }

            h++;
        }

        int[] answer = {w, h};
        return answer;
    }
}