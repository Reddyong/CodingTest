package programmers.Lv2.귤고르기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    public int solution(int k, int[] tangerine) {
        init(tangerine);
        return solve(k);
    }

    private int solve(int k){
        int ans = 0;
        int sum = 0;

        for(int l : list){
            if(sum + map.get(l) >= k){
                ans++;
                break;
            }

            sum += map.get(l);
            ans++;
        }

        return ans;
    }

    private void init(int[] tangerine){
        map = new HashMap<>();

        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
    }
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int solution1 = sol.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        int solution2 = sol.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        int solution3 = sol.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
