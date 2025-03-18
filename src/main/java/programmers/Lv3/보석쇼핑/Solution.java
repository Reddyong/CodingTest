package programmers.Lv3.보석쇼핑;

import java.util.*;

class Solution {
    private int start, end, size, len;
    private Map<String, Integer> map;
    private int[] answer;
    public int[] solution(String[] gems) {
        init(gems);
        solve(gems);

        return answer;
    }

    private void solve(String[] gems){
        for(int i = 0, j = 0; i < gems.length; i++){
            while(map.size() < size && j < gems.length){
                map.put(gems[j], map.getOrDefault(gems[j], 0) + 1);
                j++;
            }

            if(j - i < end - start && map.size() == size){
                start = i;
                end = j;
            }

            map.put(gems[i], map.get(gems[i]) - 1);

            if(map.get(gems[i]) == 0){
                map.remove(gems[i]);
            }
        }

        answer = new int[]{start + 1, end};
    }

    private void init(String[] gems){
        Set<String> set = new HashSet<>();

        for(String gem : gems){
            set.add(gem);
        }

        size = set.size();
        map = new HashMap<>();
        start = 0;
        end = gems.length;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        int[] solution2 = sol.solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
        int[] solution3 = sol.solution(new String[]{"XYZ", "XYZ", "XYZ"});
        int[] solution4 = sol.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));
        System.out.println("solution4 = " + Arrays.toString(solution4));
    }
}