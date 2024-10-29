class Solution {
    public int solution(long num) {
        return this.collatzLoop(num, 0);
    }
    
    public int collatzLoop(long num, int loop) {
        if (num == 1 || loop == 500) 
            return loop == 500 ? -1 : loop;
        
        return this.collatzLoop(num % 2l == 0l ? num / 2l : num * 3l + 1l, loop + 1);
    }
}