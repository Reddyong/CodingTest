package programmers.Lv2.시소짝꿍;

import java.util.*;

class Solution {
    private long answer;
    private Map<Double, Integer> map;
    private int[] distance = new int[]{2, 3, 4};
    public long solution(int[] weights) {
        init(weights);
        solve(weights);

        return answer;
    }

    private void solve(int[] weights){
        for(int weight : weights){
            double n1 = weight * 1.0;
            double n2 = weight * (2.0 / 3.0);
            double n3 = weight * (2.0 / 4.0);
            double n4 = weight * (3.0 / 4.0);

            if(map.containsKey(n1)){
                answer += map.get(n1);
            }

            if(map.containsKey(n2)){
                answer += map.get(n2);
            }

            if(map.containsKey(n3)){
                answer += map.get(n3);
            }

            if(map.containsKey(n4)){
                answer += map.get(n4);
            }

            map.put((double) weight, map.getOrDefault((double) weight, 0) + 1);
        }
    }

    private void init(int[] weights){
        answer = 0;
        map = new HashMap<>();
        Arrays.sort(weights);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long solution = sol.solution(new int[]{100, 180, 360, 100, 270});

        System.out.println("solution = " + solution);
    }
}
