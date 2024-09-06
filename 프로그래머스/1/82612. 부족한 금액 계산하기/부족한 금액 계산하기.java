class Solution {
    public long solution(int price, int money, int count) {
        long allPrice = 0;
        for (int i = 1; i <= count; i++) allPrice += price * i;
        return allPrice - money > 0 ? allPrice - money : 0;
    }
}