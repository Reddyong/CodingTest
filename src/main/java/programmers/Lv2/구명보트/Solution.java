package programmers.Lv2.구명보트;

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {

        return solve(people, limit);
    }

    private int solve(int[] people, int limit){
        Arrays.sort(people);
        int idx = 0;
        int ans = 0;

        for(int i = people.length - 1; i >= idx; i--){

            int cur = people[i];
            int min = people[idx];

            if(cur + min > limit){
                ans++;
                continue;
            }

            ans++;
            idx++;
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{70, 50, 80, 50}, 100);
        int solution2 = sol.solution(new int[]{70, 80, 50}, 100);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
