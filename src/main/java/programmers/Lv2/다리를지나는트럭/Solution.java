package programmers.Lv2.다리를지나는트럭;

import java.util.*;

class Solution {
    private Queue<Integer> before;
    private Queue<Integer> on;
    private int sum;
    private int time;
    private int answer;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        init(truck_weights);
        solve(bridge_length, weight);

        return answer;
    }

    private void solve(int bridge_length, int weight){
        while(!before.isEmpty()){
            if(on.size() == bridge_length){
                sum -= on.poll();
            }

            if(on.size() < bridge_length){
                if((sum + before.peek()) > weight){
                    on.add(0);
                } else{
                    int poll = before.poll();
                    on.add(poll);
                    sum += poll;
                }
            }

            time++;
        }

        answer = time + bridge_length;
    }

    private void init(int[] truck_weights){
        before = new LinkedList<>();
        on = new LinkedList<>();
        sum = 0;
        time = 0;
        answer = 0;

        for(int truck_weight : truck_weights){
            before.add(truck_weight);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(2, 10, new int[]{7, 4, 5, 6});
        int solution2 = sol.solution(100, 100, new int[]{10});
        int solution3 = sol.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
