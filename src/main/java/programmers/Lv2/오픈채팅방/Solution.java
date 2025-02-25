package programmers.Lv2.오픈채팅방;

import java.util.*;

class Solution {
    private Map<String, String> map;
    private String[] answer;
    public String[] solution(String[] record) {
        solve(record);

        return answer;
    }

    private void solve(String[] record){
        map = new HashMap<>();
        int len = 0;
        String[] split;

        for(String r : record){
            split = r.split(" ");

            if(split[0].equals("Enter") || split[0].equals("Leave")){
                len++;
                if(split[0].equals("Leave")){
                    continue;
                }
            }

            if(split[0].equals("Enter") || split[0].equals("Change")){
                map.put(split[1], split[2]);
            }
        }

        answer = new String[len];
        int idx = 0;

        for(String r : record){
            split = r.split(" ");
            String name = map.get(split[1]);

            if(split[0].equals("Enter")){
                answer[idx] = name + "님이 들어왔습니다.";
            } else if(split[0].equals("Leave")){
                answer[idx] = name + "님이 나갔습니다.";
            } else{
                continue;
            }

            idx++;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] solution = sol.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});

        System.out.println("solution = " + Arrays.toString(solution));
    }
}