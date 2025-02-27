package programmers.Lv2.가장큰수;

import java.util.*;

class Solution {
    private String answer;
    private String[] arr;
    public String solution(int[] numbers) {
        solve(numbers);

        return answer;
    }

    private void solve(int[] numbers){
        arr = new String[numbers.length];
        answer = "";

        for(int i = 0; i < numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if(arr[0].equals("0")){
            answer = "0";
            return;
        }

        for(String number : arr){
            answer += number;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution1 = sol.solution(new int[]{6, 10, 2});
        String solution2 = sol.solution(new int[]{3, 30, 34, 5, 9});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}