package programmers.Lv2.요격시스템;

import java.util.*;

class Solution {
    private int answer = 0;
    public int solution(int[][] targets) {
        // 풀이 과정
        solve(targets);

        return answer;
    }

    private void solve(int[][] targets){
        // 정렬하기
        // 끝나는 지점 오름차순 -> 시작지점 내림차순
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o2[0] - o1[0];
            }

            return o1[1] - o2[1];
        });

        // targets 돌면서 요격 진행
        // 각 요격의 처음 미사일의 끝 부분 보다 시작지점이 뒷 부분인 미사일이 나오기 전까진
        // 하나의 요격으로 맞출 수 있음
        int end = targets[0][1];
        for(int i = 0; i < targets.length; i++){
            // 현재 요격
            if(targets[i][0] < end){
                continue;
            }

            // 다음 요격으로 넘어감
            end = targets[i][1];
            answer++;
        }

        // 마지막 요격
        answer++;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}});

        System.out.println("solution = " + solution);
    }
}

// 그리디 알고리즘 기본 문제
// 각 단계에서 최적의 방법으로 진행하도록 하는 것