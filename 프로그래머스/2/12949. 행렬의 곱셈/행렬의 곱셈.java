class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowA = arr1.length,
            rowBcolA = arr2.length,
            colB = arr2[0].length;
        
        int[][] answer = new int[rowA][colB];
        
        for (int i = 0; i < rowA; i++)
            for (int j = 0; j < colB; j++)
                for (int k = 0; k < rowBcolA; k++)
                    answer[i][j] += arr1[i][k] * arr2[k][j];
        
        return answer;
    }
}