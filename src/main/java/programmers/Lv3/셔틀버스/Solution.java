package programmers.Lv3.셔틀버스;

import java.util.*;

class Solution {
    private int N;
    private String answer;
    private int[] minutes;
    private PriorityQueue<Integer> pq;
    public String solution(int n, int t, int m, String[] timetable) {
        // 초기화
        init(timetable);
        // 풀이과정
        solve(n, t, m);

        return answer;
    }

    private void solve(int n, int t, int m){
        int start = 0;
        int end = 1439;

        // 도착 시각이 가능한지 이분탐색으로 탐색
        while(start <= end){
            int mid = (start + end) / 2;

            // 해당 도착 시간이 가능한지 판단
            if(isPossibleTime(mid, n, m, t)){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }

        changeToString(end);
    }

    private boolean isPossibleTime(int time, int n, int m, int t){
        pq = new PriorityQueue<>();

        // 크루 도착 시각들 우선순위 큐에 담기
        saveCrewTimes();
        // 콘 도착 시각 우선순위 큐에 추가
        pq.add(time);

        // 우선순위 큐 돌면서 판단하기
        int cur = 540;
        int count = 0;
        int max = 0;

        // 우선순위 큐에 아직 태울 손님이 남았거나, 사용가능한 셔틀의 수를 넘지 않은 경우
        while(!pq.isEmpty() && max < n){
            // 다음 값이 현재 셔틀 도착시간보다 빠르거나 같은 경우
            if(pq.peek() <= cur){
                // 셔틀이 꽉찬 경우 다음 셔틀로 보냄
                if(count == m){
                    count = 0;
                    cur += t;
                    max++;
                    continue;
                }
                // 셔틀이 꽉차지 않은 경우 크루 태움
                pq.poll();
                count++;
                continue;
            }

            // 현재 크루가 셔틀의 도착시간보다 늦은 경우 다음 셔틀로 이동
            count = 0;
            cur += t;
            max++;
        }

        // 모든 크루를 다 태웠거나, 콘을 태운 경우
        if(pq.isEmpty() || pq.peek() > time){
            return true;
        }

        return false;
    }

    private void saveCrewTimes(){
        for(int minute : minutes){
            pq.add(minute);
        }
    }

    private void init(String[] timetable){
        N = timetable.length;
        answer = "";
        minutes = new int[N];

        // 시간을 분으로 바꿔서 새로운 배열에 초기화
        for(int i = 0; i < N; i++){
            minutes[i] = changeToMinute(timetable[i]);
        }
    }

    private void changeToString(int time){
        int hour = time / 60;
        int minute = time % 60;

        if(hour < 10){
            answer += "0";
        }
        answer += String.valueOf(hour);
        answer += ":";

        if(minute < 10){
            answer += "0";
        }

        answer += minute;
    }

    private int changeToMinute(String time){
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution1 = sol.solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"});
        String solution2 = sol.solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"});
        String solution3 = sol.solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"});
        String solution4 = sol.solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"});
        String solution5 = sol.solution(1, 1, 1, new String[]{"23:59"});
        String solution6 = sol.solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution4 = " + solution4);
        System.out.println("solution5 = " + solution5);
        System.out.println("solution6 = " + solution6);
    }
}
