package programmers.Lv2.두큐합같게만들기;

import java.util.*;

class Solution {
    private int answer;
    private long sum1;
    private long sum2;
    private int len;
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    public int solution(int[] queue1, int[] queue2) {
        init(queue1, queue2);
        solve();

        return answer;
    }

    private void solve(){
        while(true){
            if(answer > len * 2){
                answer = -1;
                return;
            }

            if(sum1 > sum2){
                int poll = q1.poll();
                q2.add(poll);

                sum1 -= poll;
                sum2 += poll;
                answer++;
            } else if(sum1 < sum2){
                int poll = q2.poll();
                q1.add(poll);

                sum2 -= poll;
                sum1 += poll;
                answer++;
            } else{
                return;
            }
        }
    }

    private void init(int[] queue1, int[] queue2){
        answer = 0;
        sum1 = 0;
        sum2 = 0;
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);

            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        len = queue1.length + queue2.length;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
        int solution2 = sol.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
        int solution3 = sol.solution(new int[]{1, 1}, new int[]{1, 5});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
