package programmers.Lv2.메뉴리뉴얼;

import java.util.*;

class Solution {
    private String str;
    private Map<String, Integer> map;
    private boolean[] visited;
    private int[] save;
    private String[] answer;
    public String[] solution(String[] orders, int[] course) {
        solve(orders, course);

        return answer;
    }

    private void solve(String[] orders, int[] course){
        map = new HashMap<>();
        save = new int[course.length];

        for(int i = 0; i < orders.length; i++){
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            str = String.valueOf(c);

            for(int j = 0; j < course.length; j++){
                visited = new boolean[str.length()];
                dfs("", 0, 0, course[j], j);
            }
        }


        List<String> temp = new ArrayList<>();
        for(String key : map.keySet()){
            for(int i = 0; i < course.length; i++){
                if(course[i] == key.length() && save[i] >= 2 && save[i] == map.get(key)){
                    temp.add(key);
                }
            }
        }

        answer = new String[temp.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = temp.get(i);
        }

        Arrays.sort(answer);

    }

    private void dfs(String cur, int idx, int depth, int c, int j){
        if(depth == c){
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            save[j] = Math.max(map.get(cur), save[j]);
            return;
        }

        for(int i = idx; i < str.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(cur + String.valueOf(str.charAt(i)), i + 1, depth + 1, c, j);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] solution1 = sol.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        String[] solution2 = sol.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5});
        String[] solution3 = sol.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));
    }
}
