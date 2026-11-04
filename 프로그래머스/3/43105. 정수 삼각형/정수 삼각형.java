class Solution {
    public int solution(int[][] triangle) {
        int length = triangle.length;
        
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                triangle[i][j] = Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]) + triangle[i][j];
            }            
        }
        
        return triangle[0][0];
    }
}