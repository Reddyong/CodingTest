package programmers.Lv2.문자열압축;

import java.util.*;

class Solution {
    private int answer, N;
    public int solution(String s) {
        solve(s);

        return answer;
    }

    private void solve(String s){
        answer = Integer.MAX_VALUE;
        N = s.length();

        // 문자열의 길이가 1인경우
        if(N == 1){
            answer = 1;
            return;
        }

        // 절반 지점까지 돌면서 길이를 자르기
        for(int k = 1; k <= (N / 2); k++){
            StringBuilder sb = new StringBuilder();

            String prev = s.substring(0, k);
            int last = k;
            int count = 1;

            for(int i = k; i < N; i += k){
                // 현재 비교할 문자열 자르기
                String cur = s.substring(i, Math.min(i + k, N));

                // 앞의 문자열과 동일하다면 count 증가
                if(cur.equals(prev)){
                    count++;
                } else{
                    // 문자열 압축하기
                    if(count == 1){
                        sb.append(prev);
                    } else{
                        sb.append(count).append(prev);
                    }

                    // count 초기화
                    count = 1;
                    prev = cur;
                }
            }

            // 문자열 뒤 남은 부분 붙이기
            if(count == 1){
                sb.append(prev);
            } else{
                sb.append(count).append(prev);
            }

            answer = Math.min(answer, sb.toString().length());
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution("aabbaccc");
        int solution2 = sol.solution("ababcdcdababcdcd");
        int solution3 = sol.solution("abcabcdede");
        int solution4 = sol.solution("abcabcabcabcdededededede");
        int solution5 = sol.solution("xababcdcdababcdcd");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution4 = " + solution4);
        System.out.println("solution5 = " + solution5);
    }
}
