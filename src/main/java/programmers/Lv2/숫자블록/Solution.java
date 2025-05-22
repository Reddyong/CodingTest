package programmers.Lv2.숫자블록;

import java.util.Arrays;

class Solution {
    private int[] answer;
    public int[] solution(long begin, long end) {
        // 풀이 과정
        solve(begin, end);

        return answer;
    }

    private void solve(long begin, long end){
        int N = (int) (end - begin + 1);
        answer = new int[N];

        int idx = 0;
        for(int i = (int) begin; i <= (int) end; i++){
            answer[idx] = getMaxBlockNumber(i);
            idx++;
        }
    }

    private int getMaxBlockNumber(int num){
        if(num == 1){
            return 0;
        }

        int max = 1;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                int temp = num / i;

                if(temp <= 10000000){
                    return temp;
                }

                if(i <= 10000000){
                    max = Math.max(max, i);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(1, 10);

        System.out.println("solution = " + Arrays.toString(solution));
    }
}
