package programmers.Lv2.귤고르기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> map;
    public int solution(int k, int[] tangerine) {

        init(tangerine);

        return solve(k, tangerine);
    }

    private void init(int[] tangerine){
        map = new HashMap<>();

        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
    }

    private int solve(int k, int[] tangerine){
        int minus = tangerine.length - k;
        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> map.get(o1) - map.get(o2));

        for(int l : list){
            while(map.get(l) != 0 && minus > 0){
                map.put(l, map.get(l) - 1);
                minus--;
            }
        }

        int ans = 0;

        for(int key : map.keySet()){
            if(map.get(key) != 0){
                ans++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        int solution2 = sol.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        int solution3 = sol.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
