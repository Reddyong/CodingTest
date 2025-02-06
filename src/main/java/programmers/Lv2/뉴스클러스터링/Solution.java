package programmers.Lv2.뉴스클러스터링;

import java.util.*;

class Solution {
    private int answer;
    private final int NUM = 65536;
    private List<String> list1;
    private List<String> list2;
    private List<String> union;
    private List<String> intersection;
    public int solution(String str1, String str2) {
        init();
        solve(str1, str2);

        return answer;
    }

    private void solve(String str1, String str2){
        list1 = changeToStrSet(str1);
        list2 = changeToStrSet(str2);

        getIntersection();
        getUnion();

        double jacard = 0;
        if(union.size() == 0){
            jacard = 1;
        } else{
            jacard = (double) intersection.size() / (double) union.size();
        }

        answer = (int) (jacard * NUM);
    }

    private void getUnion(){
        for(String str : list2){
            union.add(str);
        }
    }

    private void getIntersection(){
        for(String str : list1){
            if(list2.contains(str)){
                list2.remove(str);
                intersection.add(str);
            }
            union.add(str);
        }
    }

    private List<String> changeToStrSet(String str){
        char[] arr = str.toCharArray();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < arr.length - 1; i++){
            char cur = arr[i];
            char next = arr[i + 1];

            if(Character.isAlphabetic(cur) && Character.isAlphabetic(next)){
                list.add(str.substring(i, i + 2).toLowerCase());
            }
        }

        return list;
    }

    private void init(){
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        union = new ArrayList<>();
        intersection = new ArrayList<>();
        answer = 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution("FRANCE", "french");
        int solution2 = sol.solution("handshake", "shake hands");
        int solution3 = sol.solution("aa1+aa2", "AAAA12");
        int solution4 = sol.solution("E=M*C^2", "e=m*c^2");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution4 = " + solution4);
    }
}
