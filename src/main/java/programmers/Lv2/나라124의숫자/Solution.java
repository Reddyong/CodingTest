package programmers.Lv2.나라124의숫자;

import java.util.*;

class Solution {
    private List<Integer> list;
    private String answer;
    public String solution(int n) {
        solve(n);

        return answer;
    }

    private void solve(int n){
        list = new ArrayList<>();

        while(n > 0){
            int mod = n % 3;
            n /= 3;

            if(mod == 0){
                mod = 4;
                n--;
            }

            list.add(mod);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i));
        }

        answer = sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution1 = sol.solution(1);
        String solution2 = sol.solution(2);
        String solution3 = sol.solution(3);
        String solution4 = sol.solution(4);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution4 = " + solution4);
    }
}
