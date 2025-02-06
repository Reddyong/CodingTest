package programmers.Lv2.전화번호목록;

import java.util.*;

class Solution {
    private Map<String, Integer> map;
    public boolean solution(String[] phone_book) {
        init(phone_book);

        boolean answer = solve(phone_book);

        return answer;
    }

    private boolean solve(String[] phone_book){
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }

        return true;
    }

    private void init(String[] phone_book){
        map = new HashMap<>();

        for(int i = 0; i < phone_book.length; i++){
            map.put(phone_book[i], i);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean solution1 = sol.solution(new String[]{"119", "97674223", "1195524421"});
        boolean solution2 = sol.solution(new String[]{"123", "456", "789"});
        boolean solution3 = sol.solution(new String[]{"12", "123", "1235", "567", "88"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
