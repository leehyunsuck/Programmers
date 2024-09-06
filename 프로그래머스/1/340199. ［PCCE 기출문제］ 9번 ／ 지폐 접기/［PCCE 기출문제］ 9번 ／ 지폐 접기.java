class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        if (wallet[0] > wallet[1]) wallet = new int[] { wallet[1], wallet[0] };
        if (bill[0] > bill[1]) bill = new int[] { bill[1], bill[0] };
        
        while (bill[0] > wallet[0] || bill[1] > wallet[1]) {
            if (bill[0] > bill[1]) bill[0] /= 2;
            else bill[1] /= 2;
            if (bill[0] > bill[1]) bill = new int[] { bill[1], bill[0] };
            answer++;
        }
        
        return answer;
    }
}