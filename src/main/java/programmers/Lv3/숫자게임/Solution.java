package programmers.Lv3.숫자게임;

import java.util.*;

class Solution {
    private boolean[] visited;
    private int answer;
    public int solution(int[] A, int[] B) {
        init(A, B);
        solve(A, B);

        return answer;
    }

    private void solve(int[] A, int[] B){
        int aIdx = 0;
        int bIdx = 0;

        while(bIdx < B.length){
            if(A[aIdx] < B[bIdx]){
                aIdx++;
                answer++;
            }

            bIdx++;
        }
    }

    private void init(int[] A, int[] B){
        answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8});
        int solution2 = sol.solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}