package programmers.Lv2.이모티콘할인행사;

import java.util.*;

class Solution {
    private int[] answer, temp;
    private int[] discount = new int[]{10, 20, 30, 40};
    public int[] solution(int[][] users, int[] emoticons) {
        // 초기화
        init(emoticons);
        // dfs 백트래킹을 통해 완전탐색 진행
        dfs(0, users, emoticons);

        return answer;
    }

    private void dfs(int depth, int[][] users, int[] emoticons){
        if(depth == emoticons.length){
            // 정답 업데이트
            updateResult(users, emoticons);
            return;
        }

        for(int i = 0; i < 4; i++){
            temp[depth] = discount[i];
            dfs(depth + 1, users, emoticons);
        }
    }

    private void updateResult(int[][] users, int[] emoticons){
        int count = 0;
        int sum = 0;

        // 사용자 별로 현재 적용된 할인율 계산 후 이모티콘 플러스 가입 여부 체크
        for(int[] user : users){
            int tempSum = 0;
            for(int i = 0; i < emoticons.length; i++){
                // user의 할인 기준이 현재 할인율보다 높은경우 패스
                if(user[0] > temp[i]){
                    continue;
                }

                int cur = emoticons[i] * (100 - temp[i]) / 100;
                tempSum += cur;
            }

            if(tempSum >= user[1]){
                count++;
            } else{
                sum += tempSum;
            }
        }

        // 기존 정답 값과 비교하여 더 최적인 값 정댑에 대입
        if(answer[0] < count){
            answer[0] = count;
            answer[1] = sum;
        }

        if(answer[0] == count){
            answer[1] = Math.max(answer[1], sum);
        }
    }

    private void init(int[] emoticons){
        answer = new int[2];
        temp = new int[emoticons.length];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000});
        int[] solution2 = sol.solution(new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}, new int[]{1300, 1500, 1600, 4900});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }
}