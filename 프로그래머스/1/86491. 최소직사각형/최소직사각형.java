class Solution {
    public int solution(int[][] sizes) {
        int width = Integer.MIN_VALUE,
            length = width;
        
        for (int[] size : sizes) {
            int longerIdx = size[0] > size[1] ? 0 : 1;
            width = width > size[longerIdx] ? width : size[longerIdx];
            length = length > size[1 - longerIdx] ? length : size[1 - longerIdx];
        }
        
        return width * length;
    }
}