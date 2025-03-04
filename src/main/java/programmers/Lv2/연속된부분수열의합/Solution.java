package programmers.Lv2.연속된부분수열의합;

import java.util.*;

class Solution {
    private int len;
    private int start;
    private int end;
    private int sum;
    private int[] answer;
    public int[] solution(int[] sequence, int k) {
        init();
        solve(sequence, k);

        return answer;
    }

    private void solve(int[] sequence, int k){
        for(int i = 0, j = 0; i < sequence.length; i++){
            while(sum < k && j < sequence.length){
                sum += sequence[j];
                j++;
            }

            if(sum == k){
                if((j - i) < len){
                    len = j - i;
                    start = i;
                    end = j - 1;
                }
            }

            sum -= sequence[i];
        }

        answer[0] = start;
        answer[1] = end;
    }

    private void init(){
        answer = new int[2];
        len = Integer.MAX_VALUE;
        start = 0;
        end = 0;
        sum = 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(new int[]{1, 2, 3, 4, 5}, 7);
        int[] solution2 = sol.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        int[] solution3 = sol.solution(new int[]{2, 2, 2, 2, 2}, 6);

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));

    }
}
