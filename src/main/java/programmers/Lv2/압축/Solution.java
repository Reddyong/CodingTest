package programmers.Lv2.압축;

import java.util.*;

class Solution {
    private Map<String, Integer> map;
    private List<Integer> list;
    private int[] answer;
    private int startMsgIdx;
    private int lastMapIdx;
    public int[] solution(String msg) {
        init();
        solve(msg);

        return answer;
    }

    private void solve(String msg){
        while(startMsgIdx < msg.length()){
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(startMsgIdx));

            int endMsgIdx = startMsgIdx + 1;

            while(endMsgIdx < msg.length() && map.containsKey(sb.toString() + msg.charAt(endMsgIdx))){
                sb.append(msg.charAt(endMsgIdx));
                endMsgIdx++;
            }

            list.add(map.get(sb.toString()));

            if(endMsgIdx < msg.length()){
                map.put(sb.toString() + msg.charAt(endMsgIdx), ++lastMapIdx);
            }

            startMsgIdx = endMsgIdx;
        }

        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
    }

    private void init(){
        char c = 'A';
        map = new HashMap<>();
        list = new ArrayList<>();
        lastMapIdx = 26;
        startMsgIdx = 0;

        for(int i = 1; i <= 26; i++){
            map.put(String.valueOf(c++), i);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution("KAKAO");
        int[] solution2 = sol.solution("TOBEORNOTTOBEORTOBEORNOT");
        int[] solution3 = sol.solution("ABABABABABABABAB");

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));
    }
}
