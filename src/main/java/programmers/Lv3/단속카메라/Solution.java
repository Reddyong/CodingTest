package programmers.Lv3.단속카메라;

import java.util.*;

class Solution {
    private int answer;
    public int solution(int[][] routes) {
        solve(routes);

        return answer;
    }

    private void solve(int[][] routes){
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        answer = 1;

        int cur = routes[0][1];
        for(int i = 0; i < routes.length; i++){
            if(routes[i][0] <= cur){
                continue;
            }

            answer++;
            cur = routes[i][1];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}});

        System.out.println("solution = " + solution);
    }
}