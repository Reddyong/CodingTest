package programmers.Lv2.줄서는방법;

import java.util.*;

class Solution {
    private int[] answer;
    private List<Integer> list;
    private List<Integer> answerList;
    public int[] solution(int n, long k) {
        init(n);
        solve(n, k);

        return answer;
    }

    private void solve(int n, long k){
        while(n > 1){
            long fact = getFactorial(n - 1);
            int share = (int) (k / fact);
            long mod = k % fact;

            if(mod == 0){
                share--;
                mod += fact;
            }

            answerList.add(list.get( share));
            list.remove(share);
            n--;
            k = mod;
        }

        answerList.add(list.get(0));

        answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }
    }

    private long getFactorial(int n){
        long num = 1;

        for(int i = 1; i <= n; i++){
            num *= i;
        }

        return num;
    }

    private void init(int n){
        list = new ArrayList<>();
        answerList = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            list.add(i);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(3, 5);

        System.out.println("solution = " + Arrays.toString(solution));
    }
}
