package programmers.Lv2.최솟값만들기;

import java.util.Arrays;

public class Solution {
    public int solution(int []A, int []B)
    {
        init(A, B);

        return solve(A, B);
    }

    private void init(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
    }

    private int solve(int[] A, int[] B){
        int ans = 0;

        for(int i = 0; i < A.length; i++){
            ans += A[i] * B[B.length - 1 - i];
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
        int solution2 = sol.solution(new int[]{1, 2}, new int[]{3, 4});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
