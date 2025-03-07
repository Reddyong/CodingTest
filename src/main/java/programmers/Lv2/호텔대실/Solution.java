package programmers.Lv2.호텔대실;

import java.util.*;

class Solution {
    private int answer;
    private boolean[] visited;
    private int[][] time;
    public int solution(String[][] book_time) {
        init(book_time);
        solve();

        return answer;
    }

    private void solve(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] t : time){
            if(!pq.isEmpty()){
                if(pq.peek() <= t[0]){
                    pq.poll();
                }
            }

            pq.add(t[1]);
        }

        answer = pq.size();
    }

    private void dfs(int end){
        for(int i = 0; i < time.length; i++){
            if(!visited[i] && time[i][0] >= end){
                visited[i] = true;
                dfs(time[i][1]);
            }
        }
    }

    private void init(String[][] book_time){
        answer = 0;
        visited = new boolean[book_time.length];
        time = new int[book_time.length][2];

        for(int i = 0; i < book_time.length; i++){
            String start = book_time[i][0];
            String end = book_time[i][1];

            String[] startSplit = start.split(":");
            String[] endSplit = end.split(":");

            int startTime = Integer.parseInt(startSplit[0]) * 60 + Integer.parseInt(startSplit[1]);
            int endTime = Integer.parseInt(endSplit[0]) * 60 + Integer.parseInt(endSplit[1]) + 10;
            if(endTime >= 1440){
                endTime = 1439;
            }

            time[i][0] = startTime;
            time[i][1] = endTime;
        }

        Arrays.sort(time, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}});
        int solution2 = sol.solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}});
        int solution3 = sol.solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
