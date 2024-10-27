class Solution {
    public String solution(String[] seoul) {
        String base = "김서방은 x에 있다";
        
        for (int i = 0; i < seoul.length; i++)
            if (seoul[i].equals("Kim"))
                return base.replace("x", String.valueOf(i));
        
        return "누구슈? 김서방은 없슈~";
    }
}