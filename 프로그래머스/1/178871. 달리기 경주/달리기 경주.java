import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        //name : rank
        Map<String, Integer> ranking = new HashMap<>();
        
        //rank : name
        Map<Integer, String> ranking2 = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
            ranking2.put(i, players[i]);
        }
        
        
        for (String calling : callings) {
            //calling이 불렸으니 추월
            
            //불린 사람 현재 등수
            int rank = ranking.get(calling);
            
            //추월 당할 사람
            String name = ranking2.get(rank - 1);
            
            ranking.put(calling, rank - 1);
            ranking.put(name, rank);
            
            ranking2.put(rank - 1, calling);
            ranking2.put(rank, name);
        }
        
        String[] answer = new String[players.length];
        
        for (int i = 0; i < players.length; i++) {
            answer[i] = ranking2.get(i);
        }
        
        return answer;
    }
}

// 부르면 추월했다는 거임
// return = 순위