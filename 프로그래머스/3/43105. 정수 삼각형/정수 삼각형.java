class Solution {
    public int solution(int[][] triangle) {
        
        for (int row = triangle.length - 2; row >= 0; row--) {
            for (int col = 0; col < triangle[row].length; col++) {
                triangle[row][col] += Math.max(triangle[row+1][col], triangle[row+1][col+1]);
            }
        }
        
        return triangle[0][0];
    }
}

/*

7 
3   8
8   1   0
2   7   4   4
4   5   2   6   5



*/