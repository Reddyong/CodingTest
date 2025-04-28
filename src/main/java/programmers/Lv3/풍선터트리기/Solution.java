package programmers.Lv3.풍선터트리기;

import java.util.*;

class Solution {
    private int answer;
    private int[] left, right;
    public int solution(int[] a) {
        solve(a);

        return answer;
    }

    private void solve(int[] a){
        // left 배열 채우기
        fillLeft(a);

        // right 배열 채우기
        fillRight(a);

        // 정답 구하기
        answer = 0;
        getResult(a);
    }

    private void getResult(int[] a){
        for(int i = 0; i < a.length; i++){
            if(left[i] < a[i] && right[i] < a[i]){
                continue;
            }

            answer++;
        }
    }

    private void fillLeft(int[] a){
        left = new int[a.length];
        left[0] = Integer.MAX_VALUE;
        for(int i = 1; i < a.length; i++){
            left[i] = Math.min(left[i - 1], a[i - 1]);
        }
    }

    private void fillRight(int[] a){
        right = new int[a.length];
        right[a.length - 1] = Integer.MAX_VALUE;
        for(int i = a.length - 2; i >= 0; i--){
            right[i] = Math.min(right[i + 1], a[i + 1]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{9, -1, -5});
        int solution2 = sol.solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
