package programmers.Lv2.연속부분수열합의개수;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Set<Integer> set;
    private int[] temp;
    public int solution(int[] elements) {

        init(elements);

        return solve(elements);
    }

    private void init(int[] elements){
        set = new HashSet<>();
        temp = new int[2 * elements.length];

        for(int i = 0; i < temp.length; i++){
            temp[i] = elements[i % elements.length];
        }
    }

    private int solve(int[] elements){
        int length = 1;

        while(length <= elements.length){
            for(int i = 0; i < elements.length; i++){
                int sum = 0;
                for(int j = i; j < i + length; j++){
                    sum += temp[j];
                }

                set.add(sum);
            }

            length++;
        }

        return set.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{7, 9, 1, 1, 4});

        System.out.println("solution = " + solution);
    }
}
