package programmers.Lv2.H_index;

import java.util.*;

class Solution {
    private int answer;
    public int solution(int[] citations) {

        init(citations);
        solve(citations);

        return answer;
    }

    private void solve(int[] citations){
        for(int i = 0; i < citations.length; i++){
            int h = citations.length - i;

            if(citations[i] >= h){
                answer = h;
                return;
            }
        }
    }

    private void init(int[] citations){
        answer = 0;
        Arrays.sort(citations);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{3, 0, 6, 1, 5});

        System.out.println("solution = " + solution);
    }
}