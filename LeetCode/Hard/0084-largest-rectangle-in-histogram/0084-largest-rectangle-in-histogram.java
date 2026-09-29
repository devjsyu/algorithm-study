/**
- heights 배열 순회하면서 maxArea 값 갱신하여 반환하기
- area 값을 어떻게 계산할 것인가?
    - 아직 area 계산 안 된 원소를 일단 stack에 몰아넣기
    - 새 원소에 대해 조건 만족 여부 검사를 while 반복문으로 반복하기
        - 오른쪽에서 처음으로 더 작은 원소인가?
        - height 확정: top
        - width 확정:
            - stack이 비어있다면 i 그 자체
            - 그렇지 않다면, i - (pop 이후) stack.top - 1
        - monotonic stack이기 때문에 stack에 있는 건 일단 monotonous increasing 보장
        - 최댓값 갱신
    - 새 원소 역시 stack에 넣기

- Brute-force O(N^2)를 Monotonic Stack을 통해 O(N)으로 바꾸기
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();

        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int current = (i == heights.length) ? 0 : heights[i]; // 무조건 오른쪽 경계값 만들 수 있도록 임의의 높이 0 bar 생성
            
            while (!stack.isEmpty() && heights[stack.peek()] >= current) {
                int height = heights[stack.pop()]; // monotonous increasing stack이기 때문에 매번 pop 할 때마다 높이 병목임을 보장
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;

                maxArea = Math.max(maxArea, area); // 최댓값 갱신
            }
            
            stack.push(i);
        }

        return maxArea;
    }
}