package programmers.Lv3.야근지수;

import java.util.*;

class Solution {
    private PriorityQueue<Integer> pq;
    private long answer;
    public long solution(int n, int[] works) {
        init(works);
        solve(n);

        return answer;
    }

    private void solve(int n){
        while(n > 0){
            if(pq.isEmpty() || pq.peek() == 0){
                answer = 0;
                return;
            }
            int poll = pq.poll();
            pq.add(poll - 1);

            n--;
        }

        while(!pq.isEmpty()){
            int poll = pq.poll();
            answer += (poll * poll);
        }
    }

    private void init(int[] works){
        pq = new PriorityQueue<>(Collections.reverseOrder());
        answer = 0;

        for(int work : works){
            pq.add(work);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long solution1 = sol.solution(4, new int[]{4, 3, 3});
        long solution2 = sol.solution(1, new int[]{2, 1, 2});
        long solution3 = sol.solution(3, new int[]{1, 1});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
