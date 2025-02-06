package programmers.Lv2.롤케이크자르기;

import java.util.*;

class Solution {
    private Set<Integer> set;
    private Map<Integer, Integer> map;
    private int answer;
    public int solution(int[] topping) {
        init(topping);
        solve(topping);

        return answer;
    }

    private void solve(int[] topping){
        for(int t : topping){
            set.add(t);
            map.put(t, map.get(t) - 1);

            if(map.get(t) == 0){
                map.remove(t);
            }

            if(set.size() == map.keySet().size()){
                answer++;
            }
        }
    }

    private void init(int[] topping){
        set = new HashSet<>();
        map = new HashMap<>();
        answer = 0;

        for(int t : topping){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
        int solution2 = sol.solution(new int[]{1, 2, 3, 1, 4});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
