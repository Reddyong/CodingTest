package programmers.Lv2.숫자카드나누기;

import java.util.*;

class Solution {
    private int gcd1;
    private int gcd2;
    private int answer;
    public int solution(int[] arrayA, int[] arrayB) {
        solve(arrayA, arrayB);

        return answer;
    }

    private void solve(int[] arrayA, int[] arrayB){
        gcd1 = getGCD(arrayA);
        gcd2 = getGCD(arrayB);

        for(int i = 0; i < arrayA.length; i++){
            if(arrayA[i] % gcd2 == 0){
                gcd2 = 0;
                break;
            }
        }

        for(int i = 0; i < arrayB.length; i++){
            if(arrayB[i] % gcd1 == 0){
                gcd1 = 0;
                break;
            }
        }

        answer = Math.max(gcd1, gcd2);
    }

    private int getGCD(int[] array){
        Arrays.sort(array);
        int cur = array[0];

        for(int i = 1; i < array.length; i++){
            cur = gcd(cur, array[i]);
        }

        return cur;
    }

    private int gcd(int n1, int n2){
        if(n2 == 0){
            return n1;
        }

        return gcd(n2, n1 % n2);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{10, 17}, new int[]{5, 20});
        int solution2 = sol.solution(new int[]{10, 20}, new int[]{5, 17});
        int solution3 = sol.solution(new int[]{14, 35, 119}, new int[]{18, 30, 102});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
