package programmers.Lv2.n2배열자르기;

import java.util.Arrays;

public class Solution {
    private int[] answer;
    public int[] solution(int n, long left, long right) {
        init(n, left, right);
        solve(n, left, right);

        return answer;
    }

    private void solve(int n, long left, long right){
        int idx = 0;

        for(long i = left; i <= right; i++){
            int mok = (int) (i / n);
            int na = (int) (i % n);

            answer[idx] = Math.max(mok + 1, na + 1);
            idx++;
        }
    }

    private void init(int n, long left, long right){
        int len = (int) (right - left) + 1;
        answer = new int[len];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(3, 2, 5);
        int[] solution2 = sol.solution(4, 7, 14);

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }
}
