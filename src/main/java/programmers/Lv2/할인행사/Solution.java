package programmers.Lv2.할인행사;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<String, Integer> wantMap;
    private Map<String, Integer> tempMap;
    private int answer;
    public int solution(String[] want, int[] number, String[] discount) {
        init(want, number);
        solve(want, discount);

        return answer;
    }

    private void solve(String[] want, String[] discount){
        for(int i = 0; i < discount.length - 10 + 1; i++){
            tempMap = new HashMap<>();
            for(int j = i; j < i + 10; j++){
                tempMap.put(discount[j % discount.length], tempMap.getOrDefault(discount[j % discount.length], 0) + 1);
            }

            checkAnswer(want);
        }
    }

    private void checkAnswer(String[] want){
        for(int i = 0; i < want.length; i++){
            if(!tempMap.containsKey(want[i])){
                return;
            }

            if(!tempMap.get(want[i]).equals(wantMap.get(want[i]))){
                return;
            }
        }

        answer++;
    }

    private void init(String[] want, int[] number){
        wantMap = new HashMap<>();
        answer = 0;

        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
        int solution2 = sol.solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
