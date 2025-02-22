package programmers.Lv3.최고의집합;

import java.util.*;

class Solution {
    private int share;
    private int remainder;
    private int[] answer;
    public int[] solution(int n, int s) {
        init(n, s);
        solve(n, s);

        return answer;
    }

    private void solve(int n, int s){
        if(s < n){
            answer = new int[]{-1};
            return;
        }

        for(int i = 0; i < n; i++){
            answer[i] = share;
        }

        int idx = 0;
        while(remainder > 0){
            answer[idx++] += 1;
            remainder--;
        }

        Arrays.sort(answer);
    }

    private void init(int n, int s){
        share = s / n;
        remainder = s % n;

        answer = new int[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(2, 9);
        int[] solution2 = sol.solution(2, 1);
        int[] solution3 = sol.solution(2, 8);

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));
    }
}