package programmers.Lv3.징검다리건너기;

import java.util.*;

class Solution {
    private int s, m, e, answer;
    public int solution(int[] stones, int k) {
        solve(stones, k);

        return answer;
    }

    private void solve(int[] stones, int k){
        s = 1;
        e = findMax(stones);

        while(s <= e){
            m = (s + e) / 2;

            if(isPossible(stones, k, m)){
                s = m + 1;
                answer = m;
            } else{
                e = m - 1;
            }
        }
    }

    private boolean isPossible(int[] stones, int k, int mid){
        int count = 0;
        for(int stone : stones){
            if(stone < m){
                count++;

                if(count >= k){
                    return false;
                }
            } else{
                count = 0;
            }
        }

        return true;
    }

    private int findMax(int[] stones){
        int max = 0;
        for(int stone : stones){
            max = Math.max(stone, max);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);

        System.out.println("solution = " + solution);
    }
}
