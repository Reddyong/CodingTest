package programmers.Lv3.디스크컨트롤러;

import java.util.*;

class Solution {
    private int N, sum, cur, answer;
    private PriorityQueue<Work> pq;
    private Queue<Work> q;
    public int solution(int[][] jobs) {
        init(jobs);
        solve();

        return answer;
    }

    private void solve(){
        // 모든 작업이 대기 큐에 들어갔어도, 모든 작업이 마칠때까지 반복
        while(!q.isEmpty() || !pq.isEmpty()){
            // 현재 시간보다 빠른 작업들은 모두 대기 큐에 넣기
            while(!q.isEmpty() && q.peek().request <= cur){
                pq.add(q.poll());
            }

            // 대기 큐가 비어있는 경우는 현재 시간을 다음 작업의 요청시간으로 넘기기
            if(pq.isEmpty()){
                cur = q.peek().request;
                continue;
            }

            // 대기 큐에서 하나의 작업씩 꺼내가면서 합계와 현재 시간 업데이트
            Work poll = pq.poll();
            sum += (cur + poll.time - poll.request);
            cur += poll.time;
        }

        answer = sum / N;
    }

    private void init(int[][] jobs){
        N = jobs.length;
        sum = 0;
        answer = 0;
        cur = 0;
        q = new LinkedList<>();
        // 시작전, 작업들을 요청 시간 순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 큐에서 작업을 요청 시간 순으로 꺼내보기 위해 넣기
        for(int i = 0; i < N; i++){
            q.add(new Work(i, jobs[i][0], jobs[i][1]));
        }

        // time 짧은 순, request 작은 순, num 작은 순
        pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.time == o2.time){
                return o1.request - o2.request;
            }

            if(o1.time == o2.time && o1.request == o2.request){
                return o1.num - o2.num;
            }

            return o1.time - o2.time;
        });
    }

    private class Work{
        int num;
        int request;
        int time;

        public Work(int num, int request, int time){
            this.num = num;
            this.request = request;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[][]{{0, 3}, {1, 9}, {3, 5}});

        System.out.println("solution = " + solution);
    }
}