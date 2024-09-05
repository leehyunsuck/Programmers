import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        List<Integer>   lostList = new ArrayList<>(),
                        reserveList = new ArrayList<>();
        
        for (int l : lost) lostList.add(l);

        // 여벌 갖고있는애도 도난시 자기꺼 써야함
        for (int r : reserve) {
            if (lostList.contains(r)) lostList.remove(Integer.valueOf(r));
            else reserveList.add(r);
        }
        
        for (int r : reserveList) {
            if (lostList.contains(r - 1)) lostList.remove(Integer.valueOf(r - 1));
            else if (lostList.contains(r + 1)) lostList.remove(Integer.valueOf(r + 1));
        }

        return n - lostList.size();
    }
}