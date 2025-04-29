package programmers.Lv1.유연근무제;

class Solution {
    private int answer;
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        // 풀이과정
        solve(schedules, timelogs, startday);

        return answer;
    }

    private void solve(int[] schedules, int[][] timelogs, int startday){
        answer = 0;

        for(int i = 0; i < schedules.length; i++){
            // 출근 희망 시간 분단위로 변경
            int hopeTime = changeToMinute(schedules[i]);
            int dayNum = startday;
            boolean flag = true;
            for(int j = 0; j < timelogs[i].length; j++){
                // 일요일에서 월요일 넘어가는 경우
                if(dayNum == 8){
                    dayNum = 1;
                }

                // 주말은 출근 희망시간 상관 없음
                if(dayNum == 6 || dayNum == 7){
                    dayNum++;
                    continue;
                }
                // 출근한 시간 분단위로 변경
                int realTime = changeToMinute(timelogs[i][j]);

                // 늦게 출근한 경우
                if(realTime > hopeTime + 10){
                    flag = false;
                    break;
                }

                dayNum++;
            }

            // 평일에 정상적으로 모두 출근
            if(flag){
                answer++;
            }
        }
    }

    private int changeToMinute(int time){
        int hour = time / 100;
        int minute = time % 100;

        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{700, 800, 1100}, new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}}, 5);
        int solution2 = sol.solution(new int[]{730, 855, 700, 720}, new int[][]{{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}}, 1);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
