class Solution {
    public String solution(int a, int b) {
        String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
        int day = 4 + b;
        for (int i = 1; i < a; i++) {
            int add = switch(i) {
                    case 1, 3, 5, 7, 8, 10, 12 -> { yield 31; }
                    case 2 -> { yield 29; }
                    default -> { yield 30; }
            };
            day += add;
        }
        
        return days[day % days.length];
    }
}

//윤년 2월29일