import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int getPokemonCount = nums.length / 2;
        
        int other = 0;
        Map<Integer, Integer> pokemonMap = new HashMap<>();
        for (int num : nums) {
            if (!pokemonMap.containsKey(num)) {
                other++;
                pokemonMap.put(num, 1);
            }
        }
        
        return other > getPokemonCount ? getPokemonCount : other;
    }
}