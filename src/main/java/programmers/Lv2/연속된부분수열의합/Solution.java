package programmers.Lv2.연속된부분수열의합;

import java.util.Arrays;

class Solution {
    private int left, right, sum, min;
    private int[] answer;
    public int[] solution(int[] sequence, int k) {
        // 초기화
        init(sequence);
        // 풀이 과정
        solve(sequence, k);

        return answer;
    }

    private void solve(int[] sequence, int k){
        // 투 포인터 알고리즘
        for(int i = 0, j = 0; i < sequence.length; i++){
            // 현재 범위의 합이 k이상이 될때까지 j 증가
            while(sum < k && j < sequence.length){
                sum += sequence[j];
                j++;
            }

            // k와 sum이 동일하고, 길이가 가장 짧은 경우
            if(sum == k && min > (j - i)){
                left = i;
                right = j - 1;
                min = j - i;
            }

            sum -= sequence[i];
        }

        answer[0] = left;
        answer[1] = right;
    }

    private void init(int[] sequence){
        answer = new int[2];
        left = 0;
        right = 0;
        sum = 0;
        min = Integer.MAX_VALUE;
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