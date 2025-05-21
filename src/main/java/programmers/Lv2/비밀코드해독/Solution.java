package programmers.Lv2.비밀코드해독;

import java.util.*;

class Solution {
    private int answer;
    private int[] temp;
    public int solution(int n, int[][] q, int[] ans) {
        // 초기화
        init();
        // 풀이 과정
        solve(n, q, ans);

        return answer;
    }

    private void solve(int n, int[][] q, int[] ans){
        // 백트래킹으로 모든 수 조합 확인하기
        dfs(0, 0, n, q, ans);
    }

    private void dfs(int start, int depth, int n, int[][] q, int[] ans){
        if(depth == 5){
            // 조합한 수들에 대해 가능한 비밀 코드인지 확인
            if(isPossibleCode(q, ans)){
                answer++;
            }
            return;
        }

        for(int i = start; i < n; i++){
            temp[depth] = i + 1;
            dfs(i + 1, depth + 1, n, q, ans);
        }
    }

    private boolean isPossibleCode(int[][] q, int[] ans){
        for(int i = 0; i < q.length; i++){
            int count = 0;

            for(int j = 0; j < 5; j++){
                int cur = temp[j];

                for(int k = 0; k < 5; k++){
                    if(q[i][k] == cur){
                        count++;
                        break;
                    }
                }

                if(count > ans[i]){
                    return false;
                }
            }

            if(count < ans[i]){
                return false;
            }
        }

        return true;
    }

    private void init(){
        answer = 0;
        temp = new int[5];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(10, new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}}, new int[]{2, 3, 4, 3, 3});
        int solution2 = sol.solution(15, new int[][]{{2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15}, {1, 4, 10, 11, 14}}, new int[]{2, 1, 3, 0, 1});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
