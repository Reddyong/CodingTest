package programmers.Lv2.의상;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int answer;
    private Map<String, Integer> map;
    public int solution(String[][] clothes) {
        init(clothes);
        solve();

        return answer;
    }

    private void solve(){
        for(int num : map.values()){
            answer *= (num + 1);
        }

        answer--;
    }

    private void init(String[][] clothes){
        answer = 1;
        map = new HashMap<>();

        for(String[] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
        int solution2 = sol.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
