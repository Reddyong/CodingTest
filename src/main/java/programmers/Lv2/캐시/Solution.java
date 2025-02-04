package programmers.Lv2.캐시;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int answer;
    Queue<String> queue;
    public int solution(int cacheSize, String[] cities) {
        init();
        solve(cacheSize, cities);

        return answer;
    }

    private void solve(int cacheSize, String[] cities){
        if(cacheSize == 0){
            answer = 5 * cities.length;
            return;
        }

        for(String city : cities){
            city = city.toLowerCase();

            if(queue.isEmpty()){
                queue.add(city);
                answer += 5;
                continue;
            }

            if(queue.contains(city)){
                answer += 1;
                queue.remove(city);
            } else{
                answer += 5;
            }

            if(queue.size() == cacheSize){
                queue.poll();
            }

            queue.add(city);

        }
    }

    private void init(){
        answer = 0;
        queue = new LinkedList<>();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
        int solution2 = sol.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"});
        int solution3 = sol.solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
        int solution4 = sol.solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
        int solution5 = sol.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
        int solution6 = sol.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution4 = " + solution4);
        System.out.println("solution5 = " + solution5);
        System.out.println("solution6 = " + solution6);
    }
}
