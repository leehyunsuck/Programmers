class Solution {
    public int solution(int num) {
        long numToLong = (long) num;
        int answer = 0;
        
        for (; numToLong != 1 && answer < 500; answer++) {
            if (numToLong % 2 == 0) numToLong /= 2;
            else numToLong = numToLong * 3l + 1l;
        }
        
        return answer < 500 ? answer : -1;
    }
}