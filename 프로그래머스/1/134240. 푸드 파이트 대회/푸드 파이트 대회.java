class Solution {
    public String solution(int[] food) {
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 1; i < food.length; i++) strBuilder.append(String.valueOf(i).repeat(food[i] / 2));
    
        return strBuilder.toString() + 0 + strBuilder.reverse().toString();
    }
}