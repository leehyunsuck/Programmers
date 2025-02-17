class Solution {
    /**
     * @Param n     박스 개수
     * @Param w     가로에 박스를 놓을 수 있는 개수
     * @Param num   찾는 숫자
     *
     * @Return      찾는 숫자는 위에서 몇번째 박스에 있는지
     */
    public int solution(int n, int w, int num) {
        int result = 0;
        
        boolean right = true;
        for (int value = 1, location = 0, targetLocation = -1; value <= n; value++) {
            if (num == value)
                targetLocation = location;
            
            if (targetLocation != -1 && targetLocation == location)
                result++;
            
            location += right ? 1 : -1;
            if (location == w) {
                location = w - 1;
                right = false;
            }
            if (location == -1) {
                location = 0;
                right = true;
            }
        }

        return result;
    }
}