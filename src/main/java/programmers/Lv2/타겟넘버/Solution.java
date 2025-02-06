package programmers.Lv2.타겟넘버;

import java.util.*;

class Solution {
    private int[] dx = new int[]{1, -1};
    private int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);

        return answer;
    }

    private void dfs(int sum, int depth, int[] numbers, int target){
        if(depth == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }

        for(int i = 0; i < 2; i++){
            int nx = numbers[depth] * dx[i];
            dfs(sum + nx, depth + 1, numbers, target);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{1, 1, 1, 1, 1}, 3);
        int solution2 = sol.solution(new int[]{4, 1, 2, 1}, 4);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
