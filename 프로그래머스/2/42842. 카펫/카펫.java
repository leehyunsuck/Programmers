class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;                       // 전체 개수

        for (int height = 3; height < sum; height++) {
            if (sum % height != 0) continue;            // 사각형 아님
            
            int width = sum / height;                   
            if (width < height) continue;               // 가로가 더 짧음
            
            int brownCount = (width + height - 2) * 2;
            if (brownCount != brown) continue;          // 개수가 안맞음
            
            return new int[] {width, height};
        }
 
        return new int[0];
    }
}