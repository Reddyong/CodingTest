package programmers.Lv2.k진수에서소수개수구하기;

import java.util.*;

class Solution {
    private List<Integer> list;
    private int answer;
    public int solution(int n, int k) {
        changeNum(n, k);
        solve();

        return answer;
    }

    private void solve(){
        String str = "";
        for(int i = list.size() - 1; i >= 0; i--){
            if(list.get(i) != 0){
                str += String.valueOf(list.get(i));
                continue;
            }

            if(!str.equals("") && isPrimeNum(str)){
                answer++;
            }

            str = "";
        }

        if(!str.equals("") && isPrimeNum(str)){
            answer++;
        }
    }
    private boolean isPrimeNum(String num){
        long number = Long.parseLong(num);

        if(number == 1){
            return false;
        }

        for(int i = 2; i <= (long) Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }

        return true;
    }

    private void changeNum(int n, int k){
        list = new ArrayList<>();
        answer = 0;

        while(n > 0){
            int mod = n % k;
            list.add(mod);
            n /= k;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(437674, 3);
        int solution2 = sol.solution(110011, 10);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}