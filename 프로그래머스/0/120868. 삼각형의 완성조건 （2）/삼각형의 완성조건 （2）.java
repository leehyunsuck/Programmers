class Solution {
    public int solution(int[] sides) {
        return Math.min(sides[0], sides[1]) + sides[0] + sides[1] - Math.max(sides[0], sides[1]) - 1;
    }
}

/*
가장 긴 변의 길이 = 다른 두 변의 길이의 합보다 작아야함

[3 , 6]

6을 가장 긴 변이라 할 때:
 
 다른 변의 길이를 x 라 할 때
 6 - 3 < x <= 6    4 5 6

다른 변이 가장 길다 할 때:
 6 < x < 6 + 3
 
-------

        // 11 - 7 = 4
        // 4보다 크고 11보다 작거나 같은 수
        // 11 - 4 = 7
        
                // int a = sides[0];
        // int b = sides[1];
        // int maxAB = Math.max(a, b);
        // int minAB = Math.min(a, b);
        
        //maxAB - (maxAB - minAB) + (a + b) - maxAB - 1;
        // minAB + a + b - maxAB - 1
*/