package programmers.Lv3.인사고과;

import java.util.*;

class Solution {
    private int[] wanho;
    private int answer;
    public int solution(int[][] scores) {
        // 풀이 과정
        solve(scores);

        return answer;
    }

    private void solve(int[][] scores){
        // 완호 점수 저장
        wanho = new int[2];
        wanho[0] = scores[0][0];
        wanho[1] = scores[0][1];
        int max = 0;

        // 정렬
        // 근무 태도 점수 내림차순, 동료 평가 점수 오름차순으로 정렬
        // 3,2 3,2 2,1 2,2 1,4
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }

            return o2[0] - o1[0];
        });

        for(int[] score : scores){
            if(score[1] > max){
                max = score[1];
            }

            if(score[1] < max){
                if(score[0] == wanho[0] && score[1] == wanho[1]){
                    answer = -1;
                    return;
                }
                continue;
            }

            if(score[0] + score[1] > wanho[0] + wanho[1]){
                answer++;
            }
        }

        answer++;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}});

        System.out.println("solution = " + solution);
    }
}
